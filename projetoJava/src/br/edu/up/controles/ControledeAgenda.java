package br.edu.up.controles;

import br.edu.up.daos.*;
import br.edu.up.modelos.*;

import java.util.List;

public class ControledeAgenda {
    private PacienteDaos pacienteDaos = new PacienteDaos();
    private MedicoDaos medicoDaos = new MedicoDaos();
    private ConsultaDaos consultaDaos = new ConsultaDaos();
    private SalaDaos salaDaos = new SalaDaos();

    public void adicionarPaciente(String codigo,String nome, String cpf) {
        Paciente paciente = new Paciente(codigo,nome, cpf);
        pacienteDaos.salvar(paciente);
    }

    public void adicionarMedico(String codigo, String nome, String crm, String especialidade) {
        Medico medico = new Medico(codigo, nome, crm, especialidade);
        medicoDaos.salvar(medico);
    }

    public void adicionarConsulta(String nome, String cpf, String medicoCrm, String data, String hora, String salaNumero) {
        // Verificando se o paciente, médico e sala já existem
        Paciente paciente = pacienteDaos.buscarCpf(cpf);
        if (paciente == null) {
            System.out.println("Paciente não cadastrado.");
            return;
        }
    
        Medico medico = medicoDaos.buscarCrm(medicoCrm);
        if (medico == null) {
            System.out.println("Médico não cadastrado.");
            return;
        }
    
        Sala sala = salaDaos.buscarNumero(salaNumero);
        if (sala == null) {
            System.out.println("Sala não cadastrada.");
            return;
        }
    
        // Verificar se já existe uma consulta marcada para o paciente na data e hora especificadas
        List<Consulta> consultasDoPaciente = consultaDaos.buscarPorPacienteEHorario(paciente.getCodigo(), data, hora);
        if (!consultasDoPaciente.isEmpty()) {
            System.out.println("Já existe uma consulta marcada para o paciente neste horário.");
            return;
        }
    
        // Criar e salvar a consulta
        Consulta consulta = new Consulta(paciente.getCodigo(), paciente.getNome(), paciente.getCpf(), medico.getCrm(), data, hora, sala.getNumero());
        consultaDaos.salvar(consulta);
    }
    

    public void adicionarSala(String codigo,String numero, String descricao) {
        Sala sala = new Sala(codigo, numero, descricao);
        salaDaos.salvar(sala);
    }

    public List<Paciente> listarPacientes() {
        return pacienteDaos.buscarTodos();
    }

    public List<Medico> listarMedicos() {
        return medicoDaos.buscarTodos();
    }

    public List<Consulta> listarConsultas() {
        return consultaDaos.buscarTodas();
    }

    public List<Sala> listarSalas() {
        return salaDaos.buscarTodos();
    }
}