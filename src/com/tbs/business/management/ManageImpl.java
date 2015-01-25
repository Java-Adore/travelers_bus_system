package com.tbs.business.management;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.business.service.GetInfoService;
import com.tbs.business.service.TourPackageService;
import com.tbs.business.service.TourSalesService;
import com.tbs.business.service.TravelerService;
import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Stateless
public class ManageImpl implements Manageable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	GetInfoService getInfoService;
	@EJB
	TourPackageService tourPackageSrvice;
	@EJB
	TourSalesService tourSalesService;
	@EJB
	TravelerService travellerSrvice;

	@Override
	public List<TourSales> getAllTourSales() throws TBSException {
		// TODO Auto-generated method stub
		return getInfoService.getAllTourSales();
	}

	@Override
	public List<TourPackage> getAllTourPackages() throws TBSException {
		// TODO Auto-generated method stub
		return getInfoService.getAllTourPackages();
	}
	

	@Override
	public List<Traveler> getAllTravelers() throws TBSException {
		// TODO Auto-generated method stub
		return getInfoService.getAllTravelers();
	}
	
	@Override
	public TourPackage addNewTourPackage(String tourCode,
			String vehicleNumberPlate, Date tourDate, String departFrom,
			String detination) throws TBSException {
		
		TourPackage tourPackage = new TourPackage(tourCode, vehicleNumberPlate, tourDate, departFrom, detination);
				
		return tourPackageSrvice.addNewTourPackage(tourPackage);
	}
	

	@Override
	public TourSales addTourSales(Long selectedTourPackage,
			Long selectedTraveller) throws TBSException{
		
		return tourSalesService.addTourSales(selectedTourPackage, selectedTraveller);
	}

	@Override
	public DomesticTraveler addDomesticTraveller(String firstName,
			String lastName, String residentialAddress,
			String contactTelephone, String emailAddress,
			String photoIdentificationType, String photoIdentificationIssuer,
			String photoIdentificationNumber) throws TBSException {
		
		DomesticTraveler domesticTraveller = new DomesticTraveler(firstName, lastName, residentialAddress, contactTelephone, emailAddress, photoIdentificationType, photoIdentificationIssuer, photoIdentificationNumber);
		
		try {
			return (DomesticTraveler) travellerSrvice.addDomesticTraveler(domesticTraveller);
		} catch (Exception e) {

			throw new TBSException("Domestic traveler not added");
		}
	}

	@Override
	public InternationalTraveler addInternationalTraveller(String firstName,
			String lastName, String residentialAddress,
			String contactTelephone, String emailAddress,
			String passportNumber, String passportCountry, String visaNumber) throws TBSException {
		
		InternationalTraveler internationalTraveller = new InternationalTraveler(firstName, lastName, residentialAddress, contactTelephone, emailAddress, passportNumber, passportCountry, visaNumber);
		try {
			return (InternationalTraveler) travellerSrvice.addInternationalTraveler(internationalTraveller);
		} catch (Exception e) {
			throw new TBSException("International Traveler not added");
		}
	}
}
