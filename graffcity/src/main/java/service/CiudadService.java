package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mysql.jdbc.Statement;

import facade.CiudadFacade;
import model.Ciudad;



@Path("/ciudad")
public class CiudadService {
	
	@EJB 
	CiudadFacade ciudadFacadeEJB;
	
	Logger logger = Logger.getLogger(CiudadService.class.getName());
	
		
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Ciudad> findAll(){
		return ciudadFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Ciudad find(@PathParam("id") Integer id) {
        return ciudadFacadeEJB.find(id);
    }
	
		
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Ciudad entity) {
		ciudadFacadeEJB.create(entity);
    }

    @PUT //editar
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Ciudad entity) {
    	entity.setCiudadId(id.intValue());
    	ciudadFacadeEJB.edit(entity);
    }

}


