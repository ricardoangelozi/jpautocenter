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
@Table(name = "TB_MARCA")
@SequenceGenerator(name="MARCA_SEQUENCE", sequenceName="MARCA_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Marca implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MARCA_SEQUENCE")
	@Column(name="PK_MARCA")
	private Long id;
	
	@Column( name = "NM_MARCA")
	private String marca;
	
	@Override
	public String toString() {
		return marca;
	}
	
	public Long getId() {
		return id;
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

//	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="marca", targetEntity = Modelo.class, fetch = FetchType.LAZY)
//	private List<Modelo> modelos;
//	
//	public void addItens(Modelo modelos){
//		modelos.setMarca(this);
//		this.modelos.add(modelos);
//	}
//		
//		public Marca() {
//		 this(0L);	
//		}
//	
//		public Marca(Long id){
//			this.id = id;
//			this.modelos = new LinkedList<Modelo>();
//		}
	
//	public List<Modelo> getModelos() {
//		return modelos;
//	}
//
//	public void setModelos(List<Modelo> modelos) {
//		this.modelos = modelos;
//	}
	
	

}
