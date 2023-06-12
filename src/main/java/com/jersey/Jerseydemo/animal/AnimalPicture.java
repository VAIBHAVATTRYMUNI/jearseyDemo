package com.jersey.Jerseydemo.animal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.jersey.Jerseydemo.entity.Zoo;
import com.mysql.cj.jdbc.Blob;

public class AnimalPicture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String image;
	private int animal_id;
	public int getAnimal_id() {
		return animal_id;
	}
	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}
	@ManyToOne
    @MapsId
    @JoinColumn(name="id")
	 private Animal animal;
	
	public int getId() {
		return id;
	}
	public String getImage() {
		return image;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	

}
