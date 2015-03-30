package resources.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import resources.dao.MarcaDAO;
import resources.dao.ModeloDAO;
import resources.entity.Marca;
import resources.entity.Modelo;

@ManagedBean(name = "modeloBean")
public class ModeloBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ModeloDAO daoModelo = new ModeloDAO();
	
	MarcaDAO daoMarca = new MarcaDAO();
	
	Marca marca = new Marca();
	
	Modelo modelo = new Modelo();

	private List<Marca> marcas;

	public void salvarModelo(Modelo objeto) {
		objeto.setMarca(daoMarca.find(marca));
		daoModelo.incluir(objeto);
	}
	
	public List<Marca> getMarcas() {
		if (this.marcas == null) {
			return daoMarca.listar();
		}
		return marcas;
	}
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
