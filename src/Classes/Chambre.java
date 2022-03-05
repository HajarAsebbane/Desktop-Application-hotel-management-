package Classes;

import java.io.Serializable;

public class Chambre implements Serializable {
  private int n_porte;
  private int prix;
  private int id;
  private String methode_imp;
public Chambre(int n_porte, int prix,String methode_imp) {
	this.n_porte = n_porte;
	this.prix = prix;
	this.methode_imp=methode_imp;
}
public int getN_porte() {
	return n_porte;
}
public String getmethode_imp() {
	return methode_imp;
}
public void setN_porte(int n_porte) {
	this.n_porte = n_porte;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
@Override
public String toString() {
	return "Chambre [n_porte=" + n_porte + ", prix=" + prix + "]";
}


}
