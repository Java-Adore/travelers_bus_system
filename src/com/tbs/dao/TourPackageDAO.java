package com.tbs.dao;

import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.TourPackage;
import com.tbs.general.TBSException;

@Local
public interface TourPackageDAO {

	public TourPackage addTourPackage(TourPackage tourPackage) throws TBSException;
	
	public List<TourPackage> getAllTourPackages() throws TBSException;
	
	public TourPackage getTourPackageByID(Long tourPackageID) throws TBSException;

	public TourPackage getTourPackage(TourPackage tourPackage) throws TBSException;
}
