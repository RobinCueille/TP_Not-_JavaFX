package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.ModelGestionnaire;
import model.Couleur; 

public class Controleur {
    @FXML
    private TextField nomField;
    @FXML
    private TextField rougeField;
    @FXML
    private TextField vertField;
    @FXML
    private TextField bleuField;
    @FXML
    private Button ajouterButton;
    @FXML
    private ListView<String> couleursListView;
    @FXML
    private Button supprimerButton;

    private ModelGestionnaire model;

    public void initialize() {
        try {
        	String filePath = getClass().getResource("tests.txt").getPath();
            model = new ModelGestionnaire(filePath);
            couleursListView.getItems().addAll(model.getCouleursNames());
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }

    @FXML
    public void ajouterCouleur() throws IOException {
        String nom = nomField.getText();
        int rouge = Integer.parseInt(rougeField.getText());
        int vert = Integer.parseInt(vertField.getText());
        int bleu = Integer.parseInt(bleuField.getText());
        Couleur couleur = new Couleur(nom, rouge, vert, bleu);
        model.sauvegarderCouleurs();
        couleursListView.getItems().add(couleur.getNom());
    }
}

