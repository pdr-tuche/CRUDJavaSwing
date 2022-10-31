/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author tucha
 */
public class JDBCNewsletter {
    Connection conexao;

    public JDBCNewsletter(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirDados(Cliente pessoa){
        String sql = "INSERT INTO clientes(nome, email) VALUES (?,?);";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setString(2,pessoa.getEmail());
            ps.execute();
                        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public ArrayList<Cliente> listarClientes(){
        ArrayList<Cliente>clientes = new ArrayList<Cliente>();
        String sql = "SELECT * FROM clientes";
        
        try{
            Statement declaracao = conexao.createStatement();
            ResultSet response = declaracao.executeQuery(sql);
            
            while(response.next()){
                int auxint = response.getInt("id");
                String auxString1 = response.getString("nome");
                String auxString2 = response.getString("email");
                
                Cliente persona = new Cliente (auxint,auxString1,auxString2);
                clientes.add(persona);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return clientes;
    }
    
    public void apagarTudo(){
        String sql = "DELETE FROM clientes";
        
        PreparedStatement ps;
        
        try{
            ps = this.conexao.prepareStatement(sql);
            ps.execute();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
}
