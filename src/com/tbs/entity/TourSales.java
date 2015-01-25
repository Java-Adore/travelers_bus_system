package com.tbs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tbs.general.DTO;


@Entity
@Table(name="tour_sales")
public class TourSales implements DTO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@ManyToOne
	@JoinColumn(name="tour_package_id", referencedColumnName="ID")
	private TourPackage tourPackage;
	
	@ManyToOne
	@JoinColumn(name="traveler_id", referencedColumnName="ID")
	private Traveler traveler;
	
	
	public TourSales(){
		
	}
	public TourSales(TourPackage tourPackage, Traveler traveler) {
		this.setTourPackage(tourPackage);
		this.setTraveler(traveler);
	}

	@Override
	public Long getID() {
		return ID;
	}

	@Override
	public void setID(Long ID) {
		this.ID=ID;

	}

	public TourPackage getTourPackage() {
		return tourPackage;
	}

	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}

	public Traveler getTraveler() {
		return traveler;
	}
	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TourSales other = (TourSales) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
	

}
