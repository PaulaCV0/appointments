package Registration;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationForm extends Application {
    public static void main (String [] args) {launch(args);}

    public void start (Stage stage) {
        Label lblWelcome = new Label("Registration Form");

// text fields - name + surname
        TextField txtName = new TextField();
        Label lblName = new Label("Name: ");
        TextField txtSur = new TextField();
        Label lblSur = new Label("Surname: ");

        HBox namePane = new HBox(5);
        namePane.getChildren().add(lblName);
        namePane.getChildren().add(txtName);

        HBox surPane = new HBox(5);
        surPane.getChildren().add(lblSur);
        surPane.getChildren().add(txtSur);

//check box - day availability
        CheckBox monday = new CheckBox("Monday");
        CheckBox tuesday = new CheckBox("Tuesday");
        CheckBox wednesday = new CheckBox("Wednesday");
        CheckBox thursday = new CheckBox("Thursday");
        CheckBox friday = new CheckBox("Friday");

        HBox dayPane= new HBox(5);
        dayPane.getChildren().add(new Label ("Availability: "));
        dayPane.getChildren().add(monday);
        dayPane.getChildren().add(tuesday);
        dayPane.getChildren().add(wednesday);
        dayPane.getChildren().add(thursday);
        dayPane.getChildren().add(friday);

//radio button - pregnancy status
        RadioButton not = new RadioButton("Not pregnant");
        RadioButton yes = new RadioButton("Pregnant");

        ToggleGroup preg = new ToggleGroup();
        not.setToggleGroup(preg);
        yes.setToggleGroup(preg);

        HBox pregPane= new HBox(5);
        pregPane.getChildren().add(new Label("Status: "));
        pregPane.getChildren().addAll(not, yes);

//combo button - type of help required
        ComboBox<String> help = new ComboBox<>();
        help.getItems().addAll("Counseling", "Medical", "Shelter");

        HBox helpPane = new HBox(5);
        helpPane.getChildren().add(new Label("Type of help:"));
        helpPane.getChildren().add(help);


//login button
        Button loginButton = new Button ("Login");

// layout initial
        VBox layout = new VBox(10);
        layout.getChildren().add(lblWelcome);
        layout.getChildren().add(namePane);
        layout.getChildren().add(surPane);
        layout.getChildren().add(pregPane);
        layout.getChildren().add(dayPane);
        layout.getChildren().add(helpPane);
        layout.getChildren().add(loginButton);

// create pop-up
        Scene scene = new Scene (layout, 600, 250);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

//when button is selected...
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//objects + what to print
                String name = txtName.getText();
                String surname = txtSur.getText();

                String available = "Availability: ";
                if (monday.isSelected()) available += "Monday ";
                if (tuesday.isSelected()) available += "Tuesday ";
                if (wednesday.isSelected()) available += "Wednesday ";
                if (thursday.isSelected()) available += "Thursday ";
                if (friday.isSelected()) available += "Friday ";

                RadioButton selectedPreg = (RadioButton) preg.getSelectedToggle();
                String pregnantStatus = selectedPreg != null ? selectedPreg.getText() : "Not specified";

                String helpType = help.getValue() != null ? help.getValue() : "No help selected";

//print objects selected
                System.out.println("Name of user: " + name + " " + surname);
                System.out.println("Pregnancy status: " + pregnantStatus);
                System.out.println(available);
                System.out.println("Help type requested: " + helpType);

//Storage Class connection --> saves information user inputs and prints into "records.txt"
                Storage storage = new Storage();
                storage.save ("\nUser: " + name + " " + surname + "\nStatus:  " + pregnantStatus + "\nHelp type: " + helpType + "\n" + available );

//StorageDB
                StorageDB database = new StorageDB();
                boolean pregnant = pregnantStatus.equals ("Pregnant")? true: false;
                User user = new User(name, surname, pregnant,  helpType);

                database.save(user);

 //validation of items
                if (name.isEmpty() || surname.isEmpty()){
                }
            }
        });
    }
}

