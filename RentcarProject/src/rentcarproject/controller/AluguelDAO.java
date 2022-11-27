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
import rentcarproject.models.Aluguel;
import rentcarproject.models.Veiculos;

/**
 *
 * @author vinicius
 */
public class AluguelDAO {
    
    public String create(Aluguel aluguel){
        
        Connect connect = new Connect();
        
        if(connect.getConnection()){
            if(validaCPF(aluguel.cliente.getCpf())){
                try{
                
                    String sql = "INSERT INTO tb_aluguel (id_cliente,id_veiculo,data_aluguel,datadevolucao_aluguel, numdiaria_aluguel,valortotal_aluguel,metodo_aluguel) " 
                        +"SELECT id_cliente, id_veiculo, CURRENT_DATE,CURRENT_DATE + ?,?,? * valordiaria_veiculo, ? " 
                        +"FROM tb_cliente AS cliente, tb_veiculos AS veiculo " 
                        +"WHERE cliente.cpf_cliente = ? AND veiculo.placa_veiculo = ?; ";
            
                    PreparedStatement statement = connect.connection.prepareStatement(sql);
                    statement.setInt(1, aluguel.getNumDiaria());
                    statement.setInt(2, aluguel.getNumDiaria());
                    statement.setInt(3, aluguel.getNumDiaria());
                    statement.setString(4, aluguel.getMetodoPag());
                    statement.setString(5, aluguel.cliente.getCpf());
                    statement.setString(6, aluguel.veiculo.getPlaca());
          
                    statement.execute();
                    statement.close();
                    
                    String sql1 = "UPDATE tb_veiculos SET disponibilidade_veiculo = 'INDISPONIVEL' WHERE placa_veiculo = ?";
                    
                    PreparedStatement statement1 = connect.connection.prepareStatement(sql1);
                    statement1.setString(1, aluguel.veiculo.getPlaca());
                    
                    statement1.execute();
                    statement1.close();
                    
                    connect.close();
                    
                    
                    JOptionPane.showMessageDialog(null, "Locação realizada com sucesso!");
                    return "Locacao realizada com sucesso!";
                
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, erro.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return "Erro ao realizar locacao";
                }
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao realizar locação, verifique os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
                return "Erro ao realizar locacao";
            }
        }else{
            System.out.println("Erro ao conectar");
            return "Erro ao realizar locacao";
        }
       
    
    }


public List<Aluguel> read (){
        
        Connect connect = new Connect();     
        
        List<Aluguel> alugueis = new ArrayList<>();
        
        if(connect.getConnection()){
            try{
                
                String sql = "SELECT id_aluguel, cpf_cliente,placa_veiculo,modelo_veiculo,data_aluguel,datadevolucao_aluguel,valortotal_aluguel,metodo_aluguel " 
                        +"FROM tb_aluguel AS aluguel, tb_cliente AS cliente, tb_veiculos AS veiculo " 
                        +"WHERE aluguel.id_cliente = cliente.id_cliente AND " 
                        +"aluguel.id_veiculo = veiculo.id_veiculo";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                
                
                while(resultSet.next()){
                    
                    Aluguel aluguel = new Aluguel();
                    
                    aluguel.setId(resultSet.getInt("id_aluguel"));
                    aluguel.cliente.setCpf(resultSet.getString("cpf_cliente"));
                    aluguel.veiculo.setPlaca(resultSet.getString("placa_veiculo"));
                    aluguel.veiculo.setModelo(resultSet.getString("modelo_veiculo"));
                    aluguel.setData(resultSet.getDate("data_aluguel"));
                    aluguel.setDataentrega(resultSet.getDate("datadevolucao_aluguel"));
                    aluguel.setValor(resultSet.getFloat("valortotal_aluguel"));
                    aluguel.setMetodoPag(resultSet.getString("metodo_aluguel"));
                    
                    alugueis.add(aluguel);
          
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
    
        return alugueis;
    
    }

    public String delete (Aluguel aluguel){
        
        Connect connect = new Connect();     
        
        if(connect.getConnection()){
            try{
                
                String sql = "DELETE FROM tb_aluguel WHERE id_aluguel = ?";
            
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                
                statement.setInt(1, aluguel.getId());
       
                statement.executeUpdate();
                
                statement.close();
                connect.close();
                JOptionPane.showMessageDialog(null, "Veiculo desalocado com sucesso!");
                return "Exclusao concluida com sucesso";
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Desalocação não concluida!", "Erro", JOptionPane.ERROR_MESSAGE);
                return "Erro ao exluir";
            }
        }else{
            System.out.println("Erro ao conectar");
            return "Erro ao excluir";
        }
    
    }
    
    public boolean validaCPF(String cpf){
    
    Connect connect = new Connect();
    
    if(connect.getConnection()){
        
            try{
                
                String sql = "SELECT id_cliente FROM tb_cliente WHERE cpf_cliente = '"+cpf+"'";
                String resultado = "";
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    resultado = String.valueOf(resultSet.getInt("id_cliente"));
                }
                resultSet.close();
                statement.close();
                connect.close();
                
                if(!resultado.isEmpty()){
                    return true;
                }else{
                    return false;
                }

            }catch(SQLException erro){
                System.out.println(erro.toString());
                return false;
            }
        
        }else{
            JOptionPane.showMessageDialog(null, "Erro na leitura dos dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean validaPlaca(String placa){
    
        Connect connect = new Connect();
    
        if(connect.getConnection()){
        
            try{
                
                String sql = "SELECT id_veiculo FROM tb_veiculos WHERE placa_veiculo = '"+placa+"'";
                String resultado = "";
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    resultado = String.valueOf(resultSet.getInt("id_veiculo"));
                }
                resultSet.close();
                statement.close();
                connect.close();
                
                if(!resultado.isEmpty()){
                    return true;
                }else{
                    return false;
                }

            }catch(SQLException erro){
                System.out.println(erro.toString());
                return false;
            }
        
        }else{
            JOptionPane.showMessageDialog(null, "Erro na leitura dos dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
