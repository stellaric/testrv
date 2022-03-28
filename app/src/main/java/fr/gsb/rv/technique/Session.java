package fr.gsb.rv.technique;

import fr.gsb.rv.entites.Visiteur;

public class Session {

    private static Session session = null ;
    private Visiteur leVisiteur ;

    private Session(Visiteur leVisiteur) {
        super();
        this.leVisiteur = leVisiteur;
    }

    public static void ouvrir(Visiteur leVisiteur){
        session = new Session(leVisiteur);
    }

    public static void fermer(){
        session = null ;
    }

    public static Session getSession(){
        return session ;
    }

    public Visiteur getLeVisiteur(){
        return leVisiteur ;
    }


}
