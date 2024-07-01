package br.edu.up.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.modelos.Consulta;

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

    public List<Consulta> buscarTodas() {
        List<Consulta> consultas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 7) {
                    Consulta consulta = new Consulta(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
                            fields[6]);
                    consultas.add(consulta);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta.");
        }

        return consultas;
    }

    public Consulta buscarPorPacienteEHorario(String cpf, String data, String hora) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 7 && fields[2].trim().equals(cpf.trim()) && fields[4].trim().equals(data.trim())
                        && fields[5].trim().equals(hora.trim())) {
                    return new Consulta(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Consulta buscarPorMedicoEHorario(String medicoCrm, String data, String hora) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 7 && fields[3].trim().equals(medicoCrm.trim())
                        && fields[4].trim().equals(data.trim()) && fields[5].trim().equals(hora.trim())) {
                    return new Consulta(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean excluirConsulta(String cpf, String data, String hora) {
        List<Consulta> consultas = buscarTodas();
        boolean consultaExcluida = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Consulta consulta : consultas) {
                if (!consulta.getCpf().equals(cpf.trim()) || !consulta.getData().equals(data.trim())
                        || !consulta.getHora().equals(hora.trim())) {
                    writer.write(consulta.toString());
                    writer.newLine();
                } else {
                    consultaExcluida = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultaExcluida;
    }

}
