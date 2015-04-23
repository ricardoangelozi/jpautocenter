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
@Table(name = "TB_SERVICO")
@SequenceGenerator(name = "SERVICO_SEQUENCE", sequenceName="SERVICO_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Servico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SERVICO_SEQUENCE")
	@Column(name = "PK_SERVICO")
	private Long id;
	
	@Column(name = "DS_SERVICO")
	private String descricao;
	
	@Column(name = "VL_UNITARIO")
	private Double vlUnitario;

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
	
	
	
}
