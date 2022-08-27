/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentcarproject.database;

/**
 *
 * @author vinicius
 */

import java.sql.*;
import javax.swing.*;

public class Connect {

    public Connection connection = null;
	
    private final String DRIVER = "org.postgresql.Driver";
    private final String DBNAME = "RentCar";
    private final String URL = "jdbc:postgresql://localhost:5432/" + DBNAME;
    private final String LOGIN = "postgres";
    private final String SENHA = "10121430";
    
    public boolean getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,LOGIN,SENHA);
            System.out.println("Conexão realizada com sucesso");
            return true;
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Drive não encontrado!\n" +
                    erro.toString());
            return false;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados\n" +
                    erro.toString());
            return false;
        }
    }

    public void close() {
    	try {
    		connection.close();
    		System.out.println("Desconectou");
    	}catch(SQLException erro) {
    	}
    }
    
}
