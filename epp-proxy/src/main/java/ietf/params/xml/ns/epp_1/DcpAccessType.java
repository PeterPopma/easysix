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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dcpAccessType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dcpAccessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="all" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="none" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="null" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="other" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="personal" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="personalAndOther" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dcpAccessType", propOrder = {
    "all",
    "none",
    "_null",
    "other",
    "personal",
    "personalAndOther"
})
public class DcpAccessType {

    protected Object all;
    protected Object none;
    @XmlElement(name = "null")
    protected Object _null;
    protected Object other;
    protected Object personal;
    protected Object personalAndOther;

    /**
     * Gets the value of the all property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAll() {
        return all;
    }

    /**
     * Sets the value of the all property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAll(Object value) {
        this.all = value;
    }

    /**
     * Gets the value of the none property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getNone() {
        return none;
    }

    /**
     * Sets the value of the none property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setNone(Object value) {
        this.none = value;
    }

    /**
     * Gets the value of the null property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getNull() {
        return _null;
    }

    /**
     * Sets the value of the null property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setNull(Object value) {
        this._null = value;
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
     * Gets the value of the personal property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPersonal() {
        return personal;
    }

    /**
     * Sets the value of the personal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPersonal(Object value) {
        this.personal = value;
    }

    /**
     * Gets the value of the personalAndOther property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPersonalAndOther() {
        return personalAndOther;
    }

    /**
     * Sets the value of the personalAndOther property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPersonalAndOther(Object value) {
        this.personalAndOther = value;
    }

}
