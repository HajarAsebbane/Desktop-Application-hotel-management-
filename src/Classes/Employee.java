package Classes;

public class Employee {
   private int numero;
   private String nom;
   private String prenom;
   private String N_tel;
   private String adresse;
   private String cin;
   private String fonction;
public Employee(int numero, String nom, String prenom, String n_tel, String adresse, String cin, String fonction) {
	
	this.numero = numero;
	this.nom = nom;
	this.prenom = prenom;
	this.N_tel = n_tel;
	this.adresse = adresse;
	this.cin = cin;
	this.fonction = fonction;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getN_tel() {
	return N_tel;
}
public void setN_tel(String n_tel) {
	N_tel = n_tel;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getFonction() {
	return fonction;
}
public void setFonction(String fonction) {
	this.fonction = fonction;
}
@Override
public String toString() {
	return "Employee [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", N_tel=" + N_tel + ", adresse="
			+ adresse + ", cin=" + cin + ", fonction=" + fonction + "]";
}


   
   
   
}
