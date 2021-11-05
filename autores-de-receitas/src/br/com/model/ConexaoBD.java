package br.com.model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

    private static final String DB_NAME = "autor";
    private static final String ADDRESS = "127.0.0.1";
    private static final String PORTA = "3306";

    private static final String USUSARIO = "root";
    private static final String SENHA = "root";

    public static Connection getConnection(){
        try {
            var url = "jdbc:mysql://" + ADDRESS + ":" + PORTA + "/" + DB_NAME;
            return DriverManager.getConnection(url, USUSARIO, SENHA);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,
                    "Não foi possível conectar-se ao banco de dados!",
                    "Erro inesperado", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(2);
            return null;
        }
    }
}
