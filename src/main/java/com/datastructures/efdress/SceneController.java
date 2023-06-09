package com.datastructures.efdress;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void ToSelect(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Select.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();


        ComboBox addItemC2 = new ComboBox();

        Scene newItScene2= new Scene(new Group(), 500, 400);
        Button prevSceneB= new Button("Go back");

        GridPane grid2 = new GridPane();
        grid2.setVgap(4);
        grid2.setHgap(10);
        grid2.setPadding(new Insets(5, 5, 5, 5));
        grid2.add(new Label("What kind of item is it?"), 0, 0);
        grid2.add(addItemC2, 1, 0);
        grid2.add(prevSceneB, 1, 1);
        Group root2 = (Group)newItScene2.getRoot();
        root2.getChildren().add(grid2);


        // Scene new Item (Body part)

        final ComboBox addItemC1 = new ComboBox();
        addItemC1.getItems().addAll(
                "Upper Body (Tops, coats/jackets, etc.)",
                "Lower Body (Trousers, skirts, etc.)",
                "Upper & lower body (dress, jumpsuit, etc.)",
                "Footwear",
                "Headwear",
                "Accesory"
        );
        addItemC1.setOnAction((event) -> {
            addItemC2.getItems().clear();
            int selectedIndex1 = addItemC1.getSelectionModel().getSelectedIndex();
            Object selectedItem = addItemC1.getSelectionModel().getSelectedItem();
            System.out.println("Selection made: [" + selectedIndex1 + "] " + selectedItem);
            System.out.println("   ComboBox.getValue(): " + addItemC1.getValue());
            switch (selectedIndex1){
                case 0:
                    addItemC2.getItems().addAll(
                            "Coat",
                            "Jacket",
                            "Vest",
                            "Shirt",
                            "T-shirt",
                            "Other type of top"
                    );
                    break;

                case 1:
                    addItemC2.getItems().addAll(
                            "Trouser",
                            "Skirt",
                            "Short",
                            "Jeans",
                            "Other type of pants"
                    );
                    break;


                case 2:
                    addItemC2.getItems().addAll(
                            "Dress",
                            "Overall",
                            "Swimsuit",
                            "Jumpsuit"
                    );
                    break;

                case 3:
                    addItemC2.getItems().addAll(
                            "Boots",
                            "Sneakers",
                            "Sandals",
                            "Other dress Shoes"
                    );
                    break;
                case 4:
                    addItemC2.getItems().addAll(
                            "Caps",
                            "Beanies",
                            "Other hats"
                    );
                    break;
            }




            stage.setScene(newItScene2);
        });

        Scene newItScene1= new Scene(new Group(), 500, 400);

        EventHandler<ActionEvent> gobackEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                addItemC2.getItems().clear();
                stage.setScene(newItScene2);

            }
        };

        // when button is pressed
        prevSceneB.setOnAction(gobackEvent);
        prevSceneB.setOnAction(event -> stage.setScene(newItScene1));
        GridPane grid1 = new GridPane();
        grid1.setVgap(4);
        grid1.setHgap(10);
        grid1.setPadding(new Insets(5, 5, 5, 5));
        grid1.add(new Label("What kind of item is it?"), 0, 0);
        grid1.add(addItemC1, 1, 0);
        Group root1 = (Group)newItScene1.getRoot();
        root1.getChildren().add(grid1);

        //Main Scene
        //Label label2= new Label("This is the second scene");
        Button addItemb= new Button("Add Item");
        addItemb.setOnAction(e -> stage.setScene(newItScene1));
        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(addItemb);
        Scene mainScene= new Scene(layout2,500,400);




        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")); //Done here
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);//Done here
        */
        stage.setTitle("Hello!");

        scene = new Scene(root);
        stage.setScene(mainScene);
        stage.show();
    }


}
