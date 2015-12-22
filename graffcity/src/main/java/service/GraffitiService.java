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
import facade.CalificacionFacade;
import model.Calificacion;
import model.Graffiti;


@Path("/graffiti")
public class GraffitiService {
	
	@EJB 
	GraffitiFacade graffitiFacadeEJB;
	
		
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
			@QueryParam("longitud") float longitud,
			@QueryParam("latitud") float latitud){
		return graffitiFacadeEJB.findGraffitisGPS(latitud, longitud);
	}
	
	//GET DE PRUEBA
	
	@GET
    @Path("funciono/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Graffiti> probandoooo(@PathParam("id") Integer id) {
        return graffitiFacadeEJB.entregarGraffitis(id);
    }
	
	
	
	@GET
	@Path("GPS/{longitud}/{latitud}")
	@Produces({"application/xml", "application/json"})
	public List<Graffiti> findAllGPS(@PathParam("longitud") Float longitud, @PathParam("latitud") Float latitud){
		List<Graffiti> GPS = new ArrayList<Graffiti>();
		GPS = graffitiFacadeEJB.findAll();
		for (Graffiti Graffiti : GPS){
			float latGraffiti = Graffiti.getLatitud();
			float lonGraffiti = Graffiti.getLongitud();
			if (latGraffiti<(latitud-5) && latGraffiti>(latitud+5)){
				if (lonGraffiti<(longitud-5) && lonGraffiti>(longitud+5)){
					GPS.remove(Graffiti);
				}
				
			}
			
		}
		return GPS;
	}
	
	@GET
	@Path("GPS/{id}")
	@Produces({"application/xml", "application/json"})
	public List<Graffiti> tomarPorId(@PathParam("id") Integer id){
		List<Graffiti> GPS = new ArrayList<Graffiti>();
		GPS = graffitiFacadeEJB.findAll();
		for (Graffiti Graffiti : GPS){
			int IdGraffiti = Graffiti.getGraffitiId();
			if (IdGraffiti==id){
				GPS.remove(Graffiti);
				
			}
			
		}
		return GPS;
	}
	
	
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
