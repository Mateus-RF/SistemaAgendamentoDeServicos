package Main;

import java.util.Scanner;

import Main.usuario.Profissional;
import Main.usuario.Usuario;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioLogado = null;

        while (true) {
            System.out.println("\n=== Bem-vindo ao Sistema ===");
            System.out.println("1. Fazer Login");
            System.out.println("2. Cadastrar-se");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    usuarioLogado = loginUsuario(scanner);
                    if (usuarioLogado != null) {
                        exibirMenuUsuario(scanner, usuarioLogado);
                    }
                    break;

                case 2:
                    System.out.println("\n=== Cadastro de Novo Usuário ===");
                    Usuario.registrarUsuario();

                    System.out.println("\nUsuário cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("Encerrando o sistema. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

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
                    System.out.println("\nPerfil do Usuário:");
                    System.out.println(usuarioLogado.visualizarPerfil());
                    break;

                case 2:
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
    }
}
