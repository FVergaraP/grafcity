package facade;

import java.util.List;

import javax.ejb.Local;

import model.Ciudad;

@Local
public interface CiudadFacade {
	
	public void create(Ciudad entity);

	public void edit(Ciudad entity);

	public void remove(Ciudad entity);

	public Ciudad find(Object id);

	public List<Ciudad> findAll();

	public List<Ciudad> findRange(int[] range);

	public int count();
	
	//Funciones extras
	
}
