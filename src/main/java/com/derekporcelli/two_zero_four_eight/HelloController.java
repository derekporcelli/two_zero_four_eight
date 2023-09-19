package com.derekporcelli.two_zero_four_eight;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController
    {
        @FXML
        private Label welcomeText;
        
        @FXML
        protected void onHelloButtonClick ()
            {
                welcomeText.setText("Welcome to JavaFX Application!");
            }
    }