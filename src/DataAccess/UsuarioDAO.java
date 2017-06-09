/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.util.List;
import model.Usuario;

/**
 *
 * @author rafael.rocha
 */
public interface UsuarioDAO {
    
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuario(String userAccount);
    public void atualizaUsuario(Usuario user);
    public void deleteUsuario(Usuario user);
    
}
