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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author rafael.rocha
 */
public class UsuarioDAOImpl implements UsuarioDAO {
    

    private Usuario user;
    
    @Override
    public Usuario getUsuario(String userAccount) {
         System.out.println("User account = " + userAccount);

        try {
            // Conexao con1 = new Conexao();
            System.out.println("Conectar");
            String selectSQL = "SELECT * FROM usuario WHERE userAccount = ?";
            Conexao.getConexaoMySQL();
            PreparedStatement stm = Conexao.getConexaoMySQL().prepareStatement(selectSQL);
            stm.setString(1, userAccount);
            
            ResultSet rs =  stm.executeQuery();
            
            if(!rs.isBeforeFirst()){
                user = null;
                return user;
            }
            else{
                
            user = new Usuario();  
               while (rs.next()){
                    
                user.setNomeCompleto(rs.getString("nomeCompleto"));
                user.setUserAccount(rs.getString("userAccount"));
                user.setPassword(rs.getString("Senha"));
                System.out.println("Senha" + rs.getString("Senha"));
                user.setCPF(rs.getString("CPF"));

                 }
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return user;

    }
    
   

    @Override
    public List<Usuario> getAllUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void atualizaUsuario(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUsuario(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
