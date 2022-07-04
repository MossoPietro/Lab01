package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtPerformance;

    @FXML
    void doInsert(ActionEvent event) {
    	String parola;
    	parola = txtParola.getText();
        double inizio;
        double fine;
        inizio = System.nanoTime();
    	elenco.addParola(parola);
    	fine = System.nanoTime();
    	txtParola.clear();
    	txtResult.clear();
    	txtPerformance.clear();
    	String risultato = "";
		for (String s : elenco.getElenco())
			risultato += s + "\n";
    	txtResult.setText(risultato);
    	txtPerformance.setText("Tempo impiegato: " + (fine-inizio)/10e9 + " secondi");
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtPerformance.clear();
    	double inizio;
        double fine;
        inizio = System.nanoTime();
    	elenco.reset();
    	fine = System.nanoTime();
    	txtResult.clear();
    	txtPerformance.setText("Tempo impiegato: " + (fine-inizio)/10e9 + " secondi");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	String parola;
    	parola = txtResult.getSelectedText();
    	double inizio;
        double fine;
        inizio = System.nanoTime();
    	elenco.removeParola(parola);
    	fine = System.nanoTime();
    	txtParola.clear();
    	txtResult.clear();
    	txtPerformance.clear();
    	String risultato = "";
		for (String s : elenco.getElenco())
			risultato += s + "\n";
    	txtResult.setText(risultato);
    	txtPerformance.setText("Tempo impiegato: " + (fine-inizio)/10e9 + " secondi");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPerformance != null : "fx:id=\"txtPerformance\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }
}
