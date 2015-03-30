package resources.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import resources.dao.AutomovelDAO;
import resources.dao.MarcaDAO;
import resources.entity.Automovel;
import resources.entity.Marca;
import resources.entity.Modelo;

@ManagedBean(name = "autoBean") 
public class AutomovelBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AutomovelDAO dao =  new AutomovelDAO();
	
	MarcaDAO marcaDao = new MarcaDAO();
	
	private Automovel automovel = new Automovel();
	
	private Modelo modelo = new Modelo();
	
	private Marca marca = new Marca();
	
	private List<Automovel> automoveis;
	
	public List<Automovel> getAutomoveis(){
		if(this.automoveis == null){
			return dao.listar();
		}
		return automoveis;
	}
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public AutomovelBean(){
		
	}
	
	public void salva(Automovel automovel){
		dao.incluir(automovel);
	}
	
	public void salvarMarca(Modelo modelo){
//		marca.setId(1L);
//		marca = marcaDao.find(marca);
//		marca.addItens(modelo);
//		marcaDao.incluir(marca);
	}
	
	public void exclui(Automovel automoveis){
		dao.excluir(automoveis);
	}
	
	public MarcaDAO getMarcaDao() {
		return marcaDao;
	}

	public void setMarcaDao(MarcaDAO marcaDao) {
		this.marcaDao = marcaDao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public Automovel getAutomovel() {
		return automovel;
	}
	
	public AutomovelDAO getDao() {
		return dao;
	}

	public void setDao(AutomovelDAO dao) {
		this.dao = dao;
	}
}
