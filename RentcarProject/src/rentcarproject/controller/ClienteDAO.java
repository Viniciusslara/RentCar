/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentcarproject.controller;

import rentcarproject.database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rentcarproject.models.Cliente;

/**
 *
 * @author vinicius
 */
public class ClienteDAO {
    

    public String create(Cliente client){
        
        Connect connect = new Connect();     
        
        if(connect.getConnection()){
            try{
                
                String sql = "INSERT INTO tb_cliente (id_cliente,nome_cliente,datanasc_cliente,tel_clinte,cpf_cliente,cnh_cliente) "
                        + "VALUES(DEFAULT,?,?,?,?,?)";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                statement.setString(1, client.getNome());
                statement.setString(2, client.getDataNasc());
                statement.setString(3, client.getTelefone());
                statement.setString(4, client.getCpf());
                statement.setString(5, client.getCnh());
       
                statement.executeUpdate();
                
                statement.close();
                connect.close();
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                return "Cliente cadastrado com sucesso";
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar, verifique os dados", "Erro", JOptionPane.ERROR_MESSAGE);
                return "Erro ao cadastrar, verifique os dados";
            }
        }else{
            System.out.println("Erro ao conectar");
            return "Erro ao cadastrar, verifique os dados";
        }
    
    }
    
    public List<Cliente> read (){
        
        Connect connect = new Connect();     
        
        List<Cliente> client = new ArrayList<>();
        
        if(connect.getConnection()){
            try{
                
                String sql = "SELECT * FROM tb_cliente";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                
                
                while(resultSet.next()){
                    
                    Cliente cliente = new Cliente();
                    
                    cliente.setId(resultSet.getInt("id_cliente"));
                    cliente.setNome(resultSet.getString("nome_cliente"));
                    cliente.setDataNasc(resultSet.getString("datanasc_cliente"));
                    cliente.setTelefone(resultSet.getString("tel_clinte"));
                    cliente.setCpf(resultSet.getString("cpf_cliente"));
                    cliente.setCnh(resultSet.getString("cnh_cliente"));
                    client.add(cliente);
                }
                
                resultSet.close();
                statement.close();
                connect.close();
                
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro na leitura", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            System.out.println("Erro ao conectar");
        }
    
        return client;
    
    }

    public String update (Cliente client){
        
        Connect connect = new Connect();     
        
        if(connect.getConnection()){
            try{
                
                String sql = "UPDATE tb_cliente SET nome_cliente = ?,datanasc_cliente = ?,tel_clinte = ?,cpf_cliente = ?,cnh_cliente = ? "
                        + "WHERE id_cliente = ?";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                statement.setString(1, client.getNome());
                statement.setString(2, client.getDataNasc());
                statement.setString(3, client.getTelefone());
                statement.setString(4, client.getCpf());
                statement.setString(5, client.getCnh());
                statement.setInt(6, client.getId());
       
                statement.executeUpdate();
                
                statement.close();
                connect.close();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                return "Alterado com sucesso!";
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Alteração não concluida!", "Erro", JOptionPane.ERROR_MESSAGE);
                return "Alteração não concluida";
            }
        }else{
            System.out.println("Erro ao conectar");
            return "Erro ao conectar";
        }
    
    }
    
    public String delete (Cliente client){
        
        Connect connect = new Connect();     
        
        if(connect.getConnection()){
            try{
                
                String sql = "DELETE FROM tb_cliente WHERE id_cliente = ?";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                
                statement.setInt(1, client.getId());
       
                statement.executeUpdate();
                
       
                statement.close();
                connect.close();
                
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                return "Excluido com sucesso";
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Exclusão não concluida!", "Erro", JOptionPane.ERROR_MESSAGE);
                return "Exclusao não concluida";
            }
        }else{
            System.out.println("Erro ao conectar");
            return "Erro ao conectar";
        }
    
    }
  
}
