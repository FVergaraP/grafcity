package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="comuna")
@NamedQueries({
	@NamedQuery(name="Comuna.findAll", query="SELECT a FROM Comuna a"),
	
})



public class Comuna implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_comuna", unique=true, nullable=false)
	private int comunaId;
	
	@Column(name="id_ciudad", nullable=false)
	private int ciudadId;
	
	@Column(name="nombre_comuna", nullable=false)
	private String nombreComuna;
	
	public Comuna() {
	}
	
	public int getComunaId(){
		return this.comunaId;
	}
	
	public void setComunaId(int comunaId){
		this.comunaId = comunaId;		
	}
	
	public int getCiudadId(){
		return this.ciudadId;
	}
	
	public void setCiudadId(int ciudadId){
		this.ciudadId = ciudadId;		
	}
	
	public String getnombreComuna(){
		return this.nombreComuna;
	}
	
	public void setnombreComuna(String nombreComuna){
		this.nombreComuna = nombreComuna;		
	}
	
	

}