package mainMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

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

    /**
     * Gets country description from text file and returns the string
     *
     * @param country of origin
     * @return country description
     */
    public static String getCountryDescription(String country) {
        File file = new File("resources/descriptions/countryDescriptions/US_Description.txt");
        switch (country) {
            case "United States":
                file = new File("resources/descriptions/countryDescriptions/US_Description.txt");
                break;
            case "China":
                file = new File("resources/descriptions/countryDescriptions/China_Description.txt");
                break;
            case "Russia":
                file = new File("resources/descriptions/countryDescriptions/Russia_Description.txt");
                break;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String result = "";
            String temp;
            while ((temp = br.readLine()) != null) {
                result += temp;
                result += "\n";
            }
            System.out.println("Result:\n" + result);
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: file not found for Country: " + country);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR: input exception in country description");
            e.printStackTrace();
        }
        return null;
    }

    public static String getAgendaDescription(String agenda) {
        File file = new File("resources/descriptions/agendaDescriptions/Observation.txt");
        switch (agenda) {
            case "Observation":
                file = new File("resources/descriptions/agendaDescriptions/Observation.txt");
                break;
            case "Total Conversion":
                file = new File("resources/descriptions/agendaDescriptions/Conversion.txt");
                break;
            case "Galactic Domination":
                file = new File("resources/descriptions/agendaDescriptions/Domination.txt");
                break;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String result = "";
            String temp;
            while ((temp = br.readLine()) != null) {
                result += temp;
                result += "\n";
            }
            System.out.println("Result:\n" + result);
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: file not found for agenda: " + agenda);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR: input exception in agenda description");
            e.printStackTrace();
        }
        return null;
    }

    public void debugCharacter() {
        System.out.println("Character Debugging\n" +
        "Name:\t" + name + "\n" +
        "Origin:\t" + origin + "\n" +
        "Agenda:\t" + agenda + "\n");
    }
}
