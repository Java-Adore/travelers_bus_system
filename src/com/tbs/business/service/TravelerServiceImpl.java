package com.tbs.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.TravelerDAO;
import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Stateless
public class TravelerServiceImpl implements TravelerService {

	private static final long serialVersionUID = 1L;
	
	@EJB
	TravelerDAO travelerDAO;

	@Override
	public Traveler addDomesticTraveler(DomesticTraveler domesticTraveler)
			throws TBSException {
		
		return travelerDAO.addDomesticTraveler(domesticTraveler);
	}

	@Override
	public Traveler addInternationalTraveler(
			InternationalTraveler internationalTraveler) throws TBSException {
		
		return travelerDAO.addInternationalTraveler(internationalTraveler);
	}

	@Override
	public List<Traveler> getAllTravelers() throws TBSException {
		
		return travelerDAO.getAllTravelers();
	}
	
	
}
