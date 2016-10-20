package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db {

    private Connection conexao;
    private Statement statement;
    public PreparedStatement pst;

    String url = "jdbc:mysql://localhost:3306/";
    String usuario = "root";
    String senha = "2429";
    String unicode = "?useUnicode=yes&characterEncoding=UTF-8";

    public Connection open() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url + "valter_banco" + unicode, usuario, senha);

        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Too Many Connections");
        }

        return conexao;
    }

    //--------------------------------------------------------------------------
    private void close() {
        try {
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.conexao != null) {
                this.conexao.close();
            }
        } catch (Exception error) {
            String mensagem;
            mensagem = "Erro ao fechar a conexão.\n";
            System.out.println(mensagem + error.getMessage());
        }
    }

    public ResultSet query(String sql, int tipo) throws ClassNotFoundException, SQLException {

        if (this.conexao == null || this.statement == null) {
            open();
        }

        ResultSet result;
        result = null;

        if (tipo == 1) {
            result = this.statement.executeQuery(sql);
        } else {
            statement.executeUpdate(sql);
        }

        return result;
    }
    //--------------------------------------------------------------------------

    public void setQuerySql(String sql) throws ClassNotFoundException, SQLException {
        if (this.conexao == null || this.statement == null) {
            open();
        }

        this.pst = this.conexao.prepareStatement(sql);

    }

    //--------------------------------------------------------------------------
    public PreparedStatement setQueryParameter() {

        return this.pst;

    }

}
