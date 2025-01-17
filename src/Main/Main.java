package Main;

import java.util.Scanner;
import Main.usuario.*;

public class Main {
    public static void main(String[] args) {
        // Criar o objeto Scanner para capturar entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Pedir para o usuário digitar o nome
        System.out.print("Digite o nome do usuário: ");
        
        
        // Registrando o usuário com o nome fornecido pelo usuário
        Usuario.registrarUsuario();
        Usuario.registrarUsuario();

        // Exibindo os dados do usuário
        
        System.out.println("Usuários registrados:");
        for (Usuario usuario : Usuario.usuarios) {
            System.out.println(usuario);

        // Fechar o scanner
        scanner.close();
    }
}}
