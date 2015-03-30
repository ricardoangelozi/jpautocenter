package resources.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import resources.dao.ParceirosDAO;
import resources.entity.Parceiro;

@ManagedBean(name = "parceiroBean")
public class ParceiroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ParceirosDAO daoParceiro = new ParceirosDAO();
	
	Parceiro parceiro = new Parceiro();
	
	public void salvarParceiro(Parceiro objeto) {
		daoParceiro.incluir(objeto);
	}

	public ParceirosDAO getDaoParceiro() {
		return daoParceiro;
	}

	public void setDaoParceiro(ParceirosDAO daoParceiro) {
		this.daoParceiro = daoParceiro;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}
}
