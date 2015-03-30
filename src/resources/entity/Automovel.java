package resources.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

	@Entity
	@Table(name = "TB_AUTOMOVEL")
	@SequenceGenerator(name="AUTOMOVEL_SEQUENCE", sequenceName="AUTOMOVEL_SEQUENCE", allocationSize = 1, initialValue = 0)
	public class Automovel {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTOMOVEL_SEQUENCE")
		@Column(name="PK")
		private Long id;
		
		//@Temporal(TemporalType.DATE)
		@Column(name="DT_ANO_FABRI")
		private Integer anoFabricao;
		
		//@Temporal(TemporalType.DATE)
		@Column(name="DT_ANO_MODELO")
		private Integer anoModelo;
		
		@Column(name="DS_MODELO")
		private String modelo;
		
		@Column(name="DS_MARCA")
		private String marca;
		
		@Column(name="DS_OBS")
		private String observacao;

		public String getObservacao() {
			return observacao;
		}

		public void setObservacao(String observacao) {
			this.observacao = observacao;
		}

		public Long getId() {
			return id;
		}

		public String getModelo() {
			return modelo;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}
		
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
		public Integer getAnoFabricao() {
			return anoFabricao;
		}

		public Integer getAnoModelo() {
			return anoModelo;
		}

		public void setAnoFabricao(Integer anoFabricao) {
			this.anoFabricao = anoFabricao;
		}

		public void setAnoModelo(Integer anoModelo) {
			this.anoModelo = anoModelo;
		}
		
	}



