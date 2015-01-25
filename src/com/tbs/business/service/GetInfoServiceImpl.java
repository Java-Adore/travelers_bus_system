package com.tbs.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.TourPackageDAO;
import com.tbs.dao.TourSalesDAO;
import com.tbs.dao.TravelerDAO;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Stateless
public class GetInfoServiceImpl implements GetInfoService {

	private static final long serialVersionUID = 1L;
	
	
	@EJB
	TourSalesDAO tourSalesDAO;

	@EJB
	TourPackageDAO tourPackageDAO;
	
	@EJB
	TravelerDAO travelerDAO;

	@Override
	public List<TourSales> getAllTourSales() throws TBSException {
		
		return tourSalesDAO.getAllTourSales();
	}


	@Override
	public List<TourPackage> getAllTourPackages() throws TBSException {
		// TODO Auto-generated method stub
		return tourPackageDAO.getAllTourPackages();
	}


	@Override
	public List<Traveler> getAllTravelers() throws TBSException {
		// TODO Auto-generated method stub
		return travelerDAO.getAllTravelers();
	}


	
	
}
