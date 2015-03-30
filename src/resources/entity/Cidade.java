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
@Table(name = "TB_CIDADE")
@SequenceGenerator(name = "CIDADE_SEQUENCE", sequenceName = "CIDADE_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Cidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CIDADE_SEQUENCE")
	@Column(name="PK_CIDADE")
	private Long id;
	
	@Column(name="DS_CIDADE")
	private String dsCidade;

	public Cidade(){
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}
	
	public String getDsCidade() {
		return dsCidade;
	}
}
