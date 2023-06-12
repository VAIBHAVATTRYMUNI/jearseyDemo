package com.jersey.Jerseydemo.entity;

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
import javax.persistence.Table;

import com.jersey.Jerseydemo.animal.Animal;
import com.jersey.Jerseydemo.user.Users;


@Entity
@Table(name="Zoo1")
public class Zoo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	private String name;

	private String location;
	@Column(name = "users_id")
	private int users_id;
	
	

public int getUsers_id() {
		return users_id;
	}


	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}


public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getLocation() {
		return location;
	}


	

	


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	


		 @OneToMany(mappedBy = "zoo1", cascade = CascadeType.ALL)
		private List<Animal> animal;
		 @OneToMany(mappedBy = "zoo1", cascade = CascadeType.ALL)
		 private List<ZooPicture> zoopicture  ;


	
	


		


	


		public void setAnimal(List<Animal> animal) {
			this.animal = animal;
		}


		





	@ManyToOne
    @MapsId
    @JoinColumn(name="id")
	 private Users users;



	


	

	

	

	public void setZoopicture(List<ZooPicture> zoopicture) {
		this.zoopicture = zoopicture;
	}


	public void setUsers(Users users) {
		this.users = users;
	}
}
