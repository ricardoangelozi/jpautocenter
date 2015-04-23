package resources.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name = "menuBean")
public class MenuBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuModel model;
	 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
         
        //First submenu
        DefaultSubMenu primeiroSubmenu = new DefaultSubMenu("Parametrização");
         
        DefaultMenuItem item = new DefaultMenuItem("Marca");
        item.setUrl("/cadastroMarca.faces");
        item.setIcon("ui-icon-home");
        primeiroSubmenu.addElement(item);
        
        
        item = new DefaultMenuItem("Modelo");
        item.setUrl("/cadastroModelo.faces");
        item.setIcon("ui-icon-home");
        primeiroSubmenu.addElement(item);
        
        item = new DefaultMenuItem("Parceiros");
        item.setUrl("/cadastroParceiro.faces");
        item.setIcon("ui-icon-home");
        primeiroSubmenu.addElement(item);
        
        model.addElement(primeiroSubmenu);
         
        DefaultSubMenu segundoSubmenu = new DefaultSubMenu("Cadastro Peças");
        
        item = new DefaultMenuItem("Categoria");
        item.setUrl("/cadastroPecaCategoria.faces");
        item.setIcon("ui-icon-home");
        segundoSubmenu.addElement(item);
        
        item = new DefaultMenuItem("Pecas");
        item.setUrl("/cadastroPeca.faces");
        item.setIcon("ui-icon-home");
        segundoSubmenu.addElement(item);
        
        model.addElement(segundoSubmenu);

        //Second submenu
        DefaultSubMenu terceiroSubmenu = new DefaultSubMenu("Cadastro Serviços");
 
        item = new DefaultMenuItem("Serviço");
        item.setUrl("/cadastroServico.faces");
        item.setIcon("ui-icon-disk");
        terceiroSubmenu.addElement(item);
        model.addElement(terceiroSubmenu);
    }
 
    public MenuModel getModel() {
        return model;
    }   
     
    public void save() {
        addMessage("Success", "Data saved");
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
