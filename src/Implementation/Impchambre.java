package Implementation;

import Classes.Chambre;
import DAO.DaoChambre;
import Connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Impchambre implements DaoChambre {
    Connection con;
    Statement st;
    ResultSet rs;

    @Override
    public String AddChambre(Chambre obj) throws SQLException {
        con=Connect.getConnection();
        st=con.createStatement();
        int N_port;
        int prix;
        N_port=obj.getN_porte();
        prix=obj.getPrix();
        System.out.println("add zone");
        st.executeUpdate("insert into chambre values("+N_port+","+prix+")");
        String message="added";
        return message;
    }

    @Override
    public String UpdateCHambre(Chambre ch) throws SQLException {
        con=Connect.getConnection();
        st=con.createStatement();
        int N_port;
        int prix;
        N_port=ch.getN_porte();
        prix=ch.getPrix();
        String sql="update chambre set prix="+prix+" where N_porte="+N_port;
        System.out.println(sql);
        int rs=st.executeUpdate(sql);
        String message="added";
        return message;
    }
    public String delete(Chambre ch) throws SQLException {
        con=Connect.getConnection();
        st=con.createStatement();
        int N_port;
        N_port=ch.getN_porte();
        String sql="delete from chambre where N_porte="+N_port;
        System.out.println(sql);
        int rs=st.executeUpdate(sql);
        return "deleted";
    }
}
