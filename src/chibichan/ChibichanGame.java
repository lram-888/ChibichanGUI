package chibichan;

import java.io.*;

public class ChibichanGame {

    // This is the file where we save the pet
    private static final String SAVE_FILE = "chibichan.sav";

    // Save the pet object to a file
    public static void saveGame(Chibichan pet) {
        try {
            FileOutputStream fileOut = new FileOutputStream(SAVE_FILE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pet);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Could not save the game.");
        }
    }

    // Load the pet object from the file
    public static Chibichan loadGame() {
        try {
            FileInputStream fileIn = new FileInputStream(SAVE_FILE);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Chibichan loadedPet = (Chibichan) in.readObject();
            loadedPet.random = new java.util.Random(); // fix random not being saved
            in.close();
            fileIn.close();
            return loadedPet;
        } catch (IOException | ClassNotFoundException e) {
            return null; // file doesn't exist or can't read it
        }
    }
}
