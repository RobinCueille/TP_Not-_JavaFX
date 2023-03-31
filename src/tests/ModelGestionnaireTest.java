package tests;

import javafx.scene.paint.Color;
import model.Couleur;
import model.ModelGestionnaire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
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
        String filePath = getClass().getResource("test.txt").getPath();
        model = new ModelGestionnaire(filePath);
    }
     
    @Test
    public void testGetCouleurs() {
    	ArrayList<Couleur> couleurs = model.getCouleurs();
        assertEquals(new Couleur("Rouge",255, 0, 0), couleurs.get(0));
        assertEquals(new Couleur("Vert",0, 255, 0), couleurs.get(1));
        assertEquals(new Couleur("Bleu",0, 0, 255), couleurs.get(2));
    }
}