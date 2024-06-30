package br.edu.up.daos;

import br.edu.up.modelos.Consulta;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDaos {
    private final String filePath = "data/consultas.csv";

    public void salvar(Consulta consulta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(consulta.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta>  buscarTodas() {
        List<Consulta> consultas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Consulta consulta = new Consulta(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
                consultas.add(consulta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta.");
        }
    
        return consultas;
    }


    public List<Consulta> buscarPorPacienteEHorario(String codigoPaciente, String data, String hora) {
        List<Consulta> consultasDoPaciente = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 7 &&
                    fields[1].equals(codigoPaciente) &&
                    fields[4].equals(data) &&
                    fields[5].equals(hora)) {
                    Consulta consulta = new Consulta(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
                    consultasDoPaciente.add(consulta);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultasDoPaciente;
    }


}


