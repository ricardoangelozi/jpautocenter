package resources.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import resources.dao.CidadeDAO;
import resources.dao.ClienteDAO;
import resources.dao.MarcaDAO;
import resources.dao.ModeloDAO;
import resources.dao.ParceirosDAO;
import resources.dao.VeiculoDAO;
import resources.entity.Cidade;
import resources.entity.Cliente;
import resources.entity.Marca;
import resources.entity.Modelo;
import resources.entity.Parceiro;
import resources.entity.Veiculo;
import resources.utils.Utils;

@ManagedBean(name = "cadastroServicoBean")
public class CadastroServicoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4993049019194073795L;

	
	
	public CadastroServicoBean() {
		
	}
	
	private String dataAtual;
	
	ParceirosDAO parceiroDao = new ParceirosDAO();
	ModeloDAO modeloDao = new ModeloDAO();
	VeiculoDAO veiculoDao = new VeiculoDAO();
	ClienteDAO clienteDao = new ClienteDAO();
	CidadeDAO cidadeDao = new CidadeDAO();
	
	
	private Parceiro parceiro = new Parceiro();
	private Veiculo veiculo = new Veiculo();
	private Cliente cliente = new Cliente();
	
	
	private List<Cidade> cidades;
	private List<Modelo> modelos;
	
	public void cadastrar(){
		veiculo.getCliente().setDtCadastro(new Date());
		veiculoDao.incluir(veiculo);
	}
	
	public List<Cidade> getCidades(){
		if(this.cidades == null){
			return cidadeDao.listar();
		}
		return cidades;
		
	}
	
	public List<Modelo> getModelos(){
		if(this.modelos == null){
			return modeloDao.listar();
		}
		return modelos;
	}
	
	public List<SelectItem> getParceiros(){
		List<Parceiro> parceiros = parceiroDao.listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(parceiros.size());
		
		for(Parceiro p : parceiros){
			itens.add(new SelectItem(p.getId(),p.getNomeParceiro()));
		}
		
		return itens;
	}
	
	public List<SelectItem> getAnos(){
		
		List<SelectItem> itens = new ArrayList<SelectItem>();
		for(Integer i = 1970; i < 2016; i++){
			itens.add(new SelectItem(i,i.toString()));
		}
		return itens;
	}
	
//	public List<SelectItem> getCidades(){
//		List<Cidade> cidades = cidadeDao.listar();
//		List<SelectItem> itens = new ArrayList<SelectItem>(cidades.size());
//		
//		for(Cidade c : cidades){
//			itens.add(new SelectItem(c.getId(), c.getDsCidade()));
//		}
//		return itens;
//	}
	
	
	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public String getDataAtual() {
		return dataAtual = Utils.converteData();
	}

	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}