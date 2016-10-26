package modelDAO;

import DataBase.Db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public UsuarioDAO() {
    }

    public static boolean autenticar(String login, String senha) {
        boolean retorno = false;
        try {

            Db myDb = new Db();// conecta com o banco
            String sql = "SELECT usu_codigo AS codigo, usu_login AS login,\n"
                    + " usu_email AS email\n"
                    + "FROM usuario WHERE usu_login = ? AND usu_senha= MD5(?)\n"
                    + "AND usu_status = '1';";

            myDb.setQuerySql(sql);// pede um comando sql
            myDb.setQueryParameter().setString(1, login);
            myDb.setQueryParameter().setString(2, senha);

            ResultSet resultado = myDb.setQueryParameter().executeQuery();

            if (resultado.next()) {
                retorno = true;
            }

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return retorno;
    }

    public static boolean logon(String login, String senha) {
        return UsuarioDAO.autenticar(login, senha);

    }

    public int addPerson(String nome, String lname, String email, String num) {
        PreparedStatement pst;
        Db myDb = new Db();
        pst = con.open().prepareStatement("INSERT INTO Usuario "
                + "(nome, LastName, Email, PhoneNumber) "
                + "VALUES (?, ?, ?, ?)");

        int result = 0;

        // set parameters, then execute insertNewPerson
        pst.setString(1, nome);
        pst.setString(2, lname);
        pst.setString(3, email);
        pst.setString(4, num);

// insert the new entry; returns # of rows updated
        result = pst.executeUpdate();

    }  
        ) {
           
        close();
    }
    return result ;
}



// sql injection
