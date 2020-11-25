package uet.oop.bomberman.start;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import uet.oop.bomberman.BombermanGame;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private BombermanGame playScene = new BombermanGame();

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    //start + replay
    public void changeScene(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        playScene.start(stage);
    }
}
