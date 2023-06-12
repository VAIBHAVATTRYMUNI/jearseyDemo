package com.jersey.Jerseydemo.animal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jersey.Jerseydemo.entity.Zoo;
@Entity
@Table(name="Animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	private String name;
	@Column(name = "zoo1_id")
	private int zoo1_id;
	
	
	public int getZoo1_id() {
		return zoo1_id;
	}


	public void setZoo1_id(int zoo1_id) {
		this.zoo1_id = zoo1_id;
	}
	@ManyToOne
    @MapsId
    @JoinColumn(name="id")
	 private Zoo zoo;


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	

	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}
	 @OneToMany(mappedBy = "Animal", cascade = CascadeType.ALL)
		private List<AnimalPicture> animalpic;


	


	public void setAnimalpic(List<AnimalPicture> animalpic) {
		this.animalpic = animalpic;
	}
}
