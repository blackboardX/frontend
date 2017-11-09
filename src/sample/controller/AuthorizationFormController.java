package sample.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;

public class AuthorizationFormController {
    @FXML
    TextField loginTextField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button signInButton;
    @FXML
    Button signUpButton;

    private Main main;

    public void handleSignUp() {
        String login = loginTextField.getText();
        String password = passwordField.getText();

        try {
            HttpResponse<JsonNode> response = Unirest.get("http://127.0.0.1:5000/signup")
                    .queryString("email", login)
                    .queryString("password", password)
                    .asJson();

            if (response.getStatus() == 200) {
                System.out.println("Hello, world!");

                main.showSkillOverview();
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void handleSignIn() {
        String login = loginTextField.getText();
        String password = passwordField.getText();

        try {
            HttpResponse<JsonNode> response = Unirest.get("http://127.0.0.1:5000/signin")
                    .queryString("email", login)
                    .queryString("password", password)
                    .asJson();

            if (response.getStatus() == 200) {
                System.out.println("Hello, world!");

                main.showSkillOverview();
            } else {
                System.out.println("ERRORCHIK");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

//        try {
//            if (request.asJson().getHeaders().get == "200") {
//                System.out.println("Hello, world!");
//            }
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
