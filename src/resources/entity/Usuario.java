package resources.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	
	
	@Id
	@Column(name = "ID_USUARIO")
	private Integer idUsuario;
	
	@Column(name = "NM_USUARIO")
	private String nmUsuario;
	
	@Column(name = "DS_SENHA")
	private String dsSenha;
	

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	
}
