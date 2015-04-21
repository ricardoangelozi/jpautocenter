package resources.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import resources.dao.PecaCategoriaDAO;
import resources.dao.PecaDAO;
import resources.entity.Peca;
import resources.entity.Peca_Categoria;

@ManagedBean(name = "pecaBean")
@ViewScoped
public class PecaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PecaDAO dao = new PecaDAO();
	
	PecaCategoriaDAO daoCategoria = new PecaCategoriaDAO();
	
	private List<Peca_Categoria> pecasCategorias;  
	
	Peca peca = new Peca();
	
	Peca_Categoria categoria = new Peca_Categoria();
	
	public void salvarPeca(Peca peca){
		peca.setPecaCategoria(daoCategoria.find(categoria));
		dao.incluir(peca);
	}
	
	public List<Peca_Categoria> getPecasCategorias(){
		if(this.pecasCategorias == null){
			return daoCategoria.listar();
		}
		return pecasCategorias;
	}

	public PecaDAO getDao() {
		return dao;
	}

	public void setDao(PecaDAO dao) {
		this.dao = dao;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	public PecaCategoriaDAO getDaoCategoria() {
		return daoCategoria;
	}

	public void setDaoCategoria(PecaCategoriaDAO daoCategoria) {
		this.daoCategoria = daoCategoria;
	}

	public Peca_Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Peca_Categoria categoria) {
		this.categoria = categoria;
	}

}
