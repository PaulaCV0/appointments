package Registration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    private File file;

    public Storage () {
        file = new File("records.txt");
        try {
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void save (String string) {
        try {
            FileWriter writer = new FileWriter (file, true);
            writer.write(string + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred. ");
            e.printStackTrace();
        }
    }

}
