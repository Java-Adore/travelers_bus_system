package com.tbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tbs.entity.TourPackage;
import com.tbs.general.TBSException;

@Singleton
public class TourPackageDAOImpl extends AbstractDAO<TourPackage> implements TourPackageDAO{

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public TourPackageDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public TourPackage addTourPackage(TourPackage tourPackage) throws TBSException{
		try{
			return super.persist(tourPackage);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	

	@Override
	public List<TourPackage> getAllTourPackages() throws TBSException{
		
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<TourPackage> result = null;
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from TourPackage t");
			
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
	public TourPackage getTourPackageByID(Long tourPackageID)
			throws TBSException {
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<TourPackage> queryResult = new ArrayList();
		TourPackage tour = null;
		
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from TourPackage t where t.ID=:tourPackageID");
			query.setParameter("tourPackageID", tourPackageID);
			
			queryResult = query.getResultList();
			if(queryResult.size()>0)
			{
				tour = queryResult.get(0);
			}
			
			transaction.commit();
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			throw new RuntimeException();
		}
		
		return tour;
	}

	@Override
	public TourPackage getTourPackage(TourPackage tourPackage) throws TBSException{
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<TourPackage> queryResult = new ArrayList();
		TourPackage tour = null;
		
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from TourPackage t where t.tourCode=:tourCode");
			query.setParameter("tourCode", tourPackage.getTourCode());
			
			queryResult = query.getResultList();
			if(queryResult.size()>0)
			{
				tour = queryResult.get(0);
			}
			
			transaction.commit();
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			throw new RuntimeException();
		}
		
		return tour;
	}
	
	
}
