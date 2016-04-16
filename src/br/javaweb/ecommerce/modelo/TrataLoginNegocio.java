/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.ecommerce.modelo;

/**
 *
 * @author escm
 */
public class TrataLoginNegocio {

    public boolean verificaLogin(Usuario usuario) {

        if("penha".equals(usuario.getUsuario()) && "123456".equals(usuario.getSenha())) {
            return true;

        }
        
        return false;
    }
}
