package DAO;

import Classes.Chambre;
import Implementation.Impchambre;

import java.sql.SQLException;

public class Factory {


    public static String getImp(Chambre ch) throws SQLException {
        System.out.println(ch.getmethode_imp());
        return ch.getmethode_imp().equalsIgnoreCase((String)"update")?new Impchambre().UpdateCHambre(ch):ch.getmethode_imp().equalsIgnoreCase((String)"add") ?new Impchambre().AddChambre(ch):new Impchambre().delete(ch);
    }
}
