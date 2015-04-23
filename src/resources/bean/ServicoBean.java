package resources.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import resources.dao.ServicoDAO;
import resources.entity.Servico;

@ManagedBean(name = "servicoBean")
@ViewScoped
public class ServicoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Servico servico = new Servico();
	ServicoDAO dao = new ServicoDAO();
	
	

	public ServicoBean() {
	}
	
	public void cadastrar(Servico servico){
		dao.incluir(servico);
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public ServicoDAO getDao() {
		return dao;
	}

	public void setDao(ServicoDAO dao) {
		this.dao = dao;
	}
	
	
	
}