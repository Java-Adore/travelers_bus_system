package com.tbs.business.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface TravelerService extends Serializable{

	public Traveler addDomesticTraveler(DomesticTraveler domesticTraveler) throws TBSException;
	
	public Traveler addInternationalTraveler(InternationalTraveler internationalTraveler) throws TBSException;

	public List<Traveler> getAllTravelers() throws TBSException;
}
