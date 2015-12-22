package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.Usuario;

@Stateless
public class UsuarioFacadeEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "grafcityPU")
	private EntityManager em; //maneja las entidades (tablas)
	
	public UsuarioFacadeEJB() {
		super(Usuario.class); //pasa todos los datos de la tabla usuario encargado de manejarlos
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}