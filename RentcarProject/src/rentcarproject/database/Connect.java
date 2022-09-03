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
	
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBNAME = "RentCar";
    private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private final String LOGIN = "mysql_rent_car";
    private final String SENHA = "123456";
    
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
