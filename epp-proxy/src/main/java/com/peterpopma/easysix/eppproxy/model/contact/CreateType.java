//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.02.25 at 12:02:43 PM CET 
//


package com.peterpopma.easysix.eppproxy.model.contact;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for createType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{urn:ietf:params:xml:ns:eppcom-1.0}clIDType"/>
 *         &lt;element name="postalInfo" type="{urn:ietf:params:xml:ns:contact-1.0}postalInfoType" maxOccurs="2"/>
 *         &lt;element name="voice" type="{urn:ietf:params:xml:ns:contact-1.0}e164Type" minOccurs="0"/>
 *         &lt;element name="fax" type="{urn:ietf:params:xml:ns:contact-1.0}e164Type" minOccurs="0"/>
 *         &lt;element name="email" type="{urn:ietf:params:xml:ns:eppcom-1.0}minTokenType"/>
 *         &lt;element name="authInfo" type="{urn:ietf:params:xml:ns:contact-1.0}authInfoType"/>
 *         &lt;element name="disclose" type="{urn:ietf:params:xml:ns:contact-1.0}discloseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createType", propOrder = {
    "id",
    "postalInfo",
    "voice",
    "fax",
    "email",
    "authInfo",
    "disclose"
})
public class CreateType {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String id;
    @XmlElement(required = true)
    protected List<PostalInfoType> postalInfo;
    protected E164Type voice;
    protected E164Type fax;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String email;
    @XmlElement(required = true)
    protected AuthInfoType authInfo;
    protected DiscloseType disclose;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the postalInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postalInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostalInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostalInfoType }
     * 
     * 
     */
    public List<PostalInfoType> getPostalInfo() {
        if (postalInfo == null) {
            postalInfo = new ArrayList<PostalInfoType>();
        }
        return this.postalInfo;
    }

    /**
     * Gets the value of the voice property.
     * 
     * @return
     *     possible object is
     *     {@link E164Type }
     *     
     */
    public E164Type getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     * 
     * @param value
     *     allowed object is
     *     {@link E164Type }
     *     
     */
    public void setVoice(E164Type value) {
        this.voice = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link E164Type }
     *     
     */
    public E164Type getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link E164Type }
     *     
     */
    public void setFax(E164Type value) {
        this.fax = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the authInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AuthInfoType }
     *     
     */
    public AuthInfoType getAuthInfo() {
        return authInfo;
    }

    /**
     * Sets the value of the authInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthInfoType }
     *     
     */
    public void setAuthInfo(AuthInfoType value) {
        this.authInfo = value;
    }

    /**
     * Gets the value of the disclose property.
     * 
     * @return
     *     possible object is
     *     {@link DiscloseType }
     *     
     */
    public DiscloseType getDisclose() {
        return disclose;
    }

    /**
     * Sets the value of the disclose property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscloseType }
     *     
     */
    public void setDisclose(DiscloseType value) {
        this.disclose = value;
    }

}
