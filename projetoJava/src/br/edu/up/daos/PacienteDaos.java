package br.edu.up.daos;

import br.edu.up.modelos.Paciente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaos {
    private final String filePath = "data/pacientes.csv";

    public void save(Paciente paciente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(paciente.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> findAll() {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Paciente paciente = new Paciente(fields[0], fields[1]);
                pacientes.add(paciente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
}