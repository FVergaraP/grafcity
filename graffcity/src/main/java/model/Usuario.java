package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
@Table(name="usuario")
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="VerificaUsuario", query="SELECT u FROM Usuario u WHERE u.nickname = :usuario AND u.contrasena = :password")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario", unique=true, nullable=false)
	private int usuarioId;

	@Column(name="nombre", nullable=false, length=30)
	private String nombre;

	@Column(name="apellido", nullable=false, length=30)
	private String apellido;

	@Column(name="nick_name", nullable=false, length=20)
	private String nickname;
	
	@Column(name="correo", nullable=false, length=50)
	private String correo;
	
	@Column(name="contrasena", nullable=false, length=20)
	private String contrasena;
	
	@Column (name="baneado", nullable=false)
	private boolean baneado;
	
	//@OneToMany(mappedBy="actor")
	//private List<FilmActor> films;
	
	public Usuario() {
	}
	

	/*List<FilmActor> getFilms() {
		return films;
	}



	void setFilms(List<FilmActor> films) {
		this.films = films;
	}
	
	public List<Film> sacarFilms(){
		List<Film> f = new ArrayList<Film>();
		
		for(FilmActor FIlm : this.films){
			f.add(FIlm.getFilm());
		}
		return f;
	}
*/

	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
		
	}public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public boolean getBaneado() {
		return this.baneado;
	}

	public void setBaneado(boolean baneado) {
		this.baneado = baneado;
	}


}
