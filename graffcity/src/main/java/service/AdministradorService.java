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
import javax.ws.rs.QueryParam;

import com.mysql.jdbc.Statement;

import facade.AdministradorFacade;
import model.Administrador;



@Path("/administrador")
public class AdministradorService {
	
	@EJB 
	AdministradorFacade administradorFacadeEJB;
	
	Logger logger = Logger.getLogger(CiudadService.class.getName());
	
		
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Administrador> findAll(){
		return administradorFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Administrador find(@PathParam("id") Integer id) {
        return administradorFacadeEJB.find(id);
    }
	
	//ValidarGraffiti
	@GET
    @Path("/validar")
    @Produces({"application/xml", "application/json"})
    public void validarGraff(@QueryParam("id") Integer id) {
        administradorFacadeEJB.validarGraffiti(id);
    }
		
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Administrador entity) {
		administradorFacadeEJB.create(entity);
    }

    @PUT //editar
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Administrador entity) {
    	entity.setAdminId(id.intValue());
    	administradorFacadeEJB.edit(entity);
    }

}

