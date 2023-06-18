/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author washington.riega
 */
public class ConnectionJdbc {
    public Connection con;
    public PreparedStatement pst;
    public ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","Was120603@");
        } catch(ClassNotFoundException ex) {
            System.out.println("Driver do JDBC não encontrado !");
            ex.printStackTrace();
        } catch(SQLException ex){
            System.out.println("Falha ao conectar ao banco de dados!");
            ex.printStackTrace();
        } 
    }
    
    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão!");
            e.printStackTrace();
        }
    }
}
