package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
    @FXML
    private Label lblKerulet;
    @FXML
    private Label lblTerulet;
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
        lstviewHibak.getItems().clear();
        lstviewDerekszoguHaromszogek.getItems().clear();

        try {
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);

            int i = 1;
            String sor = br.readLine();
            while (sor != null) {
                try {
                    DHaromszog dh = new DHaromszog(sor, i++);
                    lstviewDerekszoguHaromszogek.getItems().add(dh);
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

    @FXML
    private void onListViewClick(MouseEvent mouseEvent) {
        DHaromszog dh = lstviewDerekszoguHaromszogek.getSelectionModel().getSelectedItem();
        lblKerulet.setText(String.format("Kerület = %.2f,",dh.getKerulet()));
        lblTerulet.setText(String.format("Terület = %.2f,",dh.getTerulet()));

    }
}
