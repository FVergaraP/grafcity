package service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




import facade.GraffitiFacade;
import facade.UsuarioFacade;
import facade.CalificacionFacade;
import model.Calificacion;
import model.Graffiti;
import model.Usuario;


@Path("/graffiti")
public class GraffitiService {
	
	@EJB 
	GraffitiFacade graffitiFacadeEJB;
	@EJB
	UsuarioFacade usuarioFacadeEJB;
		
	Logger logger = Logger.getLogger(GraffitiService.class.getName());
	
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Graffiti> findAll(){
		return graffitiFacadeEJB.findAll();
	}
	
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Graffiti find(@PathParam("id") Integer id) {
        return graffitiFacadeEJB.find(id);
    }
	
	//GET POR COORDENADAS 
	//SE BUSCA /GPS?latitud=13131&longitud=11212
	//Se considera un cuadrante de 1km cuadrados aprox 
	@GET
	@Path("/GPS")
	@Produces({"application/xml", "application/json"})
	public List<Graffiti> findForGPS(
			@QueryParam("longitud") double longitud,
			@QueryParam("latitud") double latitud){
		return graffitiFacadeEJB.findGraffitisGPS(latitud, longitud);
	}
	
	//GET POR AUTOR
	@GET
	@Path("/autor")
	@Produces({"application/xml", "application/json"})
	public List<Graffiti> findForId(
			@QueryParam("nick") String nickname){
		Integer id = usuarioFacadeEJB.obtenerId(nickname);
		return graffitiFacadeEJB.findGraffitisAutor(id);
	}
	
	//GET DE PRUEBA	
	@GET
    @Path("FuncionoProcedimietno")
    @Produces({"application/xml", "application/json"})
    public List<Graffiti> probandoooo() {
        graffitiFacadeEJB.llamarProcedimieno();
        List<Graffiti> graffities = null;
        return graffities;
    }	
	//EL GET DE ARRIBA ES DE PRUEBA DE FUNCIONES VARIAS
	
	

		
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Graffiti entity) {
        graffitiFacadeEJB.create(entity);
    }

    @PUT //editar
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Graffiti entity) {
    	entity.setGraffitiId(id.intValue());
        graffitiFacadeEJB.edit(entity);
    }  

}
