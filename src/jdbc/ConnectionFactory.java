/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author gabri
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdcontroletarefas", "root", "root");
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
