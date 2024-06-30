package br.edu.up.daos;

import br.edu.up.modelos.Paciente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaos {
    private final String filePath = "data/pacientes.csv";

    public void salvar(Paciente paciente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(paciente.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> buscarTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Paciente paciente = new Paciente(fields[0], fields[1], fields [2]);
                pacientes.add(paciente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
    //valida paciente cadastrado

    public Paciente buscarCpf(String cpf) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 2 && fields[2].equals(cpf)) { 
                    return new Paciente(fields[0], fields[1], fields[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // paciente nao encontrado
    }


}