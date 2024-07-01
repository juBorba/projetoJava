package br.edu.up.controles;

import br.edu.up.daos.*;
import br.edu.up.modelos.*;

import java.util.List;

public class ControledeAgenda {
    private PacienteDaos pacienteDaos = new PacienteDaos();
    private MedicoDaos medicoDaos = new MedicoDaos();
    private ConsultaDaos consultaDaos = new ConsultaDaos();
    private SalaDaos salaDaos = new SalaDaos();


    //adicionar paciente
    public void adicionarPaciente(String codigo, String nome, String cpf) {
        Paciente paciente = new Paciente(codigo, nome, cpf);
        pacienteDaos.salvar(paciente);
    }
    // adicionar medico
    public void adicionarMedico(String codigo, String nome, String crm, String especialidade) {
        Medico medico = new Medico(codigo, nome, crm, especialidade);
        medicoDaos.salvar(medico);
    }
    // adicionar consulta e validações
    public void adicionarConsulta(String codigo, String cpf, String medicoCrm, String data, String hora, String salaNumero) {
        System.out.println("Buscando CPF: " + cpf);
        Paciente paciente = pacienteDaos.buscarCpf(cpf.trim());
        if (paciente == null) {
            System.out.println("Paciente não cadastrado.");
            return;
        } else {
            System.out.println("Paciente encontrado: " + paciente.getNome());
        }

        Medico medico = medicoDaos.buscarCrm(medicoCrm.trim());
        if (medico == null) {
            System.out.println("Médico não cadastrado.");
            return;
        }

        Sala sala = salaDaos.buscarNumero(salaNumero.trim());
        if (sala == null) {
            System.out.println("Sala não cadastrada.");
            return;
        }

        Consulta consultaExistente = consultaDaos.buscarPorPacienteEHorario(cpf.trim(), data.trim(), hora.trim());
        if (consultaExistente != null) {
            System.out.println("Já existe uma consulta agendada nesse horário.");
            return;
        }
    
        // Verifica se já existe uma consulta com o mesmo médico nesse horário
        Consulta consultaExistenteMedico = consultaDaos.buscarPorMedicoEHorario(medicoCrm.trim(), data.trim(), hora.trim());
        if (consultaExistenteMedico != null) {
            System.out.println("O médico já possui paciente neste horário.");
            return;
        }
    

        // Agendando a consulta
        Consulta consulta = new Consulta(codigo, paciente.getNome(), paciente.getCpf(), medico.getCrm(), data, hora, sala.getNumero());
        consultaDaos.salvar(consulta);
        System.out.println("Consulta agendada com sucesso!");
    }

    //adicionar sala
    public void adicionarSala(String codigo, String numero, String descricao) {
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

    //exclui consulta
    public void excluirConsulta(String cpf, String data, String hora) {
        boolean consultaExcluida = consultaDaos.excluirConsulta(cpf, data, hora);
        if (consultaExcluida) {
            System.out.println("Consulta excluída com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
    
}
