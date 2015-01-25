package com.tbs.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.JSFMessageUtilities;
import com.tbs.business.management.Manageable;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class TourSalesDetailsBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@EJB
	Manageable manage;
	
	private List<TourPackage> tourPackages;
	
	private List<Traveler> travelers;
	
	
	private Long selectedTourPackageID;
	private Long selectedTravelerID;
	
	@PostConstruct
	public void init(){
		try {
			
			tourPackages = manage.getAllTourPackages();
			travelers = manage.getAllTravelers();
			
		} catch (TBSException e) {

			JSFMessageUtilities.addErrorMessage(e.getMessageToDisplay());
		}
	}
	
	public List<TourPackage> getTourPackages() {

		return tourPackages;
	}


	public List<Traveler> getTravelers() {
		
		return travelers;
	}


	public Long getSelectedTourPackageID() {
		return selectedTourPackageID;
	}


	public void setSelectedTourPackageID(Long selectedTourPackageID) {
		this.selectedTourPackageID = selectedTourPackageID;
	}


	public Long getSelectedTravelerID() {
		return selectedTravelerID;
	}


	public void setSelectedTravelerID(Long selectedTravelerID) {
		this.selectedTravelerID = selectedTravelerID;
	}


	public void addNewTourSalesDetails(){
		
		
		try {
			if(tourPackages.size()==0 && travelers.size()==0)
			{
				JSFMessageUtilities.addInfoMessage("No tour sales");
			}
			else if(selectedTourPackageID==null && selectedTravelerID==null){
				JSFMessageUtilities.addInfoMessage("Tour package and traveller are required");
			}
			else{
				manage.addTourSales(selectedTourPackageID, selectedTravelerID);
				JSFMessageUtilities.addInfoMessage("Tour sales added successfully");
			}
			
			
			
		} catch (TBSException e) {

			JSFMessageUtilities.addErrorMessage(e.getMessageToDisplay());
		}
	}
	
}
