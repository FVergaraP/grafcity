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
	
	//Funcion para buscar por Coordenadas, debe recibir la latitud y longitud ( solo hasta decimales )
	public List<Graffiti> findGraffitisGPS(double lat, double lon);
	
	//Funcion para buscar todos los graffitis de un autor
	public List<Graffiti> findGraffitisAutor (Integer id);
	
	//Funcion para obtener un intervalo de graffitis segun Id
	public List<Graffiti> findGraffitisRango (Integer first, Integer last);
	
	//Funcion para eliminar un graffiti por id
	public void eliminarGraffiti(Integer id);
	
	//Funcion para obtener los mejores graffitis
	public List<Graffiti> findGraffitisAvg(Integer cant);
	
	//De aqui pa abajo funciones varias de pruebas
	public List<Graffiti> probandoQuery();
	
	//Prueba del procedimiento
	public void llamarProcedimieno();
	
	
	
	
}
