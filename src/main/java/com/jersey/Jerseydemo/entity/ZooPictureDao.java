package com.jersey.Jerseydemo.entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZooPictureDao {
	 private Connection connection;
	 public ZooPictureDao() {
	       
	        try {
	      

	             String driver="com.mysql.cj.jdbc.Driver";
	             Class.forName(driver);
	            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/animal_zoo",  "vaibhav", "welcome");
	        } catch (ClassNotFoundException| SQLException  e) {
	            System.out.println(e);
	        	e.printStackTrace();
	        }
	    }

	    public List<ZooPicture> getzoopic() throws SQLException {
	        List<ZooPicture> zoopic = new ArrayList<>();
	        String sql = "SELECT * FROM zoo_picture";
	        
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql); 
	            

	            while (resultSet.next()) {
	                ZooPicture z = new ZooPicture();
	                z.setId(resultSet.getInt(1));
	                z.setImage(resultSet.getString(2));
	                z.setZoo1_id(resultSet.getInt(3));
	                
	      
	                zoopic.add(z);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	            System.out.println("displayed........");
	        
	        return zoopic;
	    }
	    public ZooPicture getoneZoopic(int id) {
			 String sql="select * from zoo_picture where id="+id;
			 ZooPicture z=new ZooPicture();
				try {
					Statement s=connection.createStatement();
					ResultSet rs =s.executeQuery(sql);
					if(rs.next()) {
						
						z.setId(rs.getInt(1));
						z.setImage(rs.getString(2));
						z.setZoo1_id(rs.getInt(3));
					}
				} catch (SQLException e) {
				System.out.println(e);
					e.printStackTrace();
				}
		         return z; 
		 }
			
	    public void createzoopic(ZooPicture zoo) throws SQLException, IOException {
	        String sql = "INSERT INTO `zoo_picture`(`id`, `image`, `zoo_id`) VALUES (?,?,?)";
	    
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, zoo.getId());
	            statement.setString(2, zoo.getImage());
	            statement.setInt(3, zoo.getZoo1_id());
	           
	          
	           
	           
	            System.out.println("inserted..........");
	            statement.executeUpdate();
	        }catch (IllegalStateException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }
	                     
	    public void updateZoopic(ZooPicture zoo) {
	        String sql = "UPDATE zoo_picture SET image = ?, zoo1_id = ? WHERE id = ?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            
	            statement.setString(1, zoo.getImage());
	            statement.setInt(2, zoo.getZoo1_id());
	           
	          
	            statement.setInt(3, zoo.getId());
	            
	            statement.executeUpdate();
	            System.out.println("updated..........");
	        } catch (SQLException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }          
	             
	    public void deleteZoopic(int id) {
	        String sql = "DELETE FROM zoo_picture WHERE id = ?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            statement.executeUpdate();
	            System.out.println("deleted........"); 
	        } catch (SQLException|IllegalStateException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }
}
