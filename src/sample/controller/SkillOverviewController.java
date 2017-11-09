package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import sample.Main;
import sample.model.Note;

public class SkillOverviewController {
    @FXML
    TreeView<String> treeView;
    @FXML
    TableView<Note> tableView;

    private Main main;


    public void setMainApp(Main main) {
        this.main = main;
    }
}
