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
import rentcarproject.models.Veiculos;

/**
 *
 * @author vinicius
 */
public class VeiculosDAO {
    
    public void create(Veiculos veiculo){
        
        Connect connect = new Connect();
        
        if(connect.getConnection()){
            try{
                
                String sql = "INSERT INTO tb_veiculos VALUES(DEFAULT,?,?,?,?,'DISPONIVEL')";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                statement.setString(1, veiculo.getMarca());
                statement.setString(2, veiculo.getModelo());
                statement.setString(3, veiculo.getPlaca());
                statement.setFloat(4, veiculo.getDiaria());
          
       
                statement.executeUpdate();
                
                statement.close();
                connect.close();
                JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar, verifique os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
                
        }else{
            System.out.println("Erro ao conectar");
        }
    
    }


    public List<Veiculos> read (){
        
        Connect connect = new Connect();     
        
        List<Veiculos> veiculos = new ArrayList<>();
        
        if(connect.getConnection()){
        
            try{
                
                String sql = "SELECT * FROM tb_veiculos";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                
                
                while(resultSet.next()){
                    
                    Veiculos veiculo = new Veiculos();
                
                    veiculo.setId(resultSet.getInt("id_veiculo"));
                    veiculo.setMarca(resultSet.getString("marca_veiculo"));
                    veiculo.setModelo(resultSet.getString("modelo_veiculo"));
                    veiculo.setPlaca(resultSet.getString("placa_veiculo"));
                    veiculo.setDiaria(resultSet.getFloat("valordiaria_veiculo"));
                    veiculo.setDisponibilidade(resultSet.getString("disponibilidade_veiculo"));
                    veiculos.add(veiculo);
          
                }
                
                resultSet.close();
                statement.close();
                connect.close();
                
            }catch(SQLException erro){
                System.out.println(erro.toString());
            }
        
        }else{
            JOptionPane.showMessageDialog(null, "Erro na leitura dos dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
            
        return veiculos;
    
    }
    
    public void update (Veiculos veiculo){
        
        Connect connect = new Connect();     
        
        if(connect.getConnection()){
            try{
                
                String sql = "UPDATE tb_veiculos SET marca_veiculo = ?,modelo_veiculo = ?,placa_veiculo = ?,valordiaria_veiculo = ?"
                        + "WHERE id_veiculo = ?";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                statement.setString(1, veiculo.getMarca());
                statement.setString(2, veiculo.getModelo());
                statement.setString(3, veiculo.getPlaca());
                statement.setFloat(4, veiculo.getDiaria());
                statement.setInt(5, veiculo.getId());
       
                statement.executeUpdate();
                
                statement.close();
                connect.close();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Alteração não concluida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            System.out.println("Erro ao conectar");
        }
    
    }
    
    public void delete (Veiculos veiculo){
        
        Connect connect = new Connect();     
        
        if(connect.getConnection()){
            try{
                
                String sql = "DELETE FROM tb_veiculos WHERE id_veiculo = ?";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                
                statement.setInt(1, veiculo.getId());
       
                statement.executeUpdate();
                
                statement.close();
                connect.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Exclusão não concluida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            System.out.println("Erro ao conectar");
        }
    
    }
    
}
