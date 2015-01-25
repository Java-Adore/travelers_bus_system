package com.tbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Singleton
public class TravelerDAOImpl extends AbstractDAO<Traveler> implements TravelerDAO{

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public TravelerDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public Traveler addTraveler(Traveler traveler) {

		return super.persist(traveler);
	}

	@Override
	public Traveler addDomesticTraveler(DomesticTraveler domesticTraveler) {
		return super.persist(domesticTraveler);
	}

	@Override
	public Traveler addInternationalTraveler(InternationalTraveler internationalTraveler) {
		return super.persist(internationalTraveler);
	}

	@Override
	public List<Traveler> getAllTravelers() throws TBSException {
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<Traveler> result = null;
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from Traveler t");
			
			result = query.getResultList();
			transaction.commit();
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			throw new RuntimeException();
		}
		
		return result;
	}

	@Override
	public Traveler getTravelerByID(Long travelerID) throws TBSException {
		
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<Traveler> queryResult = new ArrayList();
		Traveler traveller = null;
		
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from Traveler t where t.ID=:travellerID");
			query.setParameter("travellerID", travelerID);
			
			queryResult = query.getResultList();
			if(queryResult.size()>0)
			{
				traveller = queryResult.get(0);
			}
			
			transaction.commit();
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			throw new RuntimeException();
		}
		
		return traveller;
	}
	
}
