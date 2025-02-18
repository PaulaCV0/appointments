package Registration;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShelterForm extends Application {
    public static void main (String [] args) {launch(args);}

    public void start (Stage stage) {

//1. Text reason for shelter
        TextArea txtReason = new TextArea();
        Label lblReason = new Label("Please explain your situation: ");

        HBox reasonPane = new HBox(5);
        reasonPane.getChildren().add(lblReason);
        reasonPane.getChildren().add(txtReason);

//2. Combo  county
        ComboBox<String> county = new ComboBox<>();
        county.getItems().addAll("Álvaro Obregón",
                                            "Azcapotzalco",
                                            "Benito Juárez",
                                            "Coyoacán",
                                            "Cuajimalpa de Morelos",
                                            "Cuauhtémoc",
                                            "Gustavo A. Madero",
                                            "Iztacalco",
                                            "Iztapalapa",
                                            "Magdalena Contreras",
                                            "Miguel Hidalgo",
                                            "Milpa Alta",
                                            "Tláhuac",
                                            "Tlalpan",
                                            "Venustiano Carranza",
                                            "Xochimilco");

        HBox countyPane = new HBox(5);
        countyPane.getChildren().add(new Label("County located: "));
        countyPane.getChildren().add(county);

//3. Text time of stay
        RadioButton one = new RadioButton("1-3 weeks");
        RadioButton three = new RadioButton("3-6 weeks");
        RadioButton six = new RadioButton("6-9 weeks");
        RadioButton more = new RadioButton("10+ weeks");

        ToggleGroup time = new ToggleGroup();
        one.setToggleGroup(time);
        three.setToggleGroup(time);
        six.setToggleGroup(time);
        more.setToggleGroup(time);

        HBox timePane= new HBox(5);
        timePane.getChildren().add(new Label ("Approximate stay: "));
        timePane.getChildren().addAll(one, three, six, more);

//4. Combo people
        ComboBox<String> people = new ComboBox<>();
        people.getItems().addAll("1 person", "1 person + 1 baby", "2 people", "2 poeple + 1 baby", "More");

        HBox peoplePane = new HBox(5);
        peoplePane.getChildren().add(new Label("Shelter required for:"));
        peoplePane.getChildren().add(people);

//5. Check box extra needs
        CheckBox clothes = new CheckBox("Clothes");
        CheckBox medicine = new CheckBox("Medicine");
        CheckBox babyProducts = new CheckBox("Baby Products");
        CheckBox other = new CheckBox("Other");

        HBox needPane= new HBox(5);
        needPane.getChildren().add(new Label ("Extra needs: "));
        needPane.getChildren().add(clothes);
        needPane.getChildren().add(medicine);
        needPane.getChildren().add(babyProducts);
        needPane.getChildren().add(other);

//6. Redirect to:
        ComboBox<String> redirect = new ComboBox<>();
        redirect.getItems().addAll("Medical Review", "Counseling Session");

        HBox rePane = new HBox(5);
        rePane.getChildren().add(new Label("Continue with:"));
        rePane.getChildren().add(redirect);

//login button
        Button continueButton = new Button ("Continue");

//initial layout
        VBox layout = new VBox(10);
        layout.getChildren().add(new Label("\n"));
        layout.getChildren().add(reasonPane);
        layout.getChildren().add(countyPane);
        layout.getChildren().add(timePane);
        layout.getChildren().add(peoplePane);
        layout.getChildren().add(needPane);
        layout.getChildren().add(rePane);
        layout.getChildren().add(continueButton);

// create pop-up
        Scene scene = new Scene (layout, 700, 450);
        stage.setTitle("Shelter Appointment");
        stage.setScene(scene);
        stage.show();
    }
}
