//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.02.25 at 12:02:43 PM CET 
//


package ietf.params.xml.ns.epp_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dcpPurposeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dcpPurposeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="admin" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="contact" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="other" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="prov" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dcpPurposeType", propOrder = {
    "admin",
    "contact",
    "other",
    "prov"
})
public class DcpPurposeType {

    protected Object admin;
    protected Object contact;
    protected Object other;
    protected Object prov;

    /**
     * Gets the value of the admin property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAdmin() {
        return admin;
    }

    /**
     * Sets the value of the admin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAdmin(Object value) {
        this.admin = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setContact(Object value) {
        this.contact = value;
    }

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setOther(Object value) {
        this.other = value;
    }

    /**
     * Gets the value of the prov property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getProv() {
        return prov;
    }

    /**
     * Sets the value of the prov property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setProv(Object value) {
        this.prov = value;
    }

}
