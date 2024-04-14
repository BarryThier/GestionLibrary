package metier.entities;

import java.io.Serializable;
import java.sql.Date;

public class Subscriber implements Serializable{
	
	int numMatricule ;
	String name;
	String adresse;
	String phone;
	String dateAdh;
	String yearBirth;
	String professionalCategory;
	
	public Subscriber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscriber(String name, String adresse, String phone, String dateAdh, String yearBirth,
			String professionalCategory) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.phone = phone;
		this.dateAdh = dateAdh;
		this.yearBirth = yearBirth;
		this.professionalCategory = professionalCategory;
	}

	public int getNumMatricule() {
		return numMatricule;
	}

	public void setNumMatricule(int numMatricule) {
		this.numMatricule = numMatricule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDateAdh() {
		return dateAdh;
	}

	public void setDateAdh(String dateAdh) {
		this.dateAdh = dateAdh;
	}

	public String getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(String yearBirth) {
		this.yearBirth = yearBirth;
	}

	public String getProfessionalCategory() {
		return professionalCategory;
	}

	public void setProfessionalCategory(String professionalCategory) {
		this.professionalCategory = professionalCategory;
	}

	@Override
	public String toString() {
		return "Subscriber [numMatricule=" + numMatricule + ", name=" + name + ", adresse=" + adresse + ", phone="
				+ phone + ", dateAdh=" + dateAdh + ", yearBirth=" + yearBirth + ", professionalCategory="
				+ professionalCategory + "]";
	}

	
	
}
