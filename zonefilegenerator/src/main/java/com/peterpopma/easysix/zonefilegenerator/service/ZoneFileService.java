package com.peterpopma.easysix.zonefilegenerator.service;

import com.peterpopma.easysix.zonefilegenerator.entity.DomainEntity;
import com.peterpopma.easysix.zonefilegenerator.entity.HostEntity;
import com.peterpopma.easysix.zonefilegenerator.repository.DomainRepository;
import com.peterpopma.easysix.zonefilegenerator.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ZoneFileService {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private HostRepository hostRepository;

    public String generateZoneFile(UUID domainId) {
        Optional<DomainEntity> domainOpt = domainRepository.findById(domainId);
        DomainEntity domain = domainOpt.orElseThrow(() ->
                new IllegalArgumentException("Domain not found with ID: " + domainId)
        );

        List<HostEntity> hosts = hostRepository.findByDomainId(domainId);
        List<String> nameservers = domain.getNameservers(); // Fixed method name

        StringBuilder zoneFile = new StringBuilder();

        // Add SOA Record
        zoneFile.append("$TTL 3600\n");
        zoneFile.append("@ IN SOA ns1.").append(domain.getName()).append(". admin.").append(domain.getName()).append(". (\n");
        zoneFile.append(" 2023101001 ; Serial\n");
        zoneFile.append(" 3600       ; Refresh\n");
        zoneFile.append(" 1800       ; Retry\n");
        zoneFile.append(" 1209600    ; Expire\n");
        zoneFile.append(" 3600 )     ; Minimum TTL\n\n");

        // Add NS Records
        for (String ns : nameservers) {
            zoneFile.append(domain.getName()).append(". 3600 IN NS ").append(ns).append(".\n");
        }

        // Add Glue Records
        for (String ns : nameservers) {
            if (isSubdomain(ns, domain.getName())) {
                HostEntity host = hosts.stream()
                        .filter(h -> h.getName().equals(ns))
                        .findFirst()
                        .orElseThrow(() ->
                                new IllegalStateException("Nameserver host not found: " + ns)
                        );

                // Add A records
                if (host.getIpv4() != null) {
                    for (String ipv4 : host.getIpv4()) {
                        zoneFile.append(ns).append(". 3600 IN A ").append(ipv4).append("\n");
                    }
                }

                // Add AAAA records
                if (host.getIpv6() != null) {
                    for (String ipv6 : host.getIpv6()) {
                        zoneFile.append(ns).append(". 3600 IN AAAA ").append(ipv6).append("\n");
                    }
                }
            }
        }

        return zoneFile.toString();
    }

    private boolean isSubdomain(String hostname, String domain) {
        return hostname.endsWith("." + domain) || hostname.equals(domain);
    }
}