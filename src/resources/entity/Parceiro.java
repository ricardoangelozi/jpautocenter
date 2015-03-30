package resources.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TB_PARCEIRO")
@SequenceGenerator(name="PARCEIRO_SEQUENCE", sequenceName="PARCEIRO_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Parceiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PARCEIRO_SEQUENCE")
	@Column(name="PK")
	private Integer id;
	
	@Column(name = "DS_PARCEIRO")
	private String nomeParceiro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeParceiro() {
		return nomeParceiro;
	}

	public void setNomeParceiro(String nomeParceiro) {
		this.nomeParceiro = nomeParceiro;
	}

}
