package com.waracle.cakemanager.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cake_manager")
public class Cake 
{
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int id;
	
	@Column(name="name",insertable = true)
	String name;
	
	@Column(name="flavour",insertable = true)
	String flavour;
	
	@Column(name="description",insertable = true)
	String description;
	
	public Cake() {}
	
	public Cake(String name, String flavour, String description)
	{
		this.name = name;
		this.flavour = flavour;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
