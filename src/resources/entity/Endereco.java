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
@Table(name="TB_ENDERECO")
@SequenceGenerator(name="ENDERECO_SEQUENCE", sequenceName="ENDERECO_SEQUENCE", allocationSize=1, initialValue=0)
public class Endereco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ENDERECO_SEQUENCE")
	@Column(name="PK_ENDERECO")
	private Long id;
	
	@Column(name="DS_END")
	private String endereco;
	
	@Column(name="DS_BAIRRO")
	private String bairro;
	
	@Column(name="DS_COMPLEMENTO")
	private String complemento;
	
	@Column(name="NR_NUMERO")
	private Long numero;
	
	@Column(name="DS_CEP")
	private String cep;
	
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="CIDADE_ID")
	private Cidade cidade;
	
	public Endereco(){
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
}
