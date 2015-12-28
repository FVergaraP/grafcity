package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import facade.UsuarioFacade;
import model.Graffiti;
import model.Usuario;

@Path("/usuarios")
public class UsuarioService {
	
	@EJB 
	UsuarioFacade usuarioFacadeEJB;
	
	Logger logger = Logger.getLogger(UsuarioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Usuario> findAll(){
		return usuarioFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Usuario find(@PathParam("id") Integer id) {
        return usuarioFacadeEJB.find(id);
    }
	
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
        usuarioFacadeEJB.create(entity);
    }

    @PUT //editar
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
    	entity.setUsuarioId(id.intValue());
        usuarioFacadeEJB.edit(entity);
    }
    
    /*@DELETE
	@Path("ri/{id}")
	@Produces({"application/xml", "application/json"})
	public void removeId(@PathParam("id") Integer id){
		usuarioFacadeEJB.removeId(id);
	}*/
    @GET
    @Path("login/{usuario}/{password}")
    @Produces({"application/xml", "application/json"})
    public List<Usuario> muestraLogin(
    		@PathParam("usuario") String usuario, 
    		@PathParam("password") String password){
    	return usuarioFacadeEJB.muestraLogin(usuario, password);
    }
    @GET
    @Path("ex.us/{nickname}")
	@Produces({"application/xml", "application/json"})
    public List<Usuario> existeNickname(
    		@PathParam("nickname") String nickname) {
    	return usuarioFacadeEJB.existeNickname(nickname);
    }
    @POST
    @Path("existe")
	@Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json"}) 
    public List<Usuario> existeEmail(Usuario user) {
    	return usuarioFacadeEJB.existeEmail(user);
    }

}

