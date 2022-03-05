package DAO;

import Classes.Chambre;

import java.sql.SQLException;

public interface DaoChambre {
    public String AddChambre(Chambre ch) throws SQLException;
    public String UpdateCHambre(Chambre ch) throws SQLException;
    public String delete(Chambre ch)throws SQLException;
}
