package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import facade.AbstractFacade;
import facade.CalificacionFacade;
import model.Calificacion;
import model.Graffiti;
import model.Usuario;

@Stateless
public class CalificacionFacadeEJB extends AbstractFacade<Calificacion> implements CalificacionFacade {
	
	@PersistenceContext(unitName = "grafcityPU")
	private EntityManager em; //maneja las entidades (tablas)
	
	public CalificacionFacadeEJB() {
		super(Calificacion.class); //pasa todos los datos de la tabla actor encargado de manejarlos
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	//Consultas y Funciones extras para extraer desde la BD
	
	public List<Calificacion> findBestByCalif(){
 		
 		
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 
		  CriteriaQuery<Calificacion> q = cb.createQuery(Calificacion.class);
		  Root<Calificacion> c = q.from(Calificacion.class);
		  q.select(c);
		  q.orderBy(cb.asc(c.get("puntuacion")));
		  q.groupBy(c.get("graffitiId"));		  
		  TypedQuery<Calificacion> query = em.createQuery(q);
		  List<Calificacion> results = query.getResultList();

		  return results;
	}
	
	public void editCalificacion( int nota, int user, int graf){
		Query q = em.createQuery("UPDATE Calificacion c SET c.puntuacion =:puntuacion WHERE c.usuarioId = :usuarioId AND c.graffitiId = :graffitiId");
		q.setParameter("puntuacion",nota);
		q.setParameter("graffitiId", graf);
		int updateCount = q.setParameter("usuarioId", user ).executeUpdate();
		
	}
	
	public Calificacion existeCalificacion(int user, int graf){
		try{Query q = em.createQuery("SELECT c FROM Calificacion c WHERE c.graffitiId = :graffitiId AND c.usuarioId = :usuarioId");
		q.setParameter("graffitiId", graf);
		q.setParameter("usuarioId", user);
		Calificacion calificacion = (Calificacion) q.getSingleResult();
		return calificacion;}
		catch(NoResultException e) {
			Calificacion calificacion = null;
			return calificacion;
			
		}
	}
	

}
