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

import facade.CalificacionFacade;
import model.Calificacion;
import model.Graffiti;


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
	
	//Funcion GET para obtener las mejores calificaciones (promedio)Aun no esta bien del todo
	@GET
    @Path("FuncionoQuery")
    @Produces({"application/xml", "application/json"})
    public List<Calificacion> findBest() {
        return calificacionFacadeEJB.findBestByCalif();
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
    
    //Para poder editar una calificacion, debe ser con idusuario e idgraffiti obviamente 
    //No cuestiono porque pongo get pero asi me funciona
    //formato: /calificacion/edit?user=1&graf=1&nota=2
    @GET
    @Path("/edit")
    @Consumes({"application/xml", "application/json"})
    public void edicion(
    		@QueryParam("user") int user,
    		@QueryParam("graf") int graf,
    		@QueryParam("nota") int nota) {
    	calificacionFacadeEJB.editCalificacion(nota, user,  graf);
    }
    
    
    ///Ver si existe alguna calificacion, si retorna null no existe, si retorna no null existe xd
    //funciona igual que editar
    //formato: /calificacion/existe?user1&graf=2
    
    @GET
    @Path("/existe")
    @Consumes({"application/xml", "application/json"})
    public List<Calificacion> existeCalif(
    		@QueryParam("user") int user,
    		@QueryParam("graf") int graf) {
    	return calificacionFacadeEJB.existeCalificacion(user, graf);
    }

}


