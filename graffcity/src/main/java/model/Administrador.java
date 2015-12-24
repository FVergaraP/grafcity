package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="administrador")
@NamedQueries({
	@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a"),
	
})



public class Administrador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_admin", unique=true, nullable=false)
	private int adminId;
	
	@Column(name="nombre_admin", nullable=false)
	private String nombreAdmin;
	
	@Column(name="apellido_admin", nullable=false)
	private String apellidoAdmin;
	
	@Column(name="nick_name_admin", nullable=false)
	private String nicknameAdmin;
	
	@Column(name="correo_admin", nullable=false, length=50)
	private String correoAdmin;
	
	@Column(name="password_admin", nullable=false, length=20)
	private String passwordAdmin;
	
	
	
	public Administrador() {
	}
	
	public int getAdminId(){
		return this.adminId;
	}
	
	public void setAdminId(int adminId){
		this.adminId = adminId;		
	}
	
	public String getNombreAdmin(){
		return this.nombreAdmin;
	}
	
	public void setNombreAdmin(String nombreAdmin){
		this.nombreAdmin = nombreAdmin;		
	}
	
	public String getApellidoAdmin(){
		return this.apellidoAdmin;
	}
	
	public void setApellidoAdmin(String apellidoAdmin){
		this.apellidoAdmin = apellidoAdmin;		
	}
	
	public String getCorreoAdmin() {
		return this.correoAdmin;
	}

	public void setCorreoAdmin(String correoAdmin) {
		this.correoAdmin = correoAdmin;
		
	}
	
	public String getPasswordAdmin() {
		return this.passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	
	

}