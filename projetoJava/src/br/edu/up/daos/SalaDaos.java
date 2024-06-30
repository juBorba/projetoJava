package br.edu.up.daos;

import br.edu.up.modelos.Sala;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDaos {
    private final String filePath = "data/salas.csv";

    public void save(Sala sala) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(sala.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Sala> findAll() {
        List<Sala> salas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Sala sala = new Sala(fields[0], fields[1]);
                salas.add(sala);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salas;
    }
}