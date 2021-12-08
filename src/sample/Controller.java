package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {

    @FXML
    private Button btnAdatokBetoltese;

    @FXML
    private void onBtnAdatokBetolteseClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Szöveges állomány megnyitása");
        FileChooser.ExtensionFilter extensionFilter =
                new FileChooser.ExtensionFilter("Szöveges állományok (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File fajl = fileChooser.showOpenDialog(null);
    }
}
