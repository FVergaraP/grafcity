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

import facade.CalificacionFacade;
import model.Calificacion;


@Path("/calificacion")
public class CalificacionService {
	
	@EJB 
	CalificacionFacade calificacionFacadeEJB;
	
	Logger logger = Logger.getLogger(CalificacionService.class.getName());
	
		
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Calificacion> findAll(){
		return calificacionFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Calificacion find(@PathParam("id") Integer id) {
        return calificacionFacadeEJB.find(id);
    }
	
	
	
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Calificacion entity) {
		calificacionFacadeEJB.create(entity);
    }

    @PUT //editar
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Calificacion entity) {
    	entity.setPuntuacion(id.intValue());
    	calificacionFacadeEJB.edit(entity);
    }

}


