package louvre.demandes;


import java.util.Vector;

public class Photographe extends Utilisateur {
	private Vector<Demande> listeDemandesPrisesEnCharge = new Vector<Demande>();
	
	public Photographe(String login, String mdp) {
		super(login, mdp);
	}
	/**
	 * Appelle addDemande et teste le résultat
	 * Indique a la demande le photographe qui l'a pris en charge
	 * Passe l'état de la demande à PRIS_EN_CHARGE
	 * @param aDemande : La demande à prendre en charge
	 */
	public void prendreEnCharge(Demande aDemande) {
		if(this.addDemande(aDemande)){
			aDemande.setPriseEnChargePar(this);
		}
		else{
			System.out.println("La prise en charge a échoué.");
		}
		
	}
	/**
	 * Ajoute la demande aDemande a la liste des demandes prise en charge
	 * du photographe.
	 * Renvoie si oui ou non l'ajout a fonctionné
	 * @param aDemande : La demande à ajouter
	 * @return : true si l'ajout a fonctionné, sinon false
	 */
	public boolean addDemande(Demande aDemande) {
		if(listeDemandesPrisesEnCharge.add(aDemande)){
			
			System.out.println("Demande: "+aDemande.getNom()+" prise en charge !");
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Override Utilisateur.isPhotographe
	 */
	public boolean isPhotographe(){
		return true;
	}
	
	public Vector<Demande>getDemandes(){
		return this.listeDemandesPrisesEnCharge;
		
	}
}