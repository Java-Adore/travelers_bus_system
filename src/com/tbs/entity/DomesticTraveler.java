package com.tbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tbs.general.DTO;

@Entity
@Table(name="domestic_travelers")
public class DomesticTraveler extends Traveler implements Serializable,DTO{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="photo_identification_type")
	private String photoIdentificationType;
	
	@Column(name="photo_identification_issuer")
	private String photoIdentificationIssuer;
	
	@Column(name="photo_identification_number")
	private String photoIdentificationNumber;

	public String getPhotoIdentificationType() {
		return photoIdentificationType;
	}
	
	public DomesticTraveler(){
		
	}
	
	public DomesticTraveler(String firstName, String lastName, String residentialAddress,
			String contactTelephone, String emailAddress, String photoIdentificationType,
			String photoIdentificationIssuer, String photoIdentificationNumber){
		
		setFirstName(firstName);
		setLastName(lastName);
		setResidentialAddress(residentialAddress);
		setContactTelephone(contactTelephone);
		setEmailAddress(emailAddress);
		this.photoIdentificationType=photoIdentificationType;
		this.photoIdentificationIssuer=photoIdentificationIssuer;
		this.photoIdentificationNumber=photoIdentificationNumber;
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
	
	

}
