package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="GRAFFITI")

@NamedQueries({
	@NamedQuery(name="Graffiti.findAll", query="SELECT a FROM Graffiti a"),
	/*@NamedQuery(name="Graffiti.findById", query="SELECT a FROM Graffiti a" + "WHERE a.id_graffiti = ?1"),
	//a.id_graffiti ='1'"
*/	
	
})

@NamedQuery(name="Graffiti.findAll", query="SELECT a FROM Graffiti a")
public class Graffiti implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_graffiti", unique=true, nullable=false)
	private int graffitiId;
	
	//No le puse el unique porque no es la llave primar	ia sino solo una referencia, quizas corregir
	@Column(name="id_autor", nullable=false)
	private int autorId;
	
	@Column(name="id_comuna", nullable=false)
	private int comunaId;

	@Column(name="n_compartidas", nullable=false)
	private int numeroCompartidas;

	@Column(name="nombre_graffiti", nullable=false, length=100)
	private String nombreGraffiti;
	
	@Column(name="link_foto", nullable=false, length=100)
	private String linkFoto;
	
	@Column(name="descripcion_Graf", nullable=false, length=2000)
	private String descripcionGraf;
	
	@Column(name="latitud", nullable=false)
	private float latitud;
	
	@Column(name="longitud", nullable=false)
	private float longitud;
	
	@Column(name="fecha_subida", nullable=false)
	private Date fechaSubida;
	
	
	
	public Graffiti() {
	}
	
	
	
	public List<Graffiti> sacarGraffitisPorGps(List<Graffiti> graffitis){
		List<Graffiti> GPS = new ArrayList<Graffiti>();
		for (Graffiti Graffiti : graffitis){
			int numero = Graffiti.getGraffitiId();
			if (numero==5){
				graffitis.remove(Graffiti);
			}
			
		}
		return graffitis;
	}
	
	public int getGraffitiId() {
		return this.graffitiId;
	}

	public void setGraffitiId(int graffitiId) {
		this.graffitiId = graffitiId;
	}
	
	public int getComunaId() {
		return this.comunaId;
	}

	public void setComunaId(int comunaId) {
		this.comunaId = comunaId;
	}
	
	public int getAutorId() {
		return this.autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}
	
	public int getNumeroCompartidas(){
		return this.numeroCompartidas;
	}
	
	public void setNumeroCompartidas(int numeroCompartidas){
		this.numeroCompartidas = numeroCompartidas;
	}
	
	public String getNombreGraffiti(){
		return this.nombreGraffiti;
	}
	
	public void setNombreGraffiti(String nombreGraffiti){
		this.nombreGraffiti = nombreGraffiti;
	}
	
	public String getLinkFoto() {
		return this.linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	public String getDescripcionGraf(){
		return this.descripcionGraf;
	}
	
	public void setDescripcionGraf(String descripcionGraf){
		this.descripcionGraf = descripcionGraf;
	}
	
	public float getLatitud(){
		return this.latitud;
	}
	
	public void setLatitud(float latitud){
		this.latitud = latitud;
	}
	
	public float getLongitud(){
		return this.longitud;
	}
	
	public void setLongitud(float longitud){
		this.longitud = longitud;
	}
	
	public Date getFechaSubida(){
		return this.fechaSubida;
	}
	
	public void setFechaSubida(Date fechaSubida){
		this.fechaSubida = fechaSubida;
	}
	
	
	
	
	
}
