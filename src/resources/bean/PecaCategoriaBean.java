package resources.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import resources.dao.PecaCategoriaDAO;
import resources.entity.Peca_Categoria;

@ManagedBean(name = "pecaCategoria")
@ViewScoped
public class PecaCategoriaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PecaCategoriaDAO dao = new PecaCategoriaDAO();
	
	Peca_Categoria categoria = new Peca_Categoria();
	
	
	public void salvarCategoria(Peca_Categoria categoria){
		dao.incluir(categoria);
	}
	
	public PecaCategoriaDAO getDao() {
		return dao;
	}

	public void setDao(PecaCategoriaDAO dao) {
		this.dao = dao;
	}

	public Peca_Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Peca_Categoria categoria) {
		this.categoria = categoria;
	}


}
