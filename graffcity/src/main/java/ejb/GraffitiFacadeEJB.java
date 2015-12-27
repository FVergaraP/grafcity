package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mysql.jdbc.CallableStatement;

import facade.AbstractFacade;
import facade.GraffitiFacade;
import model.Graffiti;
import facade.UsuarioFacade;
import model.Usuario;

@Stateless
public class GraffitiFacadeEJB extends AbstractFacade<Graffiti> implements GraffitiFacade {
	
	@PersistenceContext(unitName = "grafcityPU")
	private EntityManager em; //maneja las entidades (tablas)
	
	public GraffitiFacadeEJB() {
		super(Graffiti.class); //pasa todos los datos de la tabla actor encargado de manejarlos
	}

	@Override
	protected EntityManager getEntityManager() {
		
		/*Query q = em.createNamedQuery("Graffiti.findById",Graffiti.class);
		
		q.setParameter("graffitiId", 1);
		
		List<Graffiti> graffities = q.getResultList();*/
		
		return this.em;
	}
	
	
	//Funcion para buscar por GPS, creo la Query, Seteo Parametros, Ejecuto Query y Guardo resultado
	//Considerar que 1 grado es 110km, por ende es un cuadrante de 1km por lado mas menos.
	public List<Graffiti> findGraffitisGPS(double lat, double lon){
		Query q = em.createNamedQuery("Graffiti.findByGPS", Graffiti.class);
		q.setParameter("longitudAbajo", (lon-0.005));
		q.setParameter("longitudArriba", (lon+0.005));
		q.setParameter("latitudAbajo", (lat-0.005));
		q.setParameter("latitudArriba", (lon+0.005));
		List<Graffiti> graffities = q.getResultList();
		return graffities;
	}
	
	
	public List<Graffiti> findGraffitisAutor (Integer id){
		
		Query q = em.createNamedQuery("Graffiti.findByUserId", Graffiti.class);
		q.setParameter("autorId", id);
		List<Graffiti> graffities = q.getResultList();
		return graffities;
	}
	
	//De aqui para abajo probando funciones varias
	
	public List<Graffiti> probandoQuery(){
		 		
		 		
		 		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 		 
		 		  CriteriaQuery<Graffiti> q = cb.createQuery(Graffiti.class);
		 		  Root<Graffiti> c = q.from(Graffiti.class);
		 		  q.select(c);
		 		  q.orderBy(cb.asc(c.get("comunaId")));		 		  
		 		  TypedQuery<Graffiti> query = em.createQuery(q);
		 		  List<Graffiti> results = query.getResultList();
		return results;
	}
	
	//Actualizar Promedio tras agregar calificacion
	public void actualizarPromedio(){
		
		StoredProcedureQuery SProcedure = em.createStoredProcedureQuery("mostrar_AVGcalif").
				registerStoredProcedureParameter(1,int.class, ParameterMode.IN);
				
		
		SProcedure.setParameter(1, 1);
		SProcedure.execute();
		
		
		
				
		
	}
	

}
