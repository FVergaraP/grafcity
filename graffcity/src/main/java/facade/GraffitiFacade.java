package facade;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import model.Graffiti;

@Local
public interface GraffitiFacade {
	
	public void create(Graffiti entity);

	public void edit(Graffiti entity);

	public void remove(Graffiti entity);

	public Graffiti find(Object id);

	public List<Graffiti> findAll();

	public List<Graffiti> findRange(int[] range);

	public int count();
	
	public List<Graffiti> entregarGraffitis(Integer id);
	
	//Funcion para buscar por Coordenadas, debe recibir la latitud y longitud ( solo hasta decimales )
	public List<Graffiti> findGraffitisGPS(float lat, float lon);
	
}
