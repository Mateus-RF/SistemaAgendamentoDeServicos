package Main;

import java.util.Scanner;

import Main.usuario.Profissional;
import Main.usuario.Usuario;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioLogado = null;

        while (true) {
            // Exibição de boas-vindas
            System.out.println("\n=== Bem-vindo ao Sistema ===");
            System.out.println("1. Fazer Login");
            System.out.println("2. Cadastrar-se");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Fazer login
                    usuarioLogado = loginUsuario(scanner);
                    if (usuarioLogado != null) {
                        exibirMenuUsuario(scanner, usuarioLogado);
                    }
                    break;

                case 2:
                    // Registrar novo usuário
                    System.out.println("\n=== Cadastro de Novo Usuário ===");
                    Usuario.registrarUsuario();

                    // Mostrar opções de métodos após cadastro
                    System.out.println("\nUsuário cadastrado com sucesso!");
                    break;

                case 3:
                    // Encerrar o programa
                    System.out.println("Encerrando o sistema. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para fazer login
    public static Usuario loginUsuario(Scanner scanner) {
        Usuario usuarioLogado = null;
        System.out.println("\n=== Fazer Login ===");
        System.out.print("Digite seu email: ");
        String email = scanner.next();
        System.out.print("Digite sua senha: ");
        String senha = scanner.next();

        usuarioLogado = Usuario.login(email, senha);

        if (usuarioLogado == null) {
            System.out.println("Email ou senha inválidos. Tente novamente.");
        }

        return usuarioLogado;
    }


    public static void exibirMenuUsuario(Scanner scanner, Usuario usuarioLogado) {
        while (true) {
            System.out.println("\n=== Menu do Usuário ===");
            System.out.println("1. Visualizar Perfil");
            System.out.println("2. Editar Perfil");
            System.out.println("3. Cadastrar-se como Profissional");
            System.out.println("4. Desconectar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Visualizar perfil
                    System.out.println("\nPerfil do Usuário:");
                    System.out.println(usuarioLogado.visualizarPerfil());
                    break;

                case 2:
                    // Editar perfil
                    System.out.println("\nEditar Perfil:");
                    usuarioLogado.editarPerfil();
                    System.out.println("Perfil atualizado com sucesso!");
                    break;

                case 3:
                    if (usuarioLogado instanceof Profissional) {
                        System.out.println("Você já é um Profissional.");
                    } else {
                        Profissional profissional = Profissional.cadastrarProfissional();
                        if (profissional != null) {
                            usuarioLogado = profissional;
                            System.out.println("\nVocê agora é um Profissional:");
                            System.out.println(profissional.visualizarPerfil());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Desconectando...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Registrar um novo usuário:");
        Usuario.registrarUsuario();

        // Fazer login no sistema
        Usuario usuarioLogado = null;
        while (usuarioLogado == null) {
            System.out.println("\nFazer login no sistema:");
            System.out.print("Digite seu email: ");
            String email = scanner.next();
            System.out.print("Digite sua senha: ");
            String senha = scanner.next();

            usuarioLogado = Usuario.login(email, senha);

            if (usuarioLogado == null) {
                System.out.println("\nLogin inválido. Deseja tentar novamente? (S/N)");
                String resposta = scanner.next().toUpperCase();
                if (resposta.equals("N")) {
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                }
            }
        }

        // Editar perfil do usuário logado
        System.out.println("\nEditar perfil:");
        usuarioLogado.editarPerfil();

        // Exibir informações atualizadas
        System.out.println("\nPerfil atualizado:");
        System.out.println(usuarioLogado);
        System.out.println(usuarioLogado.visualizarPerfil());

        scanner.close();
    }
}
