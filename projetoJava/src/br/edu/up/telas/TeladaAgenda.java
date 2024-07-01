package br.edu.up.telas;

import br.edu.up.controles.ControledeAgenda;
import br.edu.up.modelos.*;

import java.util.Scanner;
import java.util.List;

public class   TeladaAgenda {
    private ControledeAgenda controle = new ControledeAgenda();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcao = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Medico");
            System.out.println("3. Adicionar Consulta");
            System.out.println("4. Adicionar Sala");
            System.out.println("5. Listar Pacientes");
            System.out.println("6. Listar Medicos");
            System.out.println("7. Listar Consultas");
            System.out.println("8. Listar Salas");
            System.out.println("9. Excluir Consulta");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarPaciente();
                    break;
                case 2:
                    adicionarMedico();
                    break;
                case 3:
                    adicionarConsulta();
                    break;
                case 4:
                    adicionarSala();
                    break;
                case 5:
                    listarPacientes();
                    break;
                case 6:
                    listarMedicos();
                    break;
                case 7:
                    listarConsultas();
                    break;
                case 8:
                    listarSalas();
                    break;
                    case 9:
                    excluirConsulta();
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 9);
    }

    private void adicionarPaciente() {
        System.out.print("Codigo do Paciente: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome do Paciente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Paciente: ");
        String cpf = scanner.nextLine();
        controle.adicionarPaciente(codigo,nome, cpf);
    }

    private void adicionarMedico() {
        System.out.print("Código do médico: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome do Medico: ");
        String nome = scanner.nextLine();
        System.out.print("CRM do Medico: ");
        String crm = scanner.nextLine();
        System.out.print("Especialidade do Medico: ");
        String especialidade = scanner.nextLine();
        controle.adicionarMedico(codigo, nome, crm, especialidade);
    }

    private void adicionarConsulta() {
        System.out.print("Código do Paciente: ");
        String codigo = scanner.nextLine();
        System.out.print("CPF do Paciente: ");
        String cpf = scanner.nextLine();
        System.out.print("CRM do Medico: ");
        String medicoCrm = scanner.nextLine();
        System.out.print("Data da Consulta (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        System.out.print("Hora da Consulta (hh:mm): ");
        String hora = scanner.nextLine();
        System.out.print("Sala da Consulta: ");
        String sala = scanner.nextLine();
        controle.adicionarConsulta(codigo, cpf, medicoCrm, data, hora, sala);
    }

    private void adicionarSala() {
        System.out.print("Codigo da Sala: ");
        String codigo = scanner.nextLine();
        System.out.print("Numero da Sala: ");
        String numero = scanner.nextLine();
        System.out.print("Descricao da Sala: ");
        String descricao = scanner.nextLine();
        controle.adicionarSala(codigo,numero, descricao);
    }

    private void listarPacientes() {
        List<Paciente> pacientes = controle.listarPacientes();
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    private void listarMedicos() {
        List<Medico> medicos = controle.listarMedicos();
        for (Medico medico : medicos) {
            System.out.println(medico);
        }
    }

    private void listarConsultas() {
        List<Consulta> consultas = controle.listarConsultas();
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }

    private void listarSalas() {
        List<Sala> salas = controle.listarSalas();
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }
    private void excluirConsulta() {
        System.out.print("CPF do Paciente da Consulta que deseja excluir: ");
        String cpf = scanner.nextLine();
        System.out.print("Data da Consulta (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        System.out.print("Hora da Consulta (hh:mm): ");
        String hora = scanner.nextLine();
        controle.excluirConsulta(cpf, data, hora);
    }
    
    
}