package resources.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import resources.dao.MarcaDAO;
import resources.entity.Marca;

@ManagedBean(name = "marcaBean")
@ViewScoped
public class MarcaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MarcaDAO daoMarca = new MarcaDAO();
	
	Marca marca = new Marca();
	
	public void salvarMarca(Marca marca){
		daoMarca.incluir(marca);
	}
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
}
