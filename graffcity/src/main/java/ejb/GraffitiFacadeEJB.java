package ejb;

import java.util.ArrayList;
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
		q.setParameter("latitudArriba", (lat+0.005));
		q.setParameter("revision", true);
		List<Graffiti> graffities = q.getResultList();
		return graffities;
	}
	
	
	public List<Graffiti> findGraffitisAutor (Integer id){
		
		Query q = em.createNamedQuery("Graffiti.findByUserId", Graffiti.class);
		q.setParameter("autorId", id);
		q.setParameter("revision", true);
		List<Graffiti> graffities = q.getResultList();
		return graffities;
	}
	
	
	public List<Graffiti> findGraffitisRango (Integer first, Integer last){
		Query q = em.createNamedQuery("Graffiti.findRango", Graffiti.class);
		q.setParameter("first", first);
		q.setParameter("last", last);
		q.setParameter("revision", true);
		List<Graffiti> graffities = q.getResultList();
		return graffities;
	}
	
	public List<Graffiti> findGraffitisAvg(Integer cant){
		Query q = em.createNamedQuery("Graffiti.findByAvg");
		q.setParameter("revision", true);
		List<Graffiti> graffities = q.getResultList();
		int contador = 0;
		List <Graffiti> graffitiesFinales = new ArrayList<Graffiti>();
		for (Graffiti Graffiti : graffities){
			if (contador<cant){
				graffitiesFinales.add(Graffiti);
				contador++;
			}
			
		}
		
		return graffitiesFinales;
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
	
	//Eliminar un graffiti por id
	public void eliminarGraffiti(Integer id){
		Query q = em.createNamedQuery("Graffiti.deleteForId");
		q.setParameter("graffitiId", id);
		q.executeUpdate();	
	}
	
	
	//LLamar procedimiento
	public void llamarProcedimieno(){
		
		StoredProcedureQuery SProcedure = em.createStoredProcedureQuery("mostrar_AVGcalif").registerStoredProcedureParameter(0,Integer.class, ParameterMode.IN);
		
		SProcedure.setParameter(0, 1);
		SProcedure.execute();
		float promedio = (float) SProcedure.getOutputParameterValue("promedio");
				
		
	}
	

}
