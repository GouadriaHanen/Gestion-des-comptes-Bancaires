package Model;

public class Compte {
	static int Id =0;
	int numcp;
	private String nom ;
	private Double Solde ;
	public Compte(String nom, Double solde) {
		super();
		Id++;
		this.numcp=Id ;
		this.nom = nom;
		Solde = solde;
	}
	
	
	public int getNumcp() {
		return numcp;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getSolde() {
		return Solde;
	}
	public void setSolde(Double solde) {
		Solde = solde;
	}
	
	
	
	
	

}
