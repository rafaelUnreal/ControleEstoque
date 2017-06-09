/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rafael.rocha
 */
public class ModelBase {
    
    public Produto produto;
    public Usuario usuario;
    
    public ModelBase(){
        this.produto = new Produto();
        this.usuario = new Usuario();
    }
    
}
