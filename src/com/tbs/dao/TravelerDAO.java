package com.tbs.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;


@Local
public interface TravelerDAO extends Serializable{
	
	public Traveler addTraveler(Traveler traveler);
	
	public Traveler addDomesticTraveler(DomesticTraveler domesticTraveler) throws TBSException;
	
	public Traveler addInternationalTraveler(InternationalTraveler internationalTraveler) throws TBSException;
	
	public List<Traveler> getAllTravelers() throws TBSException;

	public Traveler getTravelerByID(Long travelerID) throws TBSException;
}
