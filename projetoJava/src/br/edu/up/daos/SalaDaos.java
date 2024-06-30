package br.edu.up.daos;

import br.edu.up.modelos.Sala;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDaos {
    private final String filePath = "data/salas.csv";

    public void salvar(Sala sala) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(sala.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Sala> buscarTodos() {
        List<Sala> salas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Sala sala = new Sala(fields[0], fields[1], fields[2]);
                salas.add(sala);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salas;
    }
    public Sala buscarNumero(String numero) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3 && fields[1].equals(numero)) {
                    return new Sala(fields[0], fields[1], fields[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
    
}