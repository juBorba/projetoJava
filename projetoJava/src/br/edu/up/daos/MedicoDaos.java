package br.edu.up.daos;

import br.edu.up.modelos.Medico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDaos {
    private final String filePath = "data/medicos.csv";

    public void save(Medico medico) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(medico.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Medico> findAll() {
        List<Medico> medicos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Medico medico = new Medico(fields[0], fields[1], fields[2]);
                medicos.add(medico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return medicos;
    }
}