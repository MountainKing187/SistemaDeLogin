package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final String directory;
    private final String text;

    public FileManager(String directory, String text){
        this.directory = directory;
        this.text = text;
    }

    public boolean checkFile(){
        File archivo = new File("src/main/"+directory);
        return archivo.exists();
    }

    public void deleteFile(){
        File archivo = new File("src/main/"+directory);
        archivo.delete();
    }

    public void createFile() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/"+directory))){
            escritor.write(text);
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
