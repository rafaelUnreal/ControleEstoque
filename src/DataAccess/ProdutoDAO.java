/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.util.List;
import model.Produto;

/**
 *
 * @author rafael.rocha
 */
public interface ProdutoDAO {
    
    public List<Produto> getAllProdutos();
    public Produto getProduto(String nomeProduto);
    public void atualizaProduto(Produto prod);
    public void deleteProduto(Produto prod);
    public void insertProduto(Produto prod);
}
