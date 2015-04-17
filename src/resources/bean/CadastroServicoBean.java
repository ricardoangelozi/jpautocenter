package resources.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import resources.dao.CidadeDAO;
import resources.dao.ClienteDAO;
import resources.dao.MarcaDAO;
import resources.dao.ModeloDAO;
import resources.dao.ParceirosDAO;
import resources.dao.VeiculoDAO;
import resources.entity.Automovel;
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
	private String marca;
	private Boolean exibir = false;
	
	ParceirosDAO parceiroDao = new ParceirosDAO();
	ModeloDAO modeloDao = new ModeloDAO();
	MarcaDAO marcaDao = new MarcaDAO();
	VeiculoDAO veiculoDao = new VeiculoDAO();
	ClienteDAO clienteDao = new ClienteDAO();
	CidadeDAO cidadeDao = new CidadeDAO();
	
	
	private Parceiro parceiro = new Parceiro();
	private Veiculo veiculo = new Veiculo();
	private Cliente cliente = new Cliente();
	
	
	private List<Cidade> cidades;
	private List<Modelo> modelos;
	
	private List<Veiculo> veiculos;
	
	public List<Veiculo> getVeiculos(){
		if(this.veiculos == null){
			return veiculoDao.listar();
		}
		return veiculos;
	}
	
	public void cadastrar(){
		veiculo.getCliente().setDtCadastro(new Date());
		veiculoDao.incluir(veiculo);
	}
	
	public void buscarCliente(){
		if(veiculo.getPlaca() != "") {
			veiculo = veiculoDao.listar(veiculo.getPlaca());
			this.exibir = true;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
			FacesMessage.SEVERITY_WARN,null,"Preencha o Campo Placa"));
		}
		
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
	
	public List<SelectItem> getMarcas(){
		List<Marca> marca = marcaDao.listar();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		
		for(Marca m : marca){
			itens.add(new SelectItem(m.getId(),m.getMarca()));
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
	
	public Boolean getExibir() {
		return exibir;
	}

	public void setExibir(Boolean exibir) {
		this.exibir = exibir;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}