package tests;

import model.Couleur;
import model.ModelGestionnaire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelGestionnaireTest {

	private ModelGestionnaire model;
    
    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        ArrayList<Couleur> couleurs = new ArrayList<>();
        couleurs.add(new Couleur("Rouge",255, 0, 0));
        couleurs.add(new Couleur("Vert",0, 255, 0));
        couleurs.add(new Couleur("Bleu",0, 0, 255));
        String filePath = getClass().getResource("tests.txt").getPath();
        model = new ModelGestionnaire(filePath);
    }
     
    @Test
    public void testGetCouleurs() {
    	ArrayList<Couleur> couleurs = model.getCouleurs();
        assertEquals(new Couleur("Rouge",255, 0, 0), couleurs.get(0));
        assertEquals(new Couleur("Vert",0, 255, 0), couleurs.get(1));
        assertEquals(new Couleur("Bleu",0, 0, 255), couleurs.get(2));
    }
    @Test
    public void testGetIndiceCourant() {
        assertEquals(0, model.getIndiceCourant());
    }

    @Test
    public void testGetNomFichierSauvegarde() {
        assertEquals("test_couleurs.ser", model.getNomFichierSauvegarde());
    }

    @Test
    public void testGetCouleurCouranteProperty() {
        assertNotNull(model.getCouleurCouranteProperty());
    }

    @Test
    public void testGetLabelIndiceProperty() {
        assertNotNull(model.getLabelIndiceProperty());
        assertEquals("1/3", model.getLabelIndiceProperty().getValue());
    }

    @Test
    public void testCouleurSuivante() {
        model.couleurSuivante();
        assertEquals(1, model.getIndiceCourant());
        assertEquals(new Couleur("",0, 255, 0), model.getCouleurCouranteProperty().getValue());
        assertEquals("2/3", model.getLabelIndiceProperty().getValue());
    }

    @Test
    public void testCouleurPrecedente() {
        model.couleurSuivante();
        model.couleurPrecedente();
        assertEquals(0, model.getIndiceCourant());
        assertEquals(new Couleur("",255, 0, 0), model.getCouleurCouranteProperty().getValue());
        assertEquals("1/3", model.getLabelIndiceProperty().getValue());
    }
}