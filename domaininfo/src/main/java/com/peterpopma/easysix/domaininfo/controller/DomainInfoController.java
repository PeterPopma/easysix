package nl.sidn.drs.domaininfo.controller;

import ietf.params.xml.ns.domain_1.InfoType;
import ietf.params.xml.ns.epp_1.EppType;
import ietf.params.xml.ns.epp_1.ReadWriteType;
import nl.sidn.drs.domaininfo.dao.DomainRepository;
import nl.sidn.drs.domaininfo.dto.request.DomainInfo;
import nl.sidn.drs.domaininfo.service.DomainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringReader;


@RestController
@RequestMapping("")
public class DomainInfoController {

    @Autowired
    DomainInfoService domainInfoService;

    @PostMapping("/epp/command/info")
    public EppType domainInfo(@RequestBody EppType eppRequest, @RequestHeader("username") String username)
    {
        ReadWriteType info = eppRequest.getCommand().getInfo();
        // TODO : this should yield an InfoType object.. is the objectfactory of domain not seen??
        Element element = (Element) info.getAny();
        Node node = element.getFirstChild().getFirstChild();
        String domainName = node.getNodeValue();

        return domainInfoService.findDomainByName(domainName, username);
    }
}
