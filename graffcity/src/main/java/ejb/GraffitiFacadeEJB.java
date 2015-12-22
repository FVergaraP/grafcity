package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import facade.AbstractFacade;
import facade.GraffitiFacade;
import model.Graffiti;

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
		
		//q.setParameter("id", 1);
		
		List<Graffiti> graffities = q.getResultList();*/
		
		return this.em;
	}

}
