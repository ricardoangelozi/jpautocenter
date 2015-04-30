package resources.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import resources.dao.CidadeDAO;
import resources.dao.MarcaDAO;
import resources.dao.ModeloDAO;
import resources.dao.ParceirosDAO;
import resources.dao.PecaDAO;
import resources.dao.ServicoDAO;
import resources.dao.VeiculoDAO;
import resources.entity.Cidade;
import resources.entity.Marca;
import resources.entity.Modelo;
import resources.entity.Parceiro;
import resources.entity.Peca;
import resources.entity.Servico;
import resources.entity.Veiculo;
import resources.utils.Utils;
import resources.vo.ItensServicos;

@ManagedBean(name = "cadastroServicoBean")
@ViewScoped
public class CadastroServicoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4993049019194073795L;

	public CadastroServicoBean() {
		
	}
	
	private String dataAtual;
	private Boolean exibir = false;
	
	ParceirosDAO parceiroDao = new ParceirosDAO();
	ModeloDAO modeloDao = new ModeloDAO();
	MarcaDAO marcaDao = new MarcaDAO();
	VeiculoDAO veiculoDao = new VeiculoDAO();
	CidadeDAO cidadeDao = new CidadeDAO();
	ServicoDAO servicoDao = new ServicoDAO();
	PecaDAO pecaDao = new PecaDAO();
	
	private Veiculo veiculo = new Veiculo();
	private Servico servico = new Servico();
	private Peca peca = new Peca();
	Double valorTotal = new Double(0);
	
	
	
	private List<ItensServicos> itens = new ArrayList<ItensServicos>();
	private List<Cidade> cidades;
	private List<Modelo> modelos;
	private List<Marca> marcas;
	private List<Servico> servicos;
	private List<Peca> pecas;
	
	public void cadastrar(){
		
		if(validacoesCampos()){
			veiculo.getCliente().setDtCadastro(new Date());
			veiculo.setPlaca(veiculo.getPlaca().toUpperCase());
			veiculoDao.incluir(veiculo);
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN,null,"Preencha os Campos"));
		}
	}
	
	
	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public void adicionarServico(){
		ItensServicos iten = new ItensServicos();
		iten.setDescricao(servico.getDescricao());
		iten.setValor(servico.getVlUnitario());
		
		this.itens.add(iten);
		
		for (ItensServicos lista : itens) {
			valorTotal = valorTotal + lista.getValor();
		}
	}
	
	public void adicionarPecas(){
		
		ItensServicos itens = new ItensServicos();
			itens.setDescricao(peca.getDescricao());
			itens.setValor(peca.getVlUnitario());
		this.itens.add(itens);
	}
	
	
	public void mensagens(String campo){

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_WARN,null, "Campo Obrigatorio: " + campo));
	
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
	
	public List<Peca> getPecas(){
		if(pecas == null){
			return	pecas = pecaDao.listar();
		}
		return pecas;
	}
	
	public List<Cidade> getCidades(){
		if(this.cidades == null){
			return cidadeDao.listar();
		}
		return cidades;
		
	}
	
	public List<SelectItem> getParceiros(){
		List<Parceiro> parceiros = parceiroDao.listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(parceiros.size());
		
		for(Parceiro p : parceiros){
			itens.add(new SelectItem(p.getId(),p.getNomeParceiro()));
		}
		
		return itens;
	}
	
	
	public List<Modelo> getModelos(){
		if(this.modelos == null){
			return modeloDao.listar();
		}
		return modelos;
	}
	
	public List<Marca> getMarcas(){
		if(this.marcas == null){
			return marcaDao.listar();
		}
		return marcas;
	}
	
	public List<SelectItem> getAnos(){
		
		List<SelectItem> itens = new ArrayList<SelectItem>();
		for(Integer i = 1970; i < 2016; i++){
			itens.add(new SelectItem(i,i.toString()));
		}
		return itens;
	}
	
	public List<Servico> getServicos(){
		if(this.servicos == null){
			servicos = servicoDao.listar();
		}
		return servicos;
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
	
public Boolean validacoesCampos(){
		
		Boolean valida = true;
		
		if("".equals(veiculo.getPlaca())){
			valida = false; 
			mensagens("Placa");
		}
		
		if("".equals(veiculo.getCliente().getNome())){
			valida = false; 
			mensagens("Nome");
		}
		
		if("".equals(veiculo.getCliente().getTelFixo())){
			valida = false;
			mensagens("Telefone Fixo");
		}
		
		if("".equals(veiculo.getCliente().getTelCel())){
			valida = false;
			mensagens("Celular");
		}
		
		if("".equals(veiculo.getCliente().getEndereco().getEndereco())){
			valida = false;
			mensagens("Rua");
		}
		
		if("".equals(veiculo.getCliente().getEndereco().getNumero())){
			valida = false;
			mensagens("Nº");
		}
		
		if("".equals(veiculo.getCliente().getEndereco().getCep())){
			valida = false;
			mensagens("CEP");
		}
		
		if("".equals(veiculo.getCliente().getEndereco().getCidade())){
			valida = false;
			mensagens("Cidade");
		}
		
		if(veiculo.getModelo().getId() == 0){
			valida = false;
			mensagens("Ano Fabricação");
		}
		
		if("".equals(veiculo.getAnoFabricao())){
			valida = false;
			mensagens("Ano Fabricação");
		}
		
		if("".equals(veiculo.getAnoModelo())){
			valida = false;
			mensagens("Ano Modelo");
		}
		
		return valida;
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
	
	public Boolean getExibir() {
		return exibir;
	}

	public void setExibir(Boolean exibir) {
		this.exibir = exibir;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	public List<ItensServicos> getItens() {
		return itens;
	}


	public void setItens(List<ItensServicos> itens) {
		this.itens = itens;
	}


	public Peca getPeca() {
		return peca;
	}


	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	
}