package br.com.fatec.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    public static String bancoDados, usuario, senha, servidor;
    public static int porta;
    
    //Variavel de Conexao
    public static java.sql.Connection conexao = null;
    
    static {
        bancoDados = "Padaria";
        usuario = "";
        senha = "";
        servidor = "localhost";
        porta = 3306;
    }
    
    //Metodos
    public static void conectar() throws SQLException {
        //MySQL
        String url = "jdbc:mysql://" + servidor + 
                     ":" + porta + "/" + bancoDados;

        conexao = DriverManager.getConnection(url, usuario, senha);
    }
    
    public static void desconectar() throws SQLException {
        conexao.close();
    }
    
    public static java.sql.Connection obterConexao() throws SQLException {
        if (conexao == null) {
            throw new SQLException("Conexão está fechada...");
        } else {
            return conexao;
        }
    }
}