package Main;

import java.util.List;
import java.util.Scanner;

import Main.usuario.*;
import Main.servico.*;
import Main.agendamento.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Bem-vindo ao Sistema ===");
            System.out.println("1. Cadastro");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                Usuario.registrarUsuario();
            } else if (opcao == 2) {
                Usuario usuario = Usuario.login();
                if (usuario != null) {
                    if (usuario instanceof Administrador) {
                        menuAdministrador((Administrador) usuario);
                    } else if (usuario instanceof Profissional) {
                        menuProfissional((Profissional) usuario);
                    } else {
                        menuCliente(usuario);
                    }
                }
            } else if (opcao == 3) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void menuAdministrador(Administrador administrador) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("1. Cadastrar Serviço");
            System.out.println("2. Editar Serviço");
            System.out.println("3. Excluir Serviço");
            System.out.println("4. Listar Serviços");
            System.out.println("5. Atribuir Profissional a Servico");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                Servico.cadastrarServico();
            } else if (opcao == 2) {
                Servico.getServicosCadastrados().forEach(servico -> System.out.println(servico.getId() + ". " + servico.getNome()));
                System.out.print("Digite o ID do serviço para editar: ");
                int id = scanner.nextInt();
                for (Servico servico : Servico.getServicosCadastrados()) {
                    if (servico.getId() == id) {
                        servico.editarServico();
                        break;
                    }
                }
            } else if (opcao == 3) {
                Servico.excluirServico();
            } else if (opcao == 4) {
                Servico.listarServicos();
            } else if(opcao == 5){
                administrador.atribuirProfissionalAoServico();
            }else if (opcao == 6) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuProfissional(Profissional profissional) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Profissional ===");
            System.out.println("1. Editar Perfil");
            System.out.println("2. Visualizar Perfil");
            System.out.println("3. Adicionar Horário");
            System.out.println("4. Remover Horário");
            System.out.println("5. Listar Horários");
            System.out.println("6. Agendar Serviço");
            System.out.println("7. Cancelar Serviço");
            System.out.println("8. Listar Agendamentos");
            System.out.println("9. Relatorio de Agendamentos");
            System.out.println("10. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                profissional.editarPerfil();
            } else if (opcao == 2) {
                System.out.println(profissional.visualizarPerfil());
            }else if (opcao == 3) {
                scanner.nextLine();
                System.out.print("Digite o horário a ser adicionado: ");
                String horario = scanner.nextLine();
                profissional.adicionarHorario(horario);
            } else if (opcao == 4) {
                scanner.nextLine();
                System.out.print("Digite o horário a ser removido: ");
                String horario = scanner.nextLine();
                profissional.removerHorario(horario);
            } else if (opcao == 5) {
                profissional.listarHorarios();
            } else if (opcao == 6) {
                System.out.println("=== Serviços Disponíveis ===");
                List<Servico> servicos = Servico.getServicosCadastrados();
                for (int i = 0; i < servicos.size(); i++) {
                    System.out.println((i + 1) + ". " + servicos.get(i).getNome());
                }
                System.out.print("Escolha um serviço pelo número: ");
                int servicoIndex = scanner.nextInt() - 1;

                if (servicoIndex < 0 || servicoIndex >= servicos.size()) {
                    System.out.println("Serviço inválido!");
                } else {
                    Servico servicoEscolhido = servicos.get(servicoIndex);
                    Agendamento.agendarServico(profissional, servicoEscolhido);
                    
                }
                
            } else if (opcao == 7) {
                Agendamento.listarAgendamentos();
                scanner.nextLine();
                System.out.print("Digite o número do agendamento para cancelar: ");
                int numAgendamento = scanner.nextInt();
                for (Agendamento agendamento : Agendamento.agendamentos) {
                    if (agendamento.getNumeroAgendamento() == numAgendamento) {
                        System.out.println(agendamento.cancelarAgendamento());
                        break;
                    }
                }
            } else if (opcao == 8) {
                Agendamento.listarAgendamentos();
            } else if (opcao == 9) {
                Relatorio.visualizarRelatorio();
            } else if (opcao == 10) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuCliente(Usuario cliente) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1. Editar Perfil");
            System.out.println("2. Visualizar Perfil");
            System.out.println("3. Agendar Serviço");
            System.out.println("4. Cancelar Serviço");
            System.out.println("5. Listar Agendamentos");
            System.out.println("6. Cadastrar-se como Profissional");
            System.out.println("7. Relatorio de agendamentos");
            System.out.println("8. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                cliente.editarPerfil();
            } else if (opcao == 2) {
                System.out.println(cliente.visualizarPerfil());
            } else if (opcao == 3) {
                System.out.println("=== Serviços Disponíveis ===");
                List<Servico> servicos = Servico.getServicosCadastrados();
                for (int i = 0; i < servicos.size(); i++) {
                    System.out.println((i + 1) + ". " + servicos.get(i).getNome());
                }
                System.out.print("Escolha um serviço pelo número: ");
                int servicoIndex = scanner.nextInt() - 1;

                if (servicoIndex < 0 || servicoIndex >= servicos.size()) {
                    System.out.println("Serviço inválido!");
                } else {
                    Servico servicoEscolhido = servicos.get(servicoIndex);
                    Agendamento.agendarServico(cliente, servicoEscolhido);
                }
            } else if (opcao == 4){
                Agendamento.listarAgendamentos();
                    System.out.print("Digite o número do agendamento para cancelar: ");
                    int numAgendamento = scanner.nextInt();
                    for (Agendamento agendamento : Agendamento.agendamentos) {
                        if (agendamento.getNumeroAgendamento() == numAgendamento) {
                            System.out.println(agendamento.cancelarAgendamento());
                            break;
                        }
                    }
            }else if (opcao == 5) {
                Agendamento.listarAgendamentos();
            } else if (opcao == 6) {
                Profissional.cadastrarProfissional(cliente);
            } else if (opcao == 7){
                Relatorio.visualizarRelatorio();
            } else if (opcao == 8){
                break;
            }else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
