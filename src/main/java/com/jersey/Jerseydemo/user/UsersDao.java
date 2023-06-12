package com.jersey.Jerseydemo.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
	 private Connection connection;
	  
	    


	    public UsersDao() {
	       
	        try {
	      

	             String driver="com.mysql.cj.jdbc.Driver";
	             Class.forName(driver);
	            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/animal_zoo",  "vaibhav", "welcome");
	        } catch (ClassNotFoundException| SQLException  e) {
	            System.out.println(e);
	        	e.printStackTrace();
	        }
	    }

	    public List<Users> getUsers() throws SQLException {
	        List<Users> user = new ArrayList<>();
	        
	      
	        String sql = "SELECT * FROM users";
	        
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql); 
	            

	            while (resultSet.next()) {
	                Users z = new Users();
	                z.setId(resultSet.getInt(1));
	                z.setUsername(resultSet.getString(2));
	                z.setPassword(resultSet.getString(3));
	               
	      
	                user.add(z);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	            System.out.println("displayed........");
	        
	        return user;
	    }



		public Users getoneuser(int id) {
			 String sql="select * from users where id="+id;
			 Users z=new Users();
				try {
					Statement s=connection.createStatement();
					ResultSet rs =s.executeQuery(sql);
					if(rs.next()) {
						
						z.setId(rs.getInt(1));
						z.setUsername(rs.getString(2));
						z.setPassword(rs.getString(3));
						
					}
				} catch (SQLException e) {
				System.out.println(e);
					e.printStackTrace();
				}
		         return z; 
		 }
			
	    public void create(Users user) throws SQLException, IOException {
	    	String sql = "INSERT INTO `users`(`id`, `username`, `password`) VALUES (?,?,?)";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, user.getId());
	            statement.setString(2, user.getUsername());
	            
	            statement.setString(3, user.getPassword());
	     
	           
	           
	           
	            System.out.println("inserted..........");
	            statement.executeUpdate();
	        }catch (IllegalStateException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }
	                     
	    public void updateuser(Users user) {
	        String sql = "UPDATE users SET username = ?, password = ? WHERE id = ?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, user.getUsername());
	            statement.setString(2, user.getPassword());
	          
	            statement.setInt(3, user.getId());
	            
	            statement.executeUpdate();
	            System.out.println("updated..........");
	        } catch (SQLException e) {
	        	System.out.println(e);
	        	
	            e.printStackTrace();
	        }
	    }          
	             
	    public void deleteuser(int id) {
	        String sql = "DELETE FROM users WHERE id = ?";

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