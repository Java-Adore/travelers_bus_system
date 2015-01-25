package com.tbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.tbs.general.DTO;

@Entity
@Table(name="tour_packages")
public class TourPackage implements Serializable, DTO {
	
	public TourPackage(){
		
	}
	public TourPackage(String tourCode, String vehicleNumberPlate, Date tourDate, String departFrom, String detination){
		this.tourCode=tourCode;
		this.vehicleNumberPlate=vehicleNumberPlate;
		this.tourDate=tourDate;
		this.departFrom=departFrom;
		this.detination=detination;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@Column(name="tour_code", nullable=false, unique=true)
	private String tourCode;
	
	@Column(name="vehicle_number_plate", nullable=false)
	private String vehicleNumberPlate;
	
	@Column(name="tour_date", nullable=false)
	private Date tourDate;
	
	@Column(name="depart_from", nullable=false)
	private String departFrom;
	
	@Column(name="detination", nullable=false)
	private String detination;
	
	@ManyToMany
    @JoinTable(name="tour_sales",
        joinColumns=
            @JoinColumn(name="tour_package_id", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="traveler_id", referencedColumnName="ID")
        )
    private List<Traveler> travelers;	
	
	@Override
	public Long getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public void setID(Long ID) {
		this.ID=ID;
	}
	
	
	public String getTourCode() {
		return tourCode;
	}

	public void setTourCode(String tourCode) {
		this.tourCode = tourCode;
	}

	public String getVehicleNumberPlate() {
		return vehicleNumberPlate;
	}

	public void setVehicleNumberPlate(String vehicleNumberPlate) {
		this.vehicleNumberPlate = vehicleNumberPlate;
	}

	public Date getTourDate() {
		return tourDate;
	}

	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

	public String getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	public String getDetination() {
		return detination;
	}

	public void setDetination(String detination) {
		this.detination = detination;
	}
	

	public List<Traveler> getTravelers() {
		return travelers;
	}
	public void setTravelers(List<Traveler> travelers) {
		this.travelers = travelers;
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
		TourPackage other = (TourPackage) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	

}
