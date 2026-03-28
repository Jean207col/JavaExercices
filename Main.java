package sn.Sane.l2gl.app.app;
import sn.Sane.l2gl.app.Vehicule;
import sn.Sane.l2gl.app.Chauffeur;
import sn.Sane.l2gl.interfaces.*;

public class Main {
    public static void main(String[] args) {
        
        Vehicule v = new Vehicule("DK-2026-X", "Renault", "Leger", "dispo");
        Chauffeur c = new Chauffeur("Robert", "Diop", "A+B", "disponible");

        SimpleCheck<Chauffeur> estDispo = (chauff) -> chauff.etat.equals("disponible");

        // On vérifie : Véhicule dispo ET Chauffeur dispo
        MissionCheck peutPartir = (vehic, chauff) -> 
            vehic.etat.equals("dispo") && estDispo.verifier(chauff);

        Transformer<Chauffeur, String> identite = (chauff) -> chauff.prenom + " " + chauff.nom;

        System.out.println("Conducteur : " + identite.transformer(c));
        
        if (peutPartir.verifier(v, c)) {
            System.out.println("Mission validée" + v.immatricule);
        } else {
            System.out.println("Véhicule, chauffeur indisponible.");
        }
    }
}
