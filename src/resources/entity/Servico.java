package resources.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

	@Entity
	@Table(name = "TB_SERVICO")
	@SequenceGenerator(name="SERVICO_SEQUENCE", sequenceName="SERVICO_SEQUENCE", allocationSize = 1, initialValue = 0)
	public class Servico {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SERVICO_SEQUENCE")
		@Column(name="PK")
		private Long id;
		
		@Column(name = "ID_PLACA")
		private Integer placa;
		
		@Column(name = "ID_CLIENTE")
		private Long idCliente;
		
		@Column(name = "ID_PARCEIRO")
		private Long idParceiro;
		
		@Column(name = "ID_MARCA")
		private Long idMarca;
		
		@Column(name = "ID_MODELO")
		private Long idModelo;
		
		@Column(name = "ID_FABRICACAO")
		private String anoFabricacao;
		
		@Column(name = "ANO_MODELO")
		private String anoModelo;
		
		@Column(name = "DS_MOTOR")
		private String motor;
		
		@Column(name = "DS_COR")
		private String cor;
		
		
		
		
		
	}