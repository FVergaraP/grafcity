package facade;

import java.util.List;

import javax.ejb.Local;

import model.Comuna;

@Local
public interface ComunaFacade {
	
	public void create(Comuna entity);

	public void edit(Comuna entity);

	public void remove(Comuna entity);

	public Comuna find(Object id);

	public List<Comuna> findAll();

	public List<Comuna> findRange(int[] range);

	public int count();
	
	//Funciones extras
	
}
