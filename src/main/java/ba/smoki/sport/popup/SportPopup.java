package ba.smoki.sport.popup;

import ba.smoki.sport.sport.Sport;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class SportPopup {
    Logger LOGGER = Logger.getLogger(SportPopup.class.getName());
    private final Stage stage = new Stage();
    private final TextField sportNameField = new TextField();
    private final TextArea sportDescriptionArea = new TextArea();
    private Consumer<Sport> consumer;
    public SportPopup(){
        this(sport ->{});
    }

    public SportPopup(Consumer<Sport> consumer){
        this.consumer = consumer;
    }

    public void display() {

        stage.setTitle("Sport");
        stage.initModality(Modality.APPLICATION_MODAL);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label sportNameLabel = new Label("Sport name");
        GridPane.setConstraints(sportNameLabel, 0, 0);
        GridPane.setConstraints(sportNameField, 1, 0);

        Label sportDescriptionLabel = new Label("Description");
        GridPane.setConstraints(sportDescriptionLabel, 0, 1);
        GridPane.setConstraints(sportDescriptionArea, 1, 1);

        HBox actionBox = new HBox(10);
        Button saveButton = new Button("Save");
        saveButton.setOnAction(this::onSaveButtonClick);
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> stage.close());
        actionBox.getChildren().addAll(saveButton, cancelButton);
        GridPane.setConstraints(actionBox, 1, 3);

        gridPane
                .getChildren()
                .addAll(sportNameLabel,
                        sportNameField,
                        sportDescriptionLabel,
                        sportDescriptionArea,
                        actionBox);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private void onSaveButtonClick(ActionEvent actionEvent) {
        boolean validated = validate();
        try {
            if (validated) {
                Sport sport = new Sport();
                sport.setName(sportNameField.getText());
                sport.setDescription(sportDescriptionArea.getText());
                sport.save();
                consumer.accept(sport);
            }
            stage.close();
            new AlertBox("Success", "Uspješno dodan novi sport").display(actionEvent);

        } catch (SQLException exception) {
            LOGGER.info(exception.getMessage());
            new AlertBox("Error", "Već postoji istoimeni sport").display(actionEvent);
        }
    }

    private boolean validate() {
        if (sportNameField.getText().isBlank()) {
            new AlertBox("Validation", "Name je obavezno");
            return false;
        }
        return true;
    }
}
