/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level; 
import java.util.logging.Logger;

/**
 *
 * @author tucha
 */
public class Conexao {
    private Connection conexao;
    
    
    public Connection abrirConexao(){
        String base = "clientesweb";
        String url = "jdbc:mysql://localhost:3306/"+base+"?userTimezone=true&severTimezone=UTC";
        String user = "root";
        String pass = "";
        
        try {
            conexao = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return conexao;
    }
    
    public void fecharConexao() throws SQLException{
        conexao.close();
       
        /*try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
