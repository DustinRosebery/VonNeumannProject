package mainMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable{

    // background
    @FXML private Label mainMenuLbl;
    @FXML private ImageView nebulaView;

    // background menu buttons
    @FXML private Button continueBtn;
    @FXML private Button loadBtn;

    // character creation panel
    @FXML private AnchorPane characterCreationAnchor;
    @FXML private Label characterCreationLbl;
    @FXML private TextField nameTextField;
    @FXML private ChoiceBox<String> originChoiceBox;
    @FXML private ChoiceBox<String> agendaChoiceBox;

    /**
     * Application Startup initialization
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nebulaView.setImage(new Image("nebula.png"));
        originChoiceBox.setItems(CharacterCreation.getCountries());
        originChoiceBox.getSelectionModel().selectFirst();
        agendaChoiceBox.setItems(CharacterCreation.getAgendas());
        agendaChoiceBox.getSelectionModel().selectFirst();
    }

    public MainMenuController(){}

    /**
     * On Click for Main Menu New Game Button
     *
     * @param event
     */
    @FXML
    private void onClickNewGameBtn(ActionEvent event) {
        characterCreationAnchor.setVisible(true);
        characterCreationLbl.setText("Create Your Probe");
        nameTextField.clear();
        mainMenuLbl.setVisible(false);
        continueBtn.setDisable(true);
        loadBtn.setDisable(true);
    }

    /**
     * On Click for Character Creation Create Button
     *
     * @param event
     */
    @FXML
    private void onClickCreateButton(ActionEvent event) {
        CharacterCreation newCharacter;
        if (nameTextField.getText().isEmpty()) {
            characterCreationLbl.setText("Enter a Name");
            return;
        }
        newCharacter = new CharacterCreation(
                nameTextField.getText(),
                originChoiceBox.getSelectionModel().getSelectedItem(),
                agendaChoiceBox.getSelectionModel().getSelectedItem());
        newCharacter.debugCharacter();
    }

    /**
     * On Click for Character Creation Cancel Button
     *
     * @param event
     */
    @FXML
    private void onClickCancelBtn(ActionEvent event) {
        characterCreationAnchor.setVisible(false);
        mainMenuLbl.setVisible(true);
        continueBtn.setDisable(false);
        loadBtn.setDisable(false);
    }
}
