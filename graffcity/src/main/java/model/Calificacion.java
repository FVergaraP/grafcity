package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="calificacion")

@NamedQueries({
	@NamedQuery(name="Calificacion.findAll", query="SELECT a FROM Calificacion a"),
	@NamedQuery(name="Calificacion.findTodos", query="SELECT c FROM Calificacion c"),
	/*@NamedQuery(name="Calificacion.findBest", query="SELECT a.graffitiId FROM Graffiti a GROUP BY a.graffitiId ORDER BY a.puntuacion"),*/
})




public class Calificacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_graffiti", nullable=false)
	private int graffitiId;
	
	@Id
	@Column(name="id_usuario", nullable=false)
	private int usuarioId;
	
	@Column(name="puntuacion", nullable=false)
	private int puntuacion;
	
	/*@ManyToOne
	@PrimaryKeyJoinColumn(name="id_graffiti", referencedColumnName = "id_graffiti")
	private Graffiti graffiti;*/
	
	public Calificacion() {
	}
	
	public int getGraffitiId(){
		return this.graffitiId;
	}
	
	public void setGraffitiId(int graffitiId){
		this.graffitiId = graffitiId;		
	}
	
	public int getUsuarioId(){
		return this.usuarioId;
	}
	
	public void setUsuarioId(int usuarioId){
		this.usuarioId = usuarioId;		
	}
	

	public int getPuntuacion() {
		return this.puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
/*	public Graffiti getGraffiti() {
		return graffiti;
	}

	public void setGraffiti(Graffiti graffiti) {
		this.graffiti = graffiti;
	}*/
	
	
}
