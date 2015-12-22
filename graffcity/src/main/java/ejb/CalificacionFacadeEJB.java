package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.CalificacionFacade;
import model.Calificacion;

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

}
