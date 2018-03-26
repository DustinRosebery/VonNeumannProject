package mainMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CharacterCreation {

    private static String[] countries = {"United States", "China", "Russia"};
    private static String[] agendas = {"Observation", "Galactic Domination", "Total Conversion"};

    private String name;
    private String origin;
    private String agenda;

    public CharacterCreation(String name, String origin, String agenda) {
        this.name = name;
        this.origin = origin;
        this.agenda = agenda;
    }

    /**
     *
     * @return an ObservableList of countries of origin
     */
    public static ObservableList<String> getCountries() {
        return FXCollections.observableArrayList(countries);
    }

    /**
     *
     * @return an ObservableList of agendas
     */
    public static ObservableList<String> getAgendas() {
        return FXCollections.observableArrayList(agendas);
    }

    public void debugCharacter() {
        System.out.println("Character Debugging\n" +
        "Name:\t" + name + "\n" +
        "Origin:\t" + origin + "\n" +
        "Agenda:\t" + agenda);
    }
}
