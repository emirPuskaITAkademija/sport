package ba.smoki.sport;

import ba.smoki.sport.popup.AlertBox;
import ba.smoki.sport.popup.ConfirmationBox;
import ba.smoki.sport.popup.SportPopup;
import ba.smoki.sport.sport.Sport;
import ba.smoki.sport.sport.SportDao;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * <li>1. GUI controls</li>
 * <li>2. Container</li> JPanel   VBox, HBox
 * <li>3. LayoutManager</li> BoxLayout y, x
 */
public class HelloApplication extends Application {
    private final Button addSport = new Button("Add sport");
    private final TableView<Sport> sportTableView = new TableView<>();
    private ObservableList<Sport> sports;

    @Override
    public void start(Stage stage) {

        setUserAgentStylesheet(STYLESHEET_MODENA);

        stage.setTitle("Sport");

        VBox container = new VBox(20);
        this.sports = loadSports();
        SportPopup sportPopup = new SportPopup(sports::add);
        addSport.setOnAction(e -> sportPopup.display());

        TableColumn<Sport, String> nameColumn = new TableColumn<>("Sport Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Sport, String>("name"));

        TableColumn<Sport, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(300);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Sport, String>("description"));


        sportTableView.getColumns().addAll(nameColumn,descriptionColumn);
        sportTableView.setItems(sports);

        container.getChildren().addAll(addSport, sportTableView);

        container.setMinWidth(300);
        container.setMinHeight(250);
        container.setPadding(new Insets(20));
        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Sport> loadSports(){
        List<Sport> sports = new SportDao().findAll();
        return FXCollections.observableArrayList(sports);
    }


//    private void backToScene1(ActionEvent event) {
//        stage.setScene(scene1);
//    }
//
//    private class SwitchToScene2EventHandler implements EventHandler<ActionEvent> {
//        @Override
//        public void handle(ActionEvent event) {
//            stage.setScene(scene2);
//        }
//    }


    public static void main(String[] args) {
        launch();
//        Sport sport = new Sport();
//        sport.setName("ŠAH");
//        SportDao sportDao = new SportDao();
//        sportDao.save(sport);

        //Active Record
//        Sport sport = new Sport();
//        sport.setName("Ležanje");
//        sport.setDescription("Opis");
//        sport.save();
    }

    private class TextFieldInputEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            TextField textField = (TextField) event.getSource();
            System.out.println(textField.getText());
        }
    }

//     this.stage = stage;
//    /**
//     * Scene 1 BUILD
//     */
//    Label label1 = new Label("Welcome to the first scene:");
//    Button button1 = new Button("Go to scene 2");
//        button1.setOnAction(new SwitchToScene2EventHandler());
//
//    Button alertButton = new Button("Alert Button");
//    AlertBox alertBox = new AlertBox("Alert", "Dobili ste 1000 KM");
//        alertButton.setOnAction(alertBox::display);
//
//    Button showConfirmationButton = new Button("Show Confirmation");
//    ConfirmationBox confirmationBox = new ConfirmationBox("Confirm", "Potvrdi da si dobio 1000 KM");
//        showConfirmationButton.setOnAction(confirmationBox::display);
//
//    VBox layout1 = new VBox(20);
//    Button addSportButton = new Button("Add sport");
//    SportPopup sportPopup = new SportPopup();
//        addSportButton.setOnAction(e->sportPopup.display());
//        layout1.getChildren().addAll(label1, button1, alertButton, showConfirmationButton, addSportButton);
//
//    scene1 = new Scene(layout1, 200, 200);
//    /**
//     * Scene 2 BUILD
//     */
//    Button button2 = new Button("Back to scene 1");
//        button2.setOnAction(this::backToScene1);
//    StackPane layout2 = new StackPane();
//        layout2.getChildren().addAll(button2);
//    scene2 = new Scene(layout2, 600, 300);
//
//        stage.setScene(scene1);
//        stage.setTitle("Switch between scenes");
//        stage.show();

    /*********************************/

    //        TextField firstNameTextField = new TextField();
//        firstNameTextField.setOnAction(new TextFieldInputEvent());
//        TextField lastNameTextField = new TextField();
//        lastNameTextField.setOnAction(new TextFieldInputEvent());
//        Label firstNameLabel = new Label("_First Name:");
//        Label lastNameLabel = new Label("_Last Name:");
//        firstNameLabel.setLabelFor(firstNameTextField);
//        firstNameLabel.setMnemonicParsing(true);
//        lastNameLabel.setLabelFor(lastNameTextField);
//        lastNameLabel.setMnemonicParsing(true);
//
//        ChoiceBox<Sport> sportChoiceBox = new ChoiceBox<>();
//        List<Sport> sports = new SportDao().findAll();
//        sportChoiceBox.getItems().addAll(sports);
//        Label sportLabel = new Label("_Sport");
//        sportLabel.setMnemonicParsing(true);
//        sportLabel.setLabelFor(sportChoiceBox);
//
//        Label vegetarianLabel = new Label("Vegetarian");
//        CheckBox vegetarianCheckBox = new CheckBox("Vegetarian");
//
//        Label colorLabel = new Label("Color");
//        ColorPicker colorPicker = new ColorPicker();
//
//        Label yearLabel = new Label("Years");
//        TextField numberField = new TextField();
//        numberField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
//
//        GridPane rootPane = new GridPane();
//        rootPane.setStyle("""
//                -fx-padding: 10;
//                -fx-border-style: solid inside;
//                -fx-border-width: 2;
//                -fx-border-radius: 5;
//                -fx-border-color: blue;
//                """
//        );
//        rootPane.addRow(0, firstNameLabel, firstNameTextField);
//        rootPane.addRow(1, lastNameLabel, lastNameTextField);
//        rootPane.addRow(2, sportLabel, sportChoiceBox);
//        rootPane.addRow(3, vegetarianLabel, vegetarianCheckBox);
//        rootPane.addRow(4, colorLabel, colorPicker);
//        rootPane.addRow(5, yearLabel, numberField);
//        rootPane.setMinSize(350, 250);
//
//        Scene scene = new Scene(rootPane);
//        stage.setScene(scene);
//        stage.setTitle("Forma za unos");
//        stage.show();
}