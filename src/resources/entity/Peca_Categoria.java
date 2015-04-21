package resources.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TB_PECA_CATEGORIA")
@SequenceGenerator(name = "PECA_CATEGORIA_SEQUENCE", sequenceName= "PECA_CATEGORIA_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Peca_Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PECA_CATEGORIA_SEQUENCE")
	@Column(name = "PK_CATEGORIA")
	private Long id;
	
	@Column(name = "DS_PECA_CATEGORIA")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	

}
