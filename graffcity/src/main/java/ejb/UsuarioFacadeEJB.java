package ejb;

import java.util.List;

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
	
	public List<Usuario> muestraLogin(Usuario user){
		Query q = em.createNamedQuery("VerificaUsuario", Usuario.class);
		q.setParameter("usuario", user.getNickname());
		q.setParameter("password", user.getContrasena());
		List<Usuario> usuarios = q.getResultList();
		return usuarios;
	}
	
	public List<Usuario> existeNickname(String nickname){
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname =:nickname");
		q.setParameter("nickname", nickname);
		List<Usuario> usuarios = q.getResultList();
		return usuarios;
	}
	
	public List<Usuario> existeEmail(Usuario user){
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.correo =:correo");
		q.setParameter("correo", user.getCorreo());
		List<Usuario> usuarios = q.getResultList();
		return usuarios;
	}
	
	public int obtenerId(String nickname){
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname =:nickname");
		q.setParameter("nickname","juanin");// juanin?? deberia ser nickname po xD
		Usuario user = (Usuario) q.getSingleResult();
		Integer id = user.getUsuarioId();
		
		return id;
	}
	public void borrar(String nickname){
		Query q = em.createQuery("DELETE FROM Usuario u WHERE u.nickname =:nickname");
		q.setParameter("nickname", nickname);
		q.executeUpdate();
	}

}
