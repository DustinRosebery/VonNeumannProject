package characters;

import java.io.Serializable;

/**
 * Serializable character class to hold all dynamic data and save character state
 */
public class Character implements Serializable{

    // Basics
    private String name;
    private String origin;
    private String agenda;

    // External Classes
    private Research research;

    // Materials (Kg)
    private long carbon;
    private long iron;
    private long aluminum;
    private long nickel;
    private long cobalt;
    private long platinum;
    private long titanium;

    // Factors
    private long replicationFactor;
    private int tps;

    // Progress
    private int probes;
    private long coverage;
    private int speciesDiscovered;
    private int systemsVisited;

    // Combat
    private int hp;
    private long shields;

    // System
    private int ram;
    private long cpu;
    private int storage;


}
