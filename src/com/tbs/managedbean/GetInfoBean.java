package com.tbs.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.JSFMessageUtilities;
import com.tbs.business.management.Manageable;
import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class GetInfoBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	Manageable manage;
	
	
	private List<TourPackage> tourPackages;
	
	private List<Traveler> travelers;
	
	private List<DomesticTraveler> domesticTravelers;
	
	private List<InternationalTraveler> internationalTravelers;
	
	@PostConstruct
	public void init(){
		
		try{
			tourPackages = manage.getAllTourPackages();
			travelers = manage.getAllTravelers();
			domesticTravelers= new ArrayList<>();
			internationalTravelers = new ArrayList<>();
			
			for(Traveler t : travelers)
			{
				if(t instanceof DomesticTraveler){
					domesticTravelers.add((DomesticTraveler)t);
				}
				else if(t instanceof InternationalTraveler){
					internationalTravelers.add((InternationalTraveler)t);
				}
			}
			
		} catch (TBSException e) {

			JSFMessageUtilities.addErrorMessage(e.getMessageToDisplay());
		}
	}
	
	
	public List<TourPackage> getTourPackages() {
	
		return tourPackages;
		
	}

	public void setTourPackages(List<TourPackage> tourPackages) {
		this.tourPackages = tourPackages;
	}

	public List<DomesticTraveler> getDomesticTravelers() {
		return domesticTravelers;
	}

	public void setDomesticTravelers(List<DomesticTraveler> domesticTravelers) {
		this.domesticTravelers = domesticTravelers;
	}

	public List<InternationalTraveler> getInternationalTravelers() {
		return internationalTravelers;
	}


	public void setInternationalTravelers(
			List<InternationalTraveler> internationalTravelers) {
		this.internationalTravelers = internationalTravelers;
	}

}
