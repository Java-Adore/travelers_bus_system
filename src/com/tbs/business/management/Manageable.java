package com.tbs.business.management;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface Manageable extends Serializable{
	
	//Common Methods
	public List<TourPackage> getAllTourPackages() throws TBSException;
	public List<Traveler> getAllTravelers() throws TBSException;
	
	//GetInformation methods
	public List<TourSales> getAllTourSales() throws TBSException;
	
	
	//TourPackage methods
	public TourPackage addNewTourPackage(String tourCode, String vehicleNumberPlate, Date tourDate, String departFrom, String detination) throws TBSException;
	
	//TourSales methods

	public TourSales addTourSales(Long selectedTourPackage, Long selectedTraveller) throws TBSException;
	
	//Traveller methods
	public DomesticTraveler addDomesticTraveller(String firstName, String lastName, String residentialAddress,
			String contactTelephone, String emailAddress, String photoIdentificationType,
			String photoIdentificationIssuer, String photoIdentificationNumber) throws TBSException;
	
	public InternationalTraveler addInternationalTraveller(String firstName, String lastName, String residentialAddress,
			String contactTelephone, String emailAddress, String passportNumber,
			String passportCountry, String visaNumber) throws TBSException;
}
