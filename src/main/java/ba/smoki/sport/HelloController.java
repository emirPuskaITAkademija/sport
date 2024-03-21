package ba.smoki.sport;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeTextlabel;

    @FXML
    protected void onHelloButtonClick() {
        welcomeTextlabel.setText("Vozdra raja šta ima haa..");
    }
}