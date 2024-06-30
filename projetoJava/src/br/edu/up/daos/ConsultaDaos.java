package br.edu.up.daos;

import br.edu.up.modelos.Consulta;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDaos {
    private final String filePath = "data/consultas.csv";

    public void save(Consulta consulta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(consulta.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> findAll() {
        List<Consulta> consultas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Consulta consulta = new Consulta(fields[0], fields[1], fields[2], fields[3], fields[4]);
                consultas.add(consulta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}
