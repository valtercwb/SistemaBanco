package usuario;

public class Usuario {

    public static boolean logon(String login, String senha) {
        return UsuarioDAO.autenticar(login, senha);
    }
}
