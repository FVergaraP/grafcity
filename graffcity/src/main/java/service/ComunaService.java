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

import facade.ComunaFacade;
import model.Comuna;



@Path("/comuna")
public class ComunaService {
	
	@EJB 
	ComunaFacade comunaFacadeEJB;
	
	Logger logger = Logger.getLogger(CiudadService.class.getName());
	
		
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Comuna> findAll(){
		return comunaFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Comuna find(@PathParam("id") Integer id) {
        return comunaFacadeEJB.find(id);
    }
	
		
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Comuna entity) {
		comunaFacadeEJB.create(entity);
    }

    @PUT //editar
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Comuna entity) {
    	entity.setComunaId(id.intValue());
    	comunaFacadeEJB.edit(entity);
    }

}


