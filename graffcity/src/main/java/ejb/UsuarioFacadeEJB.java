package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	//Funciones extras
	
	public int obtenerId(String nickname){
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname =:nickname");
		q.setParameter("nickname","juanin");
		Usuario user = (Usuario) q.getSingleResult();
		Integer id = user.getUsuarioId();
		
		return id;
	}
	
	public boolean isAcountExists(String usuario, String password){
    	Query q = em.createQuery("SELECT nick_name FROM usuarios WHERE nick_name="+usuario+" AND contrasena="+password+"");
        if(q.equals(usuario))
        	return true;
        else
        	return false;
    }
    
    //Metodo para consultar si el email recibido ya esta registrado
    public boolean isEmailRegistered(String email) {
    	Query q = em.createQuery("SELECT email FROM email="+email+"");
        if(q.equals(email))
        	return true;
        else
        	return false;
    }


}
