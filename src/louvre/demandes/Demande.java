package louvre.demandes;
import louvre.fiches.Oeuvre;


public class Demande {
	private EtatDemande etat;
	private String nom;
	private String description;
	private Historien createur;
	private Photographe priseEnChargePar = null;
	private Oeuvre oeuvre;

	public void getDemande(EtatDemande aEtat) {
	}

	public Demande(String aNom, String aDescription, Oeuvre aOeuvre, Historien createur) {
		this.etat = EtatDemande.EN_ATTENTE;
		this.setNom(aNom);
		this.description = aDescription;
		this.setOeuvre(aOeuvre);
		this.setCreateur(createur);
	}

	/**
	 * V�rifie si la demande est dans l'�tat <aEtat>
	 * @param aEtat
	 * @return true si oui, false sinon
	 */
	public boolean estEtat(EtatDemande aEtat) {
		if(aEtat == this.etat){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Affiche la demande et ses informations
	 * La page porte les boutons pour valider ou refuser
	 * une photo
	 * 
	 */
	public void afficher()
	{
		String demande ="";
		
		demande+="Demande: "+this.nom;
		demande +="\n\tOeuvre concern�e: "+this.oeuvre.getNom();
		demande +="\n\tDemandeur: "+this.createur;
		demande +="\n\tDescription: "+this.description;
		
		System.out.println(demande);
		//demande+="\n\t";
	}

	public void setEtat(EtatDemande aEtat) {
		this.etat = aEtat;
	}

	public EtatDemande getEtat() {
		return this.etat;
	}

	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	public String getDescription() {
		return this.description;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	public Photographe getPriseEnChargePar() {
		return priseEnChargePar;
	}

	public void setPriseEnChargePar(Photographe priseEnChargePar) {
		this.priseEnChargePar = priseEnChargePar;
		this.setEtat(EtatDemande.PRISE_EN_CHARGE);
	}
	

	public Historien getCreateur() {
		return createur;
	}

	public void setCreateur(Historien createur) {
		this.createur = createur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}