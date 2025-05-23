//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.02.25 at 12:02:43 PM CET 
//


package ietf.params.xml.ns.epp_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ietf.params.xml.ns.epp_1 package. 
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

    private final static QName _Epp_QNAME = new QName("urn:ietf:params:xml:ns:epp-1.0", "epp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ietf.params.xml.ns.epp_1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EppType }
     * 
     */
    public EppType createEppType() {
        return new EppType();
    }

    /**
     * Create an instance of {@link DcpAccessType }
     * 
     */
    public DcpAccessType createDcpAccessType() {
        return new DcpAccessType();
    }

    /**
     * Create an instance of {@link CommandType }
     * 
     */
    public CommandType createCommandType() {
        return new CommandType();
    }

    /**
     * Create an instance of {@link DcpStatementType }
     * 
     */
    public DcpStatementType createDcpStatementType() {
        return new DcpStatementType();
    }

    /**
     * Create an instance of {@link MixedMsgType }
     * 
     */
    public MixedMsgType createMixedMsgType() {
        return new MixedMsgType();
    }

    /**
     * Create an instance of {@link MsgType }
     * 
     */
    public MsgType createMsgType() {
        return new MsgType();
    }

    /**
     * Create an instance of {@link ExtURIType }
     * 
     */
    public ExtURIType createExtURIType() {
        return new ExtURIType();
    }

    /**
     * Create an instance of {@link LoginType }
     * 
     */
    public LoginType createLoginType() {
        return new LoginType();
    }

    /**
     * Create an instance of {@link ExtErrValueType }
     * 
     */
    public ExtErrValueType createExtErrValueType() {
        return new ExtErrValueType();
    }

    /**
     * Create an instance of {@link LoginSvcType }
     * 
     */
    public LoginSvcType createLoginSvcType() {
        return new LoginSvcType();
    }

    /**
     * Create an instance of {@link SvcMenuType }
     * 
     */
    public SvcMenuType createSvcMenuType() {
        return new SvcMenuType();
    }

    /**
     * Create an instance of {@link ResponseType }
     * 
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link ErrValueType }
     * 
     */
    public ErrValueType createErrValueType() {
        return new ErrValueType();
    }

    /**
     * Create an instance of {@link GreetingType }
     * 
     */
    public GreetingType createGreetingType() {
        return new GreetingType();
    }

    /**
     * Create an instance of {@link DcpType }
     * 
     */
    public DcpType createDcpType() {
        return new DcpType();
    }

    /**
     * Create an instance of {@link DcpOursType }
     * 
     */
    public DcpOursType createDcpOursType() {
        return new DcpOursType();
    }

    /**
     * Create an instance of {@link ResultType }
     * 
     */
    public ResultType createResultType() {
        return new ResultType();
    }

    /**
     * Create an instance of {@link CredsOptionsType }
     * 
     */
    public CredsOptionsType createCredsOptionsType() {
        return new CredsOptionsType();
    }

    /**
     * Create an instance of {@link DcpRetentionType }
     * 
     */
    public DcpRetentionType createDcpRetentionType() {
        return new DcpRetentionType();
    }

    /**
     * Create an instance of {@link DcpExpiryType }
     * 
     */
    public DcpExpiryType createDcpExpiryType() {
        return new DcpExpiryType();
    }

    /**
     * Create an instance of {@link PollType }
     * 
     */
    public PollType createPollType() {
        return new PollType();
    }

    /**
     * Create an instance of {@link ReadWriteType }
     * 
     */
    public ReadWriteType createReadWriteType() {
        return new ReadWriteType();
    }

    /**
     * Create an instance of {@link MsgQType }
     * 
     */
    public MsgQType createMsgQType() {
        return new MsgQType();
    }

    /**
     * Create an instance of {@link DcpPurposeType }
     * 
     */
    public DcpPurposeType createDcpPurposeType() {
        return new DcpPurposeType();
    }

    /**
     * Create an instance of {@link ExtAnyType }
     * 
     */
    public ExtAnyType createExtAnyType() {
        return new ExtAnyType();
    }

    /**
     * Create an instance of {@link TrIDType }
     * 
     */
    public TrIDType createTrIDType() {
        return new TrIDType();
    }

    /**
     * Create an instance of {@link TransferType }
     * 
     */
    public TransferType createTransferType() {
        return new TransferType();
    }

    /**
     * Create an instance of {@link DcpRecipientType }
     * 
     */
    public DcpRecipientType createDcpRecipientType() {
        return new DcpRecipientType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EppType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:epp-1.0", name = "epp")
    public JAXBElement<EppType> createEpp(EppType value) {
        return new JAXBElement<EppType>(_Epp_QNAME, EppType.class, null, value);
    }

}
