//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.02.25 at 12:02:43 PM CET 
//


package ietf.params.xml.ns.epp_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transferOpType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="transferOpType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="approve"/>
 *     &lt;enumeration value="cancel"/>
 *     &lt;enumeration value="query"/>
 *     &lt;enumeration value="reject"/>
 *     &lt;enumeration value="request"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "transferOpType")
@XmlEnum
public enum TransferOpType {

    @XmlEnumValue("approve")
    APPROVE("approve"),
    @XmlEnumValue("cancel")
    CANCEL("cancel"),
    @XmlEnumValue("query")
    QUERY("query"),
    @XmlEnumValue("reject")
    REJECT("reject"),
    @XmlEnumValue("request")
    REQUEST("request");
    private final String value;

    TransferOpType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransferOpType fromValue(String v) {
        for (TransferOpType c: TransferOpType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
