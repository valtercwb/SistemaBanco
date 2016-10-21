package sistemabanco;

import DataBase.DataModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaBanco {

    public static void main(String[] args){
    
            DataModel model = new DataModel();
        try {
            model.createDataBase();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SistemaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
     
            //instancia e cria objetos

            new banco.bancoAutentica().setVisible(true);
        

}
}