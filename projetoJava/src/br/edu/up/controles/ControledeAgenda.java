package br.edu.up.controles;

import br.edu.up.daos.*;
import br.edu.up.modelos.*;

import java.util.List;

public class ControledeAgenda {
    private PacienteDaos pacienteDaos = new PacienteDaos();
    private MedicoDaos medicoDaos = new MedicoDaos();
    private ConsultaDaos consultaDaos = new ConsultaDaos();
    private SalaDaos salaDaos = new SalaDaos();

    public void adicionarPaciente(String nome, String cpf) {
        Paciente paciente = new Paciente(nome, cpf);
        pacienteDaos.save(paciente);
    }

    public void adicionarMedico(String nome, String crm, String especialidade) {
        Medico medico = new Medico(nome, crm, especialidade);
        medicoDaos.save(medico);
    }

    public void adicionarConsulta(String nome, String cpf, String medicoCrm, String data, String sala) {
        Consulta consulta = new Consulta(nome, cpf, medicoCrm, data, sala);
        consultaDaos.save(consulta);
    }

    public void adicionarSala(String numero, String descricao) {
        Sala sala = new Sala(numero, descricao);
        salaDaos.save(sala);
    }

    public List<Paciente> listarPacientes() {
        return pacienteDaos.findAll();
    }

    public List<Medico> listarMedicos() {
        return medicoDaos.findAll();
    }

    public List<Consulta> listarConsultas() {
        return consultaDaos.findAll();
    }

    public List<Sala> listarSalas() {
        return salaDaos.findAll();
    }
}