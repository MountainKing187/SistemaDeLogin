package utils;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private final String directory;
    private final String text;

    public FileManager(String directory, String text){
        this.directory = directory;
        this.text = text;
    }

    public ArrayList<String> cargarLineas() {
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader("src/main/login.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return lineas;
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
