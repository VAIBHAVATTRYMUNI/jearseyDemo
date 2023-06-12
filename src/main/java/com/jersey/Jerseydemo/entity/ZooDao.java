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



public class ZooDao {
  private Connection connection;
  
    


    public ZooDao() {
       
        try {
      

             String driver="com.mysql.cj.jdbc.Driver";
             Class.forName(driver);
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/animal_zoo",  "vaibhav", "welcome");
        } catch (ClassNotFoundException| SQLException  e) {
            System.out.println(e);
        	e.printStackTrace();
        }
    }

    public List<Zoo> getZoo() throws SQLException {
        List<Zoo> zoo = new ArrayList<>();
        // Convert the image to bytes
      
        String sql = "SELECT * FROM Zoo1";
        
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql); 
            

            while (resultSet.next()) {
                Zoo z = new Zoo();
                z.setId(resultSet.getInt(1));
                z.setName(resultSet.getString(2));
                z.setLocation(resultSet.getString(3));
                z.setUsers_id(resultSet.getInt(4));
      
                zoo.add(z);
            }

            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("displayed........");
        
        return zoo;
    }



	public Zoo getoneZoo(int id) {
		 String sql="select * from Zoo1 where id="+id;
		 Zoo z=new Zoo();
			try {
				Statement s=connection.createStatement();
				ResultSet rs =s.executeQuery(sql);
				if(rs.next()) {
					
					z.setId(rs.getInt(1));
					z.setName(rs.getString(2));
					z.setLocation(rs.getString(3));
					
				}
			} catch (SQLException e) {
			System.out.println(e);
				e.printStackTrace();
			}
	         return z; 
	 }
		
    public void create(Zoo zoo) throws SQLException, IOException {
        String sql = "INSERT INTO `Zoo1`(`id`, `name`, `location`,`users_id`) VALUES (?,?,?,?)";
     //  File file= new File("C:" + File.separator + "Users" + File.separator + "ICS" + File.separator + "Desktop" + File.separator + "download (2).jfif");
     //   FileInputStream fis = new FileInputStream(file);
       // byte [] imageData = IOUtils.toByteArray(fis);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, zoo.getId());
            statement.setString(2, zoo.getName());
            
            statement.setString(3, zoo.getLocation());
            statement.setInt(4, zoo.getUsers_id());
           // statement.setString(4, zoo.getImageData());
          
           
           
            System.out.println("inserted..........");
            statement.executeUpdate();
        }catch (IllegalStateException e) {
        	System.out.println(e);
        	
            e.printStackTrace();
        }
    }
                     
    public void updateZoo(Zoo zoo) {
        String sql = "UPDATE Zoo1 SET Name = ?, Location = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, zoo.getName());
            statement.setString(2, zoo.getLocation());
          
            statement.setInt(3, zoo.getId());
            
            statement.executeUpdate();
            System.out.println("updated..........");
        } catch (SQLException e) {
        	System.out.println(e);
        	
            e.printStackTrace();
        }
    }          
             
    public void deleteZoo(int id) {
        String sql = "DELETE FROM Zoo1 WHERE id = ?";

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
	

	
