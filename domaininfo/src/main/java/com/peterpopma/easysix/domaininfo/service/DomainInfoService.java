package nl.sidn.drs.domaininfo.service;

import ietf.params.xml.ns.epp_1.EppType;
import ietf.params.xml.ns.epp_1.ResponseType;
import lombok.extern.slf4j.Slf4j;
import nl.sidn.drs.domaininfo.dao.DomainRepository;
import nl.sidn.drs.model.DrpDomeinnaam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DomainInfoService {
    @Autowired
    DomainRepository domainRepository;

    public EppDocument findDomainByName(String domainName, String userName)
    {
        DrpDomeinnaam DrpDomeinnaam = domainRepository.findByNaam().get();
        EppType eppType = new EppType();
        ResponseType responseType = new ResponseType();
        eppType.setResponse(responseType);
        responseType.setResData();
    }
/*
    static EppOutput getErrorResponse(Result result, Trid trid) {
        return EppOutput.create(new EppResponse.Builder()
                .setResult(result)
                .setTrid(trid)
                .build());
    }
    */
 */
}
