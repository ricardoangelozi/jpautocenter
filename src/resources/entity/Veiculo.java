package resources.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "TB_VEICULO")
@SequenceGenerator(name="VEICULO_SEQUENCE", sequenceName="VEICULO_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Veiculo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "VEICULO_SEQUENCE")
	@Column(name="ID_VEICULO")
	private Long id;
	
	@Column(name="DT_ANO_FABRI")
	private String anoFabricao;
	
	@Column(name="DT_ANO_MODELO")
	private String anoModelo;
	
	@Column(name="TP_MOTOR")
	private String motor;
	
	@Column(name="DS_COR")
	private String cor;
	
	@Column(name="NR_PLACA", unique=true, nullable=false)
	private String placa;
	
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente = new Cliente();
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="MODELO_ID")
	private Modelo modelo = new Modelo();
	
	public String getAnoFabricao() {
		return anoFabricao;
	}
	public void setAnoFabricao(String anoFabricao) {
		this.anoFabricao = anoFabricao;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
