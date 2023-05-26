/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentcarproject.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import rentcarproject.database.Connect;
import rentcarproject.models.Usuario;

/**
 *
 * @author vinicius
 */
public class UsuarioDAO {
    
    public String create(Usuario usuario){
        
        Connect connect = new Connect();
        
        if(connect.getConnection()){
            
            try {
                
                String sql = "INSERT INTO tb_usuarios VALUES(DEFAULT,?,?)";
                
                PreparedStatement statement = connect.connection.prepareStatement(sql);
                statement.setString(1, usuario.getUsername());
                statement.setString(2, usuario.getPassword());
                
                statement.executeUpdate();
                statement.close();
                connect.close();
                JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                return "Usuario cadastrado com sucesso";
                
            }catch (SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar, verifique os dados", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return "Erro ao cadastrar, verifique os dados";
            }
            
        }else{
            System.out.println("Erro ao conectar");
            return "Erro ao cadastrar, verifique os dados";
        }
        
    }
    
}
