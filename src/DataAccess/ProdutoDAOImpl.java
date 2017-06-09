/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;
import model.Usuario;

/**
 *
 * @author rafael.rocha
 */
public class ProdutoDAOImpl implements ProdutoDAO {
    private List<Produto> prodList;
    private Produto prod;

    @Override
    public List<Produto> getAllProdutos() {
         System.out.println("GetALL");

        try {
            // Conexao con1 = new Conexao();
            System.out.println("Conectar");
            String selectSQL = "SELECT * FROM produto";
            Conexao.getConexaoMySQL();
            PreparedStatement stm = Conexao.getConexaoMySQL().prepareStatement(selectSQL);
            
            ResultSet rs =  stm.executeQuery();
            
            if(!rs.isBeforeFirst()){
                prodList = null;
                return prodList;
            }
            else{
                
            prodList = new ArrayList<Produto>();  
            
               while (rs.next()){
                Produto prod = new Produto();    
                prod.setNome(rs.getString("nomeProduto"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prodList.add(prod);
                
                System.out.println("Produto " + rs.getString("nomeProduto"));
              

                 }
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return prodList;

    }   
    

    public Produto getProduto(String nomeProduto) {
       System.out.println("GetALL");

        try {
            // Conexao con1 = new Conexao();
            System.out.println("Conectar");
            String selectSQL = "SELECT * FROM produto where nomeProduto = ?";
            Conexao.getConexaoMySQL();
        
            PreparedStatement stm = Conexao.getConexaoMySQL().prepareStatement(selectSQL);
            stm.setString(1,nomeProduto);
            
            ResultSet rs =  stm.executeQuery();
            
            if(!rs.isBeforeFirst()){
                prodList = null;
                return prod;
            }
            else{
                
            prod = new Produto();  
            
               while (rs.next()){
                   
                prod.setNome(rs.getString("nomeProduto"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setQuantidade(rs.getInt("quantidade"));

                System.out.println("Produto " + rs.getString("nomeProduto"));
              

                 }
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return prod;
    }

    @Override
    public void atualizaProduto(Produto prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduto(Produto prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertProduto(Produto prod) {
        
        System.out.println("Insert Produto");

        try {
            // Conexao con1 = new Conexao();
            System.out.println("Conectar");
            String insertSQL = "INSERT into Produto(nomeProduto,descricao,preco,quantidade)";
            insertSQL = insertSQL +("Values(?,?,?,?)");
            Conexao.getConexaoMySQL();
        
            PreparedStatement stm = Conexao.getConexaoMySQL().prepareStatement(insertSQL);
            stm.setString(1,prod.getNome());
            stm.setString(2,prod.getDescricao());
            stm.setFloat(3,prod.getPreco());
            stm.setInt(4, prod.getQuantidade());
            stm.executeUpdate();
            stm.close();
            }
               
         catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
