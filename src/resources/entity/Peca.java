package resources.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PECA")
@SequenceGenerator(name = "PECA_SEQUENCE", sequenceName = "PECA_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Peca implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PECA_SEQUENCE")
	@Column(name = "PK_PECA")
	private Long id;

	@Column(name = "DS_PRDUTO")
	private String descricao;

	@Column(name = "VL_UNITARIO")
	private Double vlUnitario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PC_CATEGORIA")
	private Peca_Categoria pecaCategoria;

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

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public Peca_Categoria getPecaCategoria() {
		return pecaCategoria;
	}

	public void setPecaCategoria(Peca_Categoria pecaCategoria) {
		this.pecaCategoria = pecaCategoria;
	}

}