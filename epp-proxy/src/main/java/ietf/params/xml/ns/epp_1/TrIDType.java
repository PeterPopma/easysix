//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.02.25 at 12:02:43 PM CET 
//


package ietf.params.xml.ns.epp_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for trIDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trIDType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clTRID" type="{urn:ietf:params:xml:ns:epp-1.0}trIDStringType" minOccurs="0"/>
 *         &lt;element name="svTRID" type="{urn:ietf:params:xml:ns:epp-1.0}trIDStringType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trIDType", propOrder = {
    "clTRID",
    "svTRID"
})
public class TrIDType {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String clTRID;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String svTRID;

    /**
     * Gets the value of the clTRID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClTRID() {
        return clTRID;
    }

    /**
     * Sets the value of the clTRID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClTRID(String value) {
        this.clTRID = value;
    }

    /**
     * Gets the value of the svTRID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvTRID() {
        return svTRID;
    }

    /**
     * Sets the value of the svTRID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvTRID(String value) {
        this.svTRID = value;
    }

}
