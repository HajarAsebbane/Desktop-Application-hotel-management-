package Server;

import Classes.Chambre;
import DAO.Factory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Serveur {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        ServerSocket server = new ServerSocket(3002);
			while (true){
				System.out.println("test");
			    Socket client=server.accept();
			    ObjectInputStream obj_is=new ObjectInputStream(client.getInputStream());
			    Chambre obj_client= (Chambre) obj_is.readObject();
			    String message= Factory.getImp(obj_client);
			    DataOutputStream out=new DataOutputStream(client.getOutputStream());
			    out.writeUTF(message);
			    System.out.println(message);
			}
		}
}
