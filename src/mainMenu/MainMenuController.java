package mainMenu;

import characters.Character;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
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

    // character creation description
    @FXML private Label countryDescriptionLbl;
    @FXML private AnchorPane countryDescriptionAnchor;
    @FXML private Label agendaDescriptionLbl;
    @FXML private AnchorPane agendaDescriptionAnchor;

    /**
     * Application Startup initialization
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nebulaView.setImage(new Image("images/nebula.png"));
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
        // Character Creation Pane
        characterCreationAnchor.setVisible(true);
        characterCreationLbl.setText("Create Your Probe");
        nameTextField.clear();
        // Main Menu Modifications
        mainMenuLbl.setVisible(false);
        continueBtn.setDisable(true);
        loadBtn.setDisable(true);
        // Descriptions
        String country = originChoiceBox.getSelectionModel().getSelectedItem();
        countryDescriptionLbl.setText(CharacterCreation.getCountryDescription(country));
        countryDescriptionAnchor.setVisible(true);
        String agenda = agendaChoiceBox.getSelectionModel().getSelectedItem();
        agendaDescriptionLbl.setText(CharacterCreation.getAgendaDescription(agenda));
        agendaDescriptionAnchor.setVisible(true);


        System.out.println("Clicked New Game");
    }

    @FXML
    private void onStateChangeCountryDescription(Event event) {
        String country = originChoiceBox.getSelectionModel().getSelectedItem();
        countryDescriptionLbl.setText(CharacterCreation.getCountryDescription(country));
    }

    @FXML
    private void onStateChangeAgendaDescription(Event event) {
        String agenda = agendaChoiceBox.getSelectionModel().getSelectedItem();
        agendaDescriptionLbl.setText(CharacterCreation.getAgendaDescription(agenda));
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
        System.out.println("Clicked Create Character");
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
        countryDescriptionAnchor.setVisible(false);
        agendaDescriptionAnchor.setVisible(false);
        System.out.println("Clicked Cancel Button");
    }

    @FXML
    private void onClickContinueButton(ActionEvent event) {
        mainMenuLbl.setVisible(false);

    }
}
