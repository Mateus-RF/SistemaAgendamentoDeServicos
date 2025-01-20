package Main;

import java.util.Scanner;
import Main.usuario.Usuario;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Registrar um novo usuário
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
