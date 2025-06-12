package utils;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private String directory;
    private String text = "";

    public FileManager(String directory){
        this.directory = directory;
        if(checkFile()){
            for(String lineas : cargarLineas()) {
                text = text +lineas+ "\n" ;
            }
            System.out.println(text);
        }
        else createFile();
    }

    public void setDirectory(String directory){
        this.directory = directory;
    }

    public String getDirectory(){
        return directory;
    }

    public String getText(){
        return text;
    }

    public ArrayList<String> cargarLineas() {
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader("src/main/"+directory))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return lineas;
    }

    public void añadirLinea(String linea){
        text = text + linea;
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/"+directory))){
            escritor.write(text);
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
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
