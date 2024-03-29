package louvre.fiches;

import java.util.Vector;

public class Systeme {
	
	// la liste des d�partements (utilis�e pour une recherche par d�partement plus rapide et plus simple)
	private Vector<Departement> _listeDeps = new Vector<Departement>();
	// la liste des oeures du mus�e
	private Vector<Oeuvre> _listeOeuvres = new Vector<Oeuvre>();
	// la liste des auteurs (utilis�e pour une recherche par auteur plus rapide et plus simple)
	private Vector<Auteur> _listeAuteurs = new Vector<Auteur>();
	
	public Systeme (){
		Departement sg = new Departement("Sculptures grecques");
		Departement peinture = new Departement("Peinture");
		
		Auteur leonardDV = new Auteur("Leonard", "De Vinci");
		Auteur michelAnge = new Auteur("Michel", "Ange");
		
		Vector<Auteur> vect1,vect2; 
		vect1 = new Vector<Auteur>();
		vect2 = new Vector<Auteur>();
		
		vect1.add(leonardDV);
		vect2.add(michelAnge);
		_listeAuteurs.add(leonardDV);
		_listeAuteurs.add(michelAnge);
		_listeAuteurs.add(Auteur.auteurInconnu);
		
		Oeuvre joconde = new Oeuvre("Joconde", "1510-1515", "Lorem Ipsum Dolores ...", peinture, vect1);
		Oeuvre esclave = new Oeuvre ("Esclave mourant", "1513-1516", "Lorem ipsum dolores sit ...", peinture, vect2);
		Oeuvre pericles = new Oeuvre("P�ricl�s","-430","Hey on dirait ma photo ! ...",sg);
		Oeuvre poney = new Oeuvre("Poney aquatique","-921","Il fait des bulles !",sg,null);
		
		_listeOeuvres.add(joconde);
		_listeOeuvres.add(esclave);
		_listeOeuvres.add(pericles);
		_listeOeuvres.add(poney);
		
		_listeDeps.add(sg);
		_listeDeps.add(peinture);		
	}
	
	/**
	 * Recherche toutes les oeuvres dont le nom contient "nomOeuvre"
	 * Affiche la liste des r�sultats (appelle afficherRecherche)
	 * 
	 * \//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\
	 * La recherche ne respecte pas strictement le diagramme de s�quence
	 * car l'impl�mentation stricte du diagramme auait entrain� un code
	 * beaucoup plus complexe et difficile � maintenir
	 * \//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\
	 * 
	 * @param nomOeuvre : nom de l'oeuvre � rechercher
	 */
	public void rechercheParNom(String nomOeuvre)
	{		
		// stocke les r�sultats de la recherche
		Vector<Oeuvre> resultats = new Vector<Oeuvre>();
		int nbOeuvres = _listeOeuvres.size();
		nomOeuvre = nomOeuvre.toLowerCase();
		for(int i = 0; i < nbOeuvres; i++)
		{
			if(_listeOeuvres.get(i).recherche(nomOeuvre))
			{
				resultats.add(_listeOeuvres.get(i));
			}
		}
	
		afficherRecherche(resultats);
	}
	
	/**
	 * Recherche toutes les oeuvres dont l'auteur a pour nom "nomAuteur"
	 * et pour prenom "prenomAuteur"
	 * Affiche la liste des r�sultats (appelle afficherRecherche)
	 *
	 * \//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\
	 *  La recherche ne respecte pas strictement le diagramme de s�quence
	 * car l'impl�mentation stricte du diagramme auait entrain� un code
	 * beaucoup plus complexe et difficile � maintenir
	 * \//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\
	 * 
	 * @param nomAuteur : nom de l'auteur
	 * @param prenomAuteur : prenom de l'auteur
	 */
	public void rechercheParAuteur(String nomAuteur, String prenomAuteur)
	{
		// stocke les r�sultats de la recherche
		Vector<Oeuvre> resultats = new Vector<Oeuvre>();
		int nbAuteurs = _listeAuteurs.size();
		Auteur curAuteur;
		
		nomAuteur = nomAuteur.toLowerCase();
		prenomAuteur = prenomAuteur.toLowerCase();
		
		for(int i = 0; i < nbAuteurs; i++)
		{
			curAuteur = _listeAuteurs.get(i);
			
			if(	curAuteur.recherche(nomAuteur, prenomAuteur))
			{
				resultats.addAll(curAuteur.getListeOeuvres());
			}
		}
		
		afficherRecherche(resultats);
	}
	
	/**
	 * Recherche toutes les oeuvres associ�es � un d�partement
	 * Affiche la liste des r�sultats (appelle afficherRecherche)
	 * 
	 * \//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\
	 * La recherche ne respecte pas strictement le diagramme de s�quence
	 * car l'impl�mentation stricte du diagramme auait entrain� un code
	 * beaucoup plus complexe et difficile � maintenir
	 * \//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\\//!\\//!\\//!\\
	 * 
	 * @param departement
	 */
	public void rechercheParDepartement(String departement)
	{
		// stocke les r�sultats de la recherche
		Vector<Oeuvre> resultats = new Vector<Oeuvre>();
		int nbDep = _listeDeps.size();
		Departement curDep;
		
		for(int i = 0; i < nbDep; i++)
		{
			curDep = _listeDeps.get(i);
			if(curDep.recherche(departement))
			{
				resultats.addAll(curDep.getOeuvres());
			}
		}
		afficherRecherche(resultats);
	}

	
	
	/**
	 * Affiche la liste des r�sultats d'une recherche
	 * @param resultats : liste des oeuvres � afficher
	 */
	private void afficherRecherche(Vector<Oeuvre> resultats)
	{
		int i=0;
		Oeuvre curOeuvre;
		if(resultats.size() > 0)
		{
			for(i = 0; i < resultats.size(); i++){
				curOeuvre = resultats.get(i);
				
				System.out.println ("Index: "+_listeOeuvres.indexOf(curOeuvre)+" ;Oeuvre: "+curOeuvre.getNom());
				
			}
		}
		else
		{
			System.out.println(" Aucun r�sultat");
		}
	}
	
	
	/**
	 * Affiche la fiche d'une oeuvre dont l'index dans la liste d'oeuvre est id
	 * @param id : l'index de l'oeuvre dans la liste des oeuvres
	 */
	public void afficherFiche(int id){
		System.out.println(_listeOeuvres.get(id).construireFiche());
	}
	
	/**
	 * R�cup�re l'Oeuvre situ�e � l'index i
	 * 
	 * @param i : index de l'oeuvre � retourner
	 * @return null si i est "out of bound"
	 * 			l'oeuvre correspondante sinon
	 */
	public Oeuvre getOeuvreByIndex(int i){
		if(i >= 0 && i < _listeOeuvres.size()){
			return _listeOeuvres.get(i);
		}
		else{
			return null;
		}
	}
	
	public static void main(String[] arg)
	{
		//System.out.println("abcd".contains(""));
		Systeme sys = new Systeme();
		sys.rechercheParDepartement("Sculptures grecques");
		//sys.rechercheParAuteur("Leonard","De Vinci");
		//sys.rechercheParNom("");
		sys.afficherFiche(3);
		sys.afficherFiche(2);
	}
}