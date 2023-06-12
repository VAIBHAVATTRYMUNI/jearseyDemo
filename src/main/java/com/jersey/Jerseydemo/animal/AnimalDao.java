package com.jersey.Jerseydemo.animal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jersey.Jerseydemo.entity.Zoo;



public class AnimalDao {
	 private Connection connection;
	 public AnimalDao() {
	       
	        try {
	      

	             String driver="com.mysql.cj.jdbc.Driver";
	             Class.forName(driver);
	            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/animal_zoo",  "vaibhav", "welcome");
	        } catch (ClassNotFoundException| SQLException  e) {
	            System.out.println(e);
	        	e.printStackTrace();
	        }
	    }

	    public List<Animal> getAnimal() throws SQLException {
	        List<Animal> animal = new ArrayList<>();
	        String sql = "SELECT * FROM Animal";
	        
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql); 
	            

	            while (resultSet.next()) {
	                Animal z = new Animal();
	                z.setId(resultSet.getInt(1));
	                z.setName(resultSet.getString(2));
	                z.setZoo1_id(resultSet.getInt(3));
	                
	      
	                animal.add(z);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	            System.out.println("displayed........");
	        
	        return animal;
	    }
	    public void updateAnimal(Animal animal) {
	        String sql = "UPDATE Animal SET Name = ? WHERE id = ?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, animal.getName());
	            
	          
	            statement.setInt(2, animal.getId());
	            
	            statement.executeUpdate();
	            System.out.println("updated..........");
	        } catch (SQLException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }
	    public void create(Animal animal) throws SQLException, IOException {
	        String sql = "INSERT INTO `Animal`(`id`, `name`,`zoo1_id`) VALUES (?,?,?)";
	     //  File file= new File("C:" + File.separator + "Users" + File.separator + "ICS" + File.separator + "Desktop" + File.separator + "download (2).jfif");
	     //   FileInputStream fis = new FileInputStream(file);
	       // byte [] imageData = IOUtils.toByteArray(fis);
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, animal.getId());
	            statement.setString(2, animal.getName());
	            statement.setInt(3, animal.getZoo1_id());
	            
	            
	          
	           // statement.setString(4, zoo.getImageData());
	          
	           
	           
	            System.out.println("inserted..........");
	            statement.executeUpdate();
	        }catch (IllegalStateException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }
	    public void deleteAnimal(int id) {
	        String sql = "DELETE FROM Animal WHERE id = ?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            statement.executeUpdate();
	            System.out.println("deleted........"); 
	        } catch (SQLException|IllegalStateException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }
	    public Animal getoneAnimal(int id) {
			 String sql="select * from Animal where id="+id;
			 Animal z=new Animal();
				try {
					Statement s=connection.createStatement();
					ResultSet rs =s.executeQuery(sql);
					if(rs.next()) {
						
						z.setId(rs.getInt(1));
						z.setName(rs.getString(2));
						
						
					}
				} catch (SQLException e) {
				System.out.println(e);
					e.printStackTrace();
				}
		         return z; 
		 }
			
}
