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
import model.Usuario;



@Path("/administrador")
public class AdministradorService {
	
	@EJB 
	AdministradorFacade administradorFacadeEJB;
	
	Logger logger = Logger.getLogger(AdministradorService.class.getName());
	
		
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
	//Forma: /administrador/validar?id=3
	//solo se necesita el id del graffiti y no retorna nada
	@GET
    @Path("/validar")
    @Produces({"application/xml", "application/json"})
    public void validarGraff(@QueryParam("id") Integer id) {
        administradorFacadeEJB.validarGraffiti(id);
    }
	
	//BanearUsuario
	//Forma: /administrador/banear?id=3
	//Banea al usuario 3, no retorna nada.
	@GET
    @Path("/banear")
    @Produces({"application/xml", "application/json"})
    public void banearUsuario(@QueryParam("id") Integer id) {
        administradorFacadeEJB.banearUser(id);
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
    //Se logea con nombre, apellido y pass.
    @POST
    @Path("login")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json"}) 
    public List<Administrador> muestraLogin(Administrador admin){
    	return administradorFacadeEJB.Login(admin);
    }

}

