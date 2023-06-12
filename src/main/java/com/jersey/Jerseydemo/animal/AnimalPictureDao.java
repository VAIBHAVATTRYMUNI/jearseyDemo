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

import com.jersey.Jerseydemo.entity.ZooPicture;

public class AnimalPictureDao {
	private Connection connection;
	 public AnimalPictureDao() {
	       
	        try {
	      

	             String driver="com.mysql.cj.jdbc.Driver";
	             Class.forName(driver);
	            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/animal_zoo",  "vaibhav", "welcome");
	        } catch (ClassNotFoundException| SQLException  e) {
	            System.out.println(e);
	        	e.printStackTrace();
	        }
	    }

	    public List<AnimalPicture> getapic() throws SQLException {
	        List<AnimalPicture> zoopic = new ArrayList<>();
	        String sql = "SELECT * FROM `animal_picture`";
	        
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql); 
	            

	            while (resultSet.next()) {
	                AnimalPicture z = new AnimalPicture();
	                z.setId(resultSet.getInt(1));
	                z.setImage(resultSet.getString(2));
	                z.setAnimal_id(resultSet.getInt(3));
	                
	      
	                zoopic.add(z);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	            System.out.println("displayed........");
	        
	        return zoopic;
	    }
	    public AnimalPicture getoneapic(int id) {
			 String sql="select * from animal_picture where id="+id;
			  AnimalPicture z = new AnimalPicture();
				try {
					Statement s=connection.createStatement();
					ResultSet rs =s.executeQuery(sql);
					if(rs.next()) {
						
						z.setId(rs.getInt(1));
						z.setImage(rs.getString(2));
						z.setAnimal_id(rs.getInt(3));
					}
				} catch (SQLException e) {
				System.out.println(e);
					e.printStackTrace();
				}
		         return z; 
		 }
			
	    public void createapic(AnimalPicture zoo) throws SQLException, IOException {
	        String sql = "INSERT INTO `animal_picture`(`id`, `image`, `animal_id`) VALUES (?,?,?)";
	    
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, zoo.getId());
	            statement.setString(2, zoo.getImage());
	            statement.setInt(3, zoo.getAnimal_id());
	           
	          
	           
	           
	            System.out.println("inserted..........");
	            statement.executeUpdate();
	        }catch (IllegalStateException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }
	                     
	    public void updateapic(AnimalPicture zoo) {
	        String sql = "UPDATE animal_picture SET image = ?, animal_id = ? WHERE id = ?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	           
	            statement.setString(1, zoo.getImage());
	            statement.setInt(2, zoo.getAnimal_id());
	           
	          
	            statement.setInt(3, zoo.getId());
	            
	            statement.executeUpdate();
	            System.out.println("updated..........");
	        } catch (SQLException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }          
	             
	    public void deleteapic(int id) {
	        String sql = "DELETE FROM animal_picture WHERE id = ?";

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
