package com.tbs.business.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface TourSalesService extends Serializable{

	public List<Traveler> getAllTravelers() throws TBSException;
	
	public List<TourPackage> getAllTourPackages() throws TBSException;

	public TourSales addTourSales(Long tourPackageID, Long travelerID) throws TBSException;
}
