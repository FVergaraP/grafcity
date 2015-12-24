package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import facade.AbstractFacade;
import facade.AdministradorFacade;
import model.Administrador;


@Stateless
public class AdministradorFacadeEJB extends AbstractFacade<Administrador> implements AdministradorFacade {
	
	@PersistenceContext(unitName = "grafcityPU")
	private EntityManager em; //maneja las entidades (tablas)
	
	public AdministradorFacadeEJB() {
		super(Administrador.class); //pasa todos los datos de la tabla actor encargado de manejarlos
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	//Consultas y Funciones extras para extraer desde la BD
	
	
}

