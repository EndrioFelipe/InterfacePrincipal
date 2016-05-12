/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author endrio
 */
public class ConectaBanco {
    public Statement stm;//responsável por preparar e realizar pesquisas no BD.
    public ResultSet rs;//responsável por armezenar o reesultado de uma pesquisa passada para o Statement.
    private String driver = "org.postgresql.Driver";//responsável por identificar o serviço de BD.
    private String caminho = "jdbc:postgresql://localhost:5432/sistema1"; // setar o lacal do BD.
    private String usuario = "postgres"; 
    private String senha = "103549";
    public Connection con;//responsável por realizar a conexão com o BD.
    
    public void conexao(){
        System.setProperty("jdbc.Drivers", driver);//seta a propriedade do driver de conexão
        try {
            this.con=DriverManager.getConnection(caminho, usuario, senha);//realiza a conexão
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão.\n Erro:"+ex.getMessage());
        }
        
    }
    public void desconecta(){
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "Desconectado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar.\n Erro:"+ex.getMessage());
        }
    }
}
