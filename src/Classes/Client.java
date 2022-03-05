package Classes;

public class Client {
   private int n_porte;
   private String nom_client;
   private String cin;
   private String date_debut;
   private String date_fin;
   private String etat_chambre;
public Client(int n_porte, String nom_client, String cin, String date_debut, String date_fin, String etat_chambre) {
	super();
	this.n_porte = n_porte;
	this.nom_client = nom_client;
	this.cin = cin;
	this.date_debut = date_debut;
	this.date_fin = date_fin;
	this.etat_chambre = etat_chambre;
}
public int getN_porte() {
	return n_porte;
}
public void setN_porte(int n_porte) {
	this.n_porte = n_porte;
}
public String getNom_client() {
	return nom_client;
}
public void setNom_client(String nom_client) {
	this.nom_client = nom_client;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getDate_debut() {
	return date_debut;
}
public void setDate_debut(String date_debut) {
	this.date_debut = date_debut;
}
public String getDate_fin() {
	return date_fin;
}
public void setDate_fin(String date_fin) {
	this.date_fin = date_fin;
}
public String getEtat_chambre() {
	return etat_chambre;
}
public void setEtat_chambre(String etat_chambre) {
	this.etat_chambre = etat_chambre;
}
@Override
public String toString() {
	return "Client [n_porte=" + n_porte + ", nom_client=" + nom_client + ", cin=" + cin + ", date_debut=" + date_debut
			+ ", date_fin=" + date_fin + ", etat_chambre=" + etat_chambre + "]";
}
   
   
   
   
}
