package model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;

public class ModelGestionnaire {
    // Attributs
    private ArrayList<Couleur> couleurs;  // La collection de couleurs
    private int indiceCourant;            // L'indice de la couleur courante affichée
    private String nomFichierSauvegarde;  // Le nom du fichier de sauvegarde
    private SimpleObjectProperty<Color> couleurCouranteProperty;  // La couleur courante affichée dans l'interface
    private SimpleStringProperty labelIndiceProperty;  // Le label affichant l'indice de la couleur courante

    // Constructeur
    public ModelGestionnaire(String nomFichierSauvegarde) throws IOException, ClassNotFoundException {
        this.nomFichierSauvegarde = nomFichierSauvegarde;

        // Chargement des couleurs depuis le fichier de sauvegarde
        FileInputStream fis = new FileInputStream(nomFichierSauvegarde);
        ObjectInputStream ois = new ObjectInputStream(fis);
        couleurs = (ArrayList<Couleur>) ois.readObject();

        // Initialisation de l'indice courant et des propriétés JavaFX
        indiceCourant = 0;
        couleurCouranteProperty = new SimpleObjectProperty<>(couleurs.get(indiceCourant).toColor());
        labelIndiceProperty = new SimpleStringProperty((indiceCourant + 1) + "/" + couleurs.size());
        
        fis.close(); 
        ois.close(); 
    } 

    // Accesseurs
    public ArrayList<Couleur> getCouleurs() {
        return couleurs;
    }

    public int getIndiceCourant() {
        return indiceCourant;
    }

    public String getNomFichierSauvegarde() {
        return nomFichierSauvegarde;
    }

    public SimpleObjectProperty<Color> getCouleurCouranteProperty() {
        return couleurCouranteProperty;
    }

    public SimpleStringProperty getLabelIndiceProperty() {
        return labelIndiceProperty;
    }

    // Méthodes de navigation dans la collection
    public void couleurSuivante() {
        if (indiceCourant < couleurs.size() - 1) {
            indiceCourant++;
            couleurCouranteProperty.setValue(couleurs.get(indiceCourant).toColor());
            labelIndiceProperty.setValue((indiceCourant + 1) + "/" + couleurs.size());
        }
    }
 
    public void couleurPrecedente() {
        if (indiceCourant > 0) {
            indiceCourant--;
            couleurCouranteProperty.setValue(couleurs.get(indiceCourant).toColor());
            labelIndiceProperty.setValue((indiceCourant + 1) + "/" + couleurs.size());
        }
    }

    // Méthode de sauvegarde des couleurs dans un fichier
    public void sauvegarderCouleurs() throws IOException {
        FileOutputStream fos = new FileOutputStream(nomFichierSauvegarde);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(couleurs);
        oos.close();
    }
}