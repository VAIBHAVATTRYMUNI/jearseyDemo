package com.jersey.Jerseydemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.jersey.Jerseydemo.user.Users;
import com.mysql.cj.jdbc.Blob;
@Entity
public class ZooPicture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String image;
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
	public String getImage() {
		return image;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}

}
