package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller {

    @FXML
    private ListView<String> lstviewHibak;
    @FXML
    private ListView<DHaromszog> lstviewDerekszoguHaromszogek;
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
        fajlBeolvas(fajl.toString());
    }

    private void fajlBeolvas(String fajl) {
        try {
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);

            int i = 1;
            String sor = br.readLine();
            while (sor != null) {
                try {
                    DHaromszog dh = new DHaromszog(sor, i++);
                } catch (Exception e) {
                    lstviewHibak.getItems().add(e.getMessage());
                } finally {
                    sor = br.readLine();
                }
            }
            br.close();
            fr.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
}
