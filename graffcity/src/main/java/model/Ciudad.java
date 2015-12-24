package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="ciudad")
@NamedQueries({
	@NamedQuery(name="Ciudad.findAll", query="SELECT a FROM Ciudad a"),
	
})



public class Ciudad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_ciudad", unique=true, nullable=false)
	private int ciudadId;
	
	@Column(name="id_pais", nullable=false)
	private int paisId;
	
	@Column(name="nombre_ciudad", nullable=false)
	private String nombreCiudad;
	
	public Ciudad() {
	}
	
	public int getCiudadId(){
		return this.ciudadId;
	}
	
	public void setCiudadId(int ciudadId){
		this.ciudadId = ciudadId;		
	}
	
	public int getPaisId(){
		return this.paisId;
	}
	
	public void setPaisId(int paisId){
		this.paisId = paisId;		
	}
	
	public String getnombreCiudad(){
		return this.nombreCiudad;
	}
	
	public void setnombreCiudad(String nombreCiudad){
		this.nombreCiudad = nombreCiudad;		
	}
	
	

}
