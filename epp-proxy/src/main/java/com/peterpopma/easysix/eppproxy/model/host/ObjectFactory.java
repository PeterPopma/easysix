//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.02.25 at 12:02:43 PM CET 
//


package com.peterpopma.easysix.eppproxy.model.host;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.peterpopma.easysix.eppproxy.model.host package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ChkData_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "chkData");
    private final static QName _CreData_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "creData");
    private final static QName _Check_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "check");
    private final static QName _Info_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "info");
    private final static QName _Create_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "create");
    private final static QName _Delete_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "delete");
    private final static QName _InfData_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "infData");
    private final static QName _Update_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "update");
    private final static QName _PanData_QNAME = new QName("urn:ietf:params:xml:ns:host-1.0", "panData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.peterpopma.easysix.eppproxy.model.host
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreDataType }
     * 
     */
    public CreDataType createCreDataType() {
        return new CreDataType();
    }

    /**
     * Create an instance of {@link ChkDataType }
     * 
     */
    public ChkDataType createChkDataType() {
        return new ChkDataType();
    }

    /**
     * Create an instance of {@link CreateType }
     * 
     */
    public CreateType createCreateType() {
        return new CreateType();
    }

    /**
     * Create an instance of {@link UpdateType }
     * 
     */
    public UpdateType createUpdateType() {
        return new UpdateType();
    }

    /**
     * Create an instance of {@link PanDataType }
     * 
     */
    public PanDataType createPanDataType() {
        return new PanDataType();
    }

    /**
     * Create an instance of {@link InfDataType }
     * 
     */
    public InfDataType createInfDataType() {
        return new InfDataType();
    }

    /**
     * Create an instance of {@link MNameType }
     * 
     */
    public MNameType createMNameType() {
        return new MNameType();
    }

    /**
     * Create an instance of {@link SNameType }
     * 
     */
    public SNameType createSNameType() {
        return new SNameType();
    }

    /**
     * Create an instance of {@link CheckType }
     * 
     */
    public CheckType createCheckType() {
        return new CheckType();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link ChgType }
     * 
     */
    public ChgType createChgType() {
        return new ChgType();
    }

    /**
     * Create an instance of {@link PaNameType }
     * 
     */
    public PaNameType createPaNameType() {
        return new PaNameType();
    }

    /**
     * Create an instance of {@link CheckNameType }
     * 
     */
    public CheckNameType createCheckNameType() {
        return new CheckNameType();
    }

    /**
     * Create an instance of {@link AddRemType }
     * 
     */
    public AddRemType createAddRemType() {
        return new AddRemType();
    }

    /**
     * Create an instance of {@link AddrType }
     * 
     */
    public AddrType createAddrType() {
        return new AddrType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChkDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "chkData")
    public JAXBElement<ChkDataType> createChkData(ChkDataType value) {
        return new JAXBElement<ChkDataType>(_ChkData_QNAME, ChkDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "creData")
    public JAXBElement<CreDataType> createCreData(CreDataType value) {
        return new JAXBElement<CreDataType>(_CreData_QNAME, CreDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MNameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "check")
    public JAXBElement<MNameType> createCheck(MNameType value) {
        return new JAXBElement<MNameType>(_Check_QNAME, MNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SNameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "info")
    public JAXBElement<SNameType> createInfo(SNameType value) {
        return new JAXBElement<SNameType>(_Info_QNAME, SNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "create")
    public JAXBElement<CreateType> createCreate(CreateType value) {
        return new JAXBElement<CreateType>(_Create_QNAME, CreateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SNameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "delete")
    public JAXBElement<SNameType> createDelete(SNameType value) {
        return new JAXBElement<SNameType>(_Delete_QNAME, SNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "infData")
    public JAXBElement<InfDataType> createInfData(InfDataType value) {
        return new JAXBElement<InfDataType>(_InfData_QNAME, InfDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "update")
    public JAXBElement<UpdateType> createUpdate(UpdateType value) {
        return new JAXBElement<UpdateType>(_Update_QNAME, UpdateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PanDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:host-1.0", name = "panData")
    public JAXBElement<PanDataType> createPanData(PanDataType value) {
        return new JAXBElement<PanDataType>(_PanData_QNAME, PanDataType.class, null, value);
    }

}
