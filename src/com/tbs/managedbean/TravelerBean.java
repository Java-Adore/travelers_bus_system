package com.tbs.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.JSFMessageUtilities;
import com.tbs.business.management.Manageable;
import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class TravelerBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	Manageable manage;

	private String firstName;

	private String lastName;
	
	private String residentialAddress;
	
	private String contactTelephone;

	private String emailAddress;
	
	//for domestic traveller
	private String photoIdentificationType;
	
	private String photoIdentificationIssuer;
	
	private String photoIdentificationNumber;

	//for international traveller
	private String passportNumber;
	
	private String passportCountry;
	
	private String visaNumber;
	
	private boolean localTraveler=true;
//	private boolean internationalFlag;
	
//	private String travelerType="domestic";
	
	public boolean isLocalTraveler() {
		return localTraveler;
	}

	public void setLocalTraveler(boolean localTraveler) {
		this.localTraveler = localTraveler;
	}

	@PostConstruct
	public void init(){
		
//		internationalFlag=false;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getContactTelephone() {
		return contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhotoIdentificationType() {
		return photoIdentificationType;
	}

	public void setPhotoIdentificationType(String photoIdentificationType) {
		this.photoIdentificationType = photoIdentificationType;
	}

	public String getPhotoIdentificationIssuer() {
		return photoIdentificationIssuer;
	}

	public void setPhotoIdentificationIssuer(String photoIdentificationIssuer) {
		this.photoIdentificationIssuer = photoIdentificationIssuer;
	}

	public String getPhotoIdentificationNumber() {
		return photoIdentificationNumber;
	}

	public void setPhotoIdentificationNumber(String photoIdentificationNumber) {
		this.photoIdentificationNumber = photoIdentificationNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportCountry() {
		return passportCountry;
	}

	public void setPassportCountry(String passportCountry) {
		this.passportCountry = passportCountry;
	}

	public String getVisaNumber() {
		return visaNumber;
	}

	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}
	



	public void addNewTraveller(){
		
		try {
			
			DomesticTraveler domesticTraveller=null;
			InternationalTraveler internationalTraveller=null;
			
			if(localTraveler){
				if(contactTelephone.length()<=10){
					domesticTraveller = manage.addDomesticTraveller(firstName, lastName, residentialAddress, contactTelephone, emailAddress, photoIdentificationType, photoIdentificationIssuer, photoIdentificationNumber);
					JSFMessageUtilities.addInfoMessage("Domestic traveler added successfully");
				}
				else
					JSFMessageUtilities.addInfoMessage("Domestic telephoe length must be less than 10");
			
			}
			else if(!localTraveler){
				
				internationalTraveller = manage.addInternationalTraveller(firstName, lastName, residentialAddress, contactTelephone, emailAddress, passportNumber, passportCountry, visaNumber);
				JSFMessageUtilities.addInfoMessage("International traveler added successfully");
			}
				
			
			resetAttributes();
			
			
		} catch (TBSException e) {

			JSFMessageUtilities.addErrorMessage(e.getMessageToDisplay());
		}
	}
	
	public void resetAttributes(){
		this.firstName="";
		this.lastName="";
		this.residentialAddress="";
		this.contactTelephone="";
		this.emailAddress="";
		this.photoIdentificationType="";
		this.photoIdentificationIssuer="";
		this.photoIdentificationNumber="";
		this.passportNumber="";
		this.passportCountry="";
		this.visaNumber="";
		
	}
}
