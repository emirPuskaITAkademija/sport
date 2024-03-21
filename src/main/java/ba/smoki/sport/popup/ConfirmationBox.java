package ba.smoki.sport.popup;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox {

    private final String title;
    private final String message;

    private boolean confirmed;

    public ConfirmationBox(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public void display(ActionEvent actionEvent){
        Stage stage = new Stage();

        stage.setTitle(title);
        //blokiraj sve druge prozore
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(350);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("YES");
        yesButton.setOnAction(e-> {
            confirmed = true;
            stage.close();
        });

        Button noButton = new Button("NO");
        noButton.setOnAction(e-> {
            confirmed = false;
            stage.close();
        });
        HBox yesNoBox = new HBox(10);
        yesNoBox.setStyle("""
                 -fx-border-style: solid;
                 -fx-border-color:black;
                """);
        yesNoBox.setAlignment(Pos.CENTER);
        yesNoBox.getChildren().addAll(yesButton, noButton);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(label, yesNoBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("""
                -fx-padding: 10;
                -fx-border-style: solid inside;
                -fx-border-width: 2;
                -fx-border-radius: 5;
                -fx-border-color: blue;
                """
        );
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
