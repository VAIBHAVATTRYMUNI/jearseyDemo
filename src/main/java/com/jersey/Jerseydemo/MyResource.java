
package com.jersey.Jerseydemo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jersey.Jerseydemo.animal.Animal;
import com.jersey.Jerseydemo.animal.AnimalDao;
import com.jersey.Jerseydemo.animal.AnimalPicture;
import com.jersey.Jerseydemo.animal.AnimalPictureDao;
import com.jersey.Jerseydemo.entity.Zoo;
import com.jersey.Jerseydemo.entity.ZooDao;
import com.jersey.Jerseydemo.entity.ZooPicture;
import com.jersey.Jerseydemo.entity.ZooPictureDao;
import com.jersey.Jerseydemo.user.Users;
import com.jersey.Jerseydemo.user.UsersDao;
@Path("/myresource")
public class MyResource {
	Scanner s=new Scanner(System.in);

   //FOR ZOO
    @GET
    @Path("/getallzoo")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Zoo> getZoo() throws SQLException {
    	 ZooDao repo=new ZooDao();
    	return repo.getZoo();
    }
    
    @GET
    @Path("/getonezoo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Zoo getoneZoo(@PathParam("id") int id) throws SQLException {
    	 ZooDao repo=new ZooDao();
    	System.out.println("hlo");
    	return repo.getoneZoo(id);
    }
    
    @POST
    @Path("/savezoo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})
  
    public Zoo creatzoo(Zoo z1) throws IOException {
    	 ZooDao repo=new ZooDao();
    	System.out.println(z1);
    	try {
			repo.create(z1);
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
    	return z1;
    }
   

    @PUT
    @Path("updatezoo/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateZoo(@PathParam("id") int id, Zoo updatedZoo) {
    	 ZooDao repo=new ZooDao();
    	
        if ( repo.getoneZoo(id) != null) {
            updatedZoo.setId(id);
           repo.updateZoo(updatedZoo);        
        } else {
           System.out.println("id not found");
        }
    }  
    
    
    @DELETE
    @Path("deletezoo/{id}")
    public void deleteZoo(@PathParam("id") int id) {
    	ZooDao repo=new ZooDao();
        if (repo.getoneZoo(id) != null) {
        	 repo.deleteZoo(id);
        } else {
        	System.out.println("NOT FOUND");
        }
    }
    
    
    
    //FOR ANIMAL
    @GET
    @Path("/getallanimal")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Animal> getAnimal() throws SQLException {
    	 AnimalDao repo=new AnimalDao();
    	return repo.getAnimal();
    }
    
    @GET
    @Path("/getoneanimal/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal getoneAnimal(@PathParam("id") int id) throws SQLException {
    	 AnimalDao repo=new AnimalDao();
    	System.out.println("hlo");
    	return repo.getoneAnimal(id);
    }
    
    @POST
    @Path("/saveanimal")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})
  
    public Animal creatanimal(Animal z1) throws IOException {
    	 AnimalDao repo=new AnimalDao();
    	System.out.println(z1);
    	try {
			repo.create(z1);
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
    	return z1;
    }
   

    @PUT
    @Path("updateanimal/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAnimal(@PathParam("id") int id, Animal updatedAnimal) {
    	 AnimalDao repo=new AnimalDao();
    	
        if ( repo.getoneAnimal(id) != null) {
            updatedAnimal.setId(id);
           repo.updateAnimal(updatedAnimal);        
        } else {
           System.out.println("id not found");
        }
    }  
    
    
    @DELETE
    @Path("deleteanimal/{id}")
    public void deleteAnimal(@PathParam("id") int id) {
    	AnimalDao repo=new AnimalDao();
        if (repo.getoneAnimal(id) != null) {
        	 repo.deleteAnimal(id);
        } else {
        	System.out.println("NOT FOUND");
        }
    }
    
    
    
    ///FOR ZOOPICTURE

@GET
@Path("/getallzoopic")
@Produces(MediaType.APPLICATION_JSON)
public List<ZooPicture> getzoopicc() throws SQLException {
	 ZooPictureDao repo=new ZooPictureDao();
	return repo.getzoopic();
}
@GET
@Path("/getonezoopic/{id}")
@Produces(MediaType.APPLICATION_JSON)
public ZooPicture getonezoopic(@PathParam("id") int id) throws SQLException {
	ZooPictureDao repo=new ZooPictureDao();
	System.out.println("hlo");
	return repo.getoneZoopic(id);
}

@POST
@Path("/savezoopic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})

public ZooPicture createzoopic(ZooPicture z1) throws IOException {
	 ZooPictureDao repo=new ZooPictureDao();
	System.out.println(z1);
	try {
		repo.createzoopic(z1);
	} catch (SQLException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	return z1;
}


@PUT
@Path("updatezoopic/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public void updatezoopic(@PathParam("id") int id, ZooPicture updatedZoopic) {
	 ZooPictureDao repo=new ZooPictureDao();
	
    if ( repo.getoneZoopic(id) != null) {
        updatedZoopic.setId(id);
       repo.updateZoopic(updatedZoopic) ;       
    } else {
       System.out.println("id not found");
    }
}  


@DELETE
@Path("deletezoopic/{id}")
public void deletezoopic(@PathParam("id") int id) {
	ZooPictureDao repo=new ZooPictureDao();
    if (repo.getoneZoopic(id) != null) {
    	 repo.deleteZoopic(id);
    } else {
    	System.out.println("NOT FOUND");
    }
}


///FOR ANIMALPICTURE
@GET
@Path("/getallapic")
@Produces(MediaType.APPLICATION_JSON)
public List<AnimalPicture> getapicc() throws SQLException {
	 AnimalPictureDao repo=new AnimalPictureDao();
	return repo.getapic();
}
@GET
@Path("/getoneapic/{id}")
@Produces(MediaType.APPLICATION_JSON)
public AnimalPicture getoneapic(@PathParam("id") int id) throws SQLException {
	AnimalPictureDao repo=new AnimalPictureDao();
	System.out.println("hlo");
	return repo.getoneapic(id);
}

@POST
@Path("/saveapic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})

public AnimalPicture createapic(AnimalPicture z1) throws IOException {
	 AnimalPictureDao repo=new AnimalPictureDao();
	System.out.println(z1);
	try {
		repo.createapic(z1);
	} catch (SQLException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	return z1;
}


@PUT
@Path("updateapic/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public void updateapic(@PathParam("id") int id, AnimalPicture updatedapic) {
	 AnimalPictureDao repo=new AnimalPictureDao();
	
    if ( repo.getoneapic(id) != null) {
        updatedapic.setId(id);
       repo.updateapic(updatedapic) ;       
    } else {
       System.out.println("id not found");
    }
}  


@DELETE
@Path("deleteapic/{id}")
public void deleteapic(@PathParam("id") int id) {
	 AnimalPictureDao repo=new AnimalPictureDao();
    if (repo.getoneapic(id) != null) {
    	 repo.deleteapic(id);
    } else {
    	System.out.println("NOT FOUND");
    }
}




////FOR USERS
@GET
@Path("/getallusers")
@Produces(MediaType.APPLICATION_JSON)
public List<Users> getuser() throws SQLException {
	UsersDao repo=new UsersDao();
	return repo.getUsers();
}
@GET
@Path("/getoneusers/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Users getoneuser(@PathParam("id") int id) throws SQLException {
	UsersDao repo=new UsersDao();
	System.out.println("hlo");
	return repo.getoneuser(id);
}

@POST
@Path("/saveusers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})

public Users createuser(Users z1) throws IOException {
	UsersDao repo=new UsersDao();
	System.out.println(z1);
	try {
		repo.create(z1);
	} catch (SQLException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	return z1;
}


@PUT
@Path("updateusers/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public void updateuser(@PathParam("id") int id, Users updateuser) {
	 UsersDao repo=new UsersDao();
	
    if ( repo.getoneuser(id) != null) {
        updateuser.setId(id);
       repo.updateuser(updateuser) ;       
    } else {
       System.out.println("id not found");
    }
}  


@DELETE
@Path("deleteusers/{id}")
public void deleteuser(@PathParam("id") int id) {
	 UsersDao repo=new UsersDao();
    if (repo.getoneuser(id) != null) {
    	 repo.deleteuser(id);
    } else {
    	System.out.println("NOT FOUND");
    }
}



}
