package com.company;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    GridPane pohi;
    Stage mainC;
    TextField bio = new TextField("Biomass");
    TextField protsent = new TextField("Paeva protsent");
    TextField fcr = new TextField("FCR");
    TextField paevuarv = new TextField("Paevade arv");
    TextField resultBio = new TextField("Biomassi tulemus");
    TextField resultKogus = new TextField("Soodakogus tulemus");
    Button ukspaev = new Button("Arvuta uhe paeva jaoks");
    Button mittupaeva = new Button("Arvuta mittu paeva jaoks");
    Button tuhista = new Button("Tuhista");


    @Override
    public void start(Stage primaryStage) throws Exception {
        seadistaPohi();
        seadistaField();
        seadistaNuppud();
        arvutamine();



    }

    private void arvutamine() {
        ukspaev.setOnAction((event) -> {
            double bioMassField = Double.parseDouble(bio.getText());
            double feedAmountField= Double.parseDouble(protsent.getText());
            double feedConversionRatioField = Double.parseDouble(fcr.getText());
            double daysField = Double.parseDouble(paevuarv.getText());
            double S = (bioMassField * feedAmountField / 100); //söödakogus sdelatj metodi dlja nih
            double K = S / feedConversionRatioField;
            double B = K + bioMassField; //uus biomass
            resultBio.setText(String.valueOf(B));
            resultKogus.setText(String.valueOf(S));
        });

        tuhista.setOnAction((event) -> {
            bio.setText(null);
            protsent.setText(null);
            fcr.setText(null);
            paevuarv.setText(null);
            resultBio.setText(null);
            resultKogus.setText(null);
        });

        mittupaeva.setOnAction((event) -> {
            uusaken();
        });

    }

    private void uusaken() {
        StackPane stack = new StackPane();
        Label go = new Label("UUS");
        stack.getChildren().add(go);
        Scene scene = new Scene(stack);
        Stage goStage = new Stage();
        goStage.setScene(scene);
        goStage.show();
    }

    private void seadistaNuppud() {
        pohi.add(ukspaev, 1, 6);
        pohi.add(mittupaeva, 2, 6);
        pohi.add(tuhista, 3, 6);

    }

    private void seadistaField() {
        pohi.add(bio, 1, 4);
        pohi.add(protsent, 2, 4);
        pohi.add(fcr, 3, 4);
        pohi.add(paevuarv, 4, 4);
        pohi.add(resultBio, 1, 8);
        resultBio.setEditable(false);
        pohi.add(resultKogus, 2, 8);
        resultKogus.setEditable(false);


    }

    private void seadistaPohi() {
        pohi = new GridPane();
        Scene scene = new Scene(pohi, 600, 300);
        mainC = new Stage();
        scene.setFill(Color.GRAY);
        mainC.setScene(scene);
        mainC.show();

    }

}
