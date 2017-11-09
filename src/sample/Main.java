package sample;

import com.alibaba.fastjson.JSON;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controller.AuthorizationFormController;
import sample.controller.SkillOverviewController;
import sample.model.Decomposition;
import sample.model.DecompositionBuilder;
import sample.model.Skill;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Skill> skillData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gui");

        initRootLayout();

        showAuthorizationForm();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAuthorizationForm() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AuthorizationForm.fxml"));
            GridPane authorizationForm = (GridPane) loader.load();

            rootLayout.setCenter(authorizationForm);

            AuthorizationFormController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSkillOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/SkillOverview.fxml"));
            AnchorPane skillOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(skillOverview);

            SkillOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public static void main(String[] args) {
        DecompositionBuilder decompositionBuilder = JSON.parseObject(
                "{'rootId': 0," +
                "'adjacencyList': [{'0': [{'childId': '1', 'childName': 'child1'}, {'childId': '2', 'childName': 'child2'}]}]," +
                "'skillName': 'cpp'}", DecompositionBuilder.class
        );

        Decomposition decomposition = decompositionBuilder.toDecomposition();



        launch(args);
    }
}
