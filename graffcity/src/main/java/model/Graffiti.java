package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="graffiti")

@NamedQueries({
	@NamedQuery(name="Graffiti.findAll", query="SELECT a FROM Graffiti a"),
	@NamedQuery(name="Graffiti.findByUserId", query="SELECT a FROM Graffiti a WHERE a.autorId = :autorId"),
	@NamedQuery(name="Graffiti.findByGPS", query="SELECT a FROM Graffiti a WHERE a.latitud > :latitudAbajo AND a.latitud < :latitudArriba AND a.longitud > :longitudAbajo AND a.longitud < :longitudArriba AND a.revision= :revision"),
	@NamedQuery(name="Graffiti.findRango", query="SELECT a FROM Graffiti a WHERE a.graffitiId >= :first AND a.graffitiId <= :last"),
	@NamedQuery(name="Graffiti.deleteForId", query="DELETE FROM Graffiti a WHERE a.graffitiId = :graffitiId"),
	@NamedQuery(name="Graffiti.findByAvg", query="SELECT a FROM Graffiti a ORDER BY a.promedio DESC"),
	
	//a.id_graffiti ='1'"

	
})

@NamedStoredProcedureQuery(
	    name = "ObtenerParametro",
	    resultClasses = Integer.class,
	    procedureName = "mostrar_AVG",
	    parameters = {
	        @StoredProcedureParameter(mode=ParameterMode.IN, name="graff_id", type=int.class)
	    }
	)

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
	
	@Column(name="link_foto_1", nullable=false, length=100)
	private String linkFoto1;
	
	@Column(name="link_foto_2", nullable=false, length=100)
	private String linkFoto2;
	
	@Column(name="link_foto_3", nullable=false, length=100)
	private String linkFoto3;
	
	@Column(name="link_foto_4", nullable=false, length=100)
	private String linkFoto4;		
	
	@Column(name="descripcion_Graf", nullable=false, length=2000)
	private String descripcionGraf;
	
	@Column(name="latitud", nullable=false)
	private double latitud;
	
	@Column(name="longitud", nullable=false)
	private double longitud;
	
	@Column(name="fecha_subida", nullable=false)
	private Timestamp fechaSubida;
	
	@Column(name="revision", nullable=false)
	private boolean revision;
	
	@Column(name="avg_calif", nullable=false)
	private int promedio;
	
	
	
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
	
	public String getLinkFoto1() {
		return this.linkFoto1;
	}

	public void setLinkFoto1(String linkFoto1) {
		this.linkFoto1 = linkFoto1;
	}
	
	public String getLinkFoto2() {
		return this.linkFoto2;
	}

	public void setLinkFoto2(String linkFoto2) {
		this.linkFoto2 = linkFoto2;
	}
	
	public String getLinkFoto3() {
		return this.linkFoto3;
	}

	public void setLinkFoto3(String linkFoto3) {
		this.linkFoto3 = linkFoto3;
	}
	
	public String getLinkFoto4() {
		return this.linkFoto4;
	}

	public void setLinkFoto4(String linkFoto4) {
		this.linkFoto4 = linkFoto4;
	}
	
	public String getDescripcionGraf(){
		return this.descripcionGraf;
	}
	
	public void setDescripcionGraf(String descripcionGraf){
		this.descripcionGraf = descripcionGraf;
	}
	
	public double getLatitud(){
		return this.latitud;
	}
	
	public void setLatitud(double latitud){
		this.latitud = latitud;
	}
	
	public double getLongitud(){
		return this.longitud;
	}
	
	public void setLongitud(double longitud){
		this.longitud = longitud;
	}
	
	public Timestamp getFechaSubida(){
		return this.fechaSubida;
	}
	
	public void setFechaSubida(Timestamp fechaSubida){
		this.fechaSubida = fechaSubida;
	}
	
	public boolean getRevision(){
		return this.revision;
	}
	
	public void setRevision(boolean revision){
		this.revision = revision;
	}
	
	public int getPromedio(){
		return this.promedio;
	}
	
	public void setPromedio(int promedio){
		this.promedio = promedio;
	}
	
	
	
	
	
}
