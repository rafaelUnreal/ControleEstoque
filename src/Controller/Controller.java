package Controller;

import SistemaCaixaView.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import DataAccess.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael.rocha
 */
public class Controller {
    private ModelBase model;
    private Login view;
    private UsuarioDAO userDAO;
    
    private List<Produto> prodList;

    private ActionListener actionListenerButtonLogin;
    private ActionListener actionListenerButtonLogout;
    private ActionListener actionListenerButtonCadastroUsuario;
    private ActionListener actionListenerButtonListaProdutos;
    private ActionListener actionListenerButtonCadastraProdutos;
    private ActionListener actionListenerButtonCadastraProdutoClicked;
    private ListSelectionListener listSelectionListaProdutos;
    
    
    public Controller(ModelBase model, Login view){
        this.model = model;
        this.view = view;
    }
    public void contol(){ 
        
        //ACTIONS
        actionListenerButtonLogin = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  linkBtnValidaUsuario();
              }
        };    
        actionListenerButtonLogout = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {                  
                  linkBtnLogout();
              }
        };
        actionListenerButtonCadastroUsuario = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  linkBtnCadastroUsuario();
              }
        }; 
        actionListenerButtonListaProdutos = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  linkBtnListaProdutos();
              }
        };
        actionListenerButtonCadastraProdutos = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  linkBtnCadastraProduto();
              }
        };
        actionListenerButtonCadastraProdutoClicked = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  linkBtnCadastraProdutoClicked();
              }
        };
        listSelectionListaProdutos = new ListSelectionListener() {
             public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  linkBtnJListclicked();
                }
             }
        };
        view.getButtonCadastraClicked().addActionListener(actionListenerButtonCadastraProdutoClicked);
        view.getButtonCadastraProduto().addActionListener(actionListenerButtonCadastraProdutos);
        view.getButton().addActionListener(actionListenerButtonLogin); 
        view.getButtonCadastro().addActionListener(actionListenerButtonCadastroUsuario); 
        view.getButtonLogout().addActionListener(actionListenerButtonLogout);
        view.getButtonListaProdutos().addActionListener(actionListenerButtonListaProdutos);
        view.getJListProdutos().addListSelectionListener(listSelectionListaProdutos);
        
        
    }
    
    private void linkBtnCadastraProduto(){
        view.cadProd.setLocationRelativeTo(null);
        view.cadProd.setVisible(true);
    }
    
    private void linkBtnCadastraProdutoClicked(){
        System.out.println("Button clicked");
        ProdutoDAO prodDAO = new ProdutoDAOImpl();
        prodDAO.insertProduto(view.getProdutoInsert());
        view.cadProd.cleanAllFields();
     
    }
    
    private void linkBtnJListclicked(){
       // System.out.println("Teste");
        ProdutoDAO prodDAO = new ProdutoDAOImpl();
        Produto prod = prodDAO.getProduto(view.getJListProdutos().getSelectedValue().toString());
        //System.out.println(view.getJListProdutos().getSelectedValue().toString());
        view.listaProd.showDetalhes(prod);
    }
    
    private void linkBtnListaProdutos(){
        System.out.println("Lista produtos");
        ProdutoDAO proDAO = new ProdutoDAOImpl();
        List<Produto> prodList = new ArrayList<Produto>(); 
        prodList = proDAO.getAllProdutos();
        view.showListaProdutos(prodList);
        
    }
    private void linkBtnLogout(){
        System.out.println("Logout");
        view.menu.setLocationRelativeTo(null);
        view.menu.setVisible(false);
        view.setVisible(true);
        
    }
    private void linkBtnCadastroUsuario(){
        System.out.println("Cadastro de Usuario");
        view.cadUser.setLocationRelativeTo(null);
        view.cadUser.setVisible(true);
        
    }
    private void linkBtnValidaUsuario(){
        
       // this.model.usuario.setUserAccount("Rafael");
       userDAO = new UsuarioDAOImpl();
       
       model.usuario = userDAO.getUsuario(view.getLogin());

       if(model.usuario == null){
           System.out.println("usuario invalido");
           view.showError();
           return;
       }
       
       System.out.println("Password" + model.usuario.getPassword());
     //TODO VALIDAR COM HASH DE SENHA
      if(view.getSenha().equals(model.usuario.getPassword())){
          
          view.menu.setLabelMenuUser(model.usuario.getUserAccount());
          view.showMenu();
        System.out.println("Validado");
    
    }
      else{
          view.showError();
          
      }
    
  }
}
