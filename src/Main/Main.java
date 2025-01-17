package Main;

import java.util.Scanner;
import Main.usuario.*;

public class Main {
    public static void main(String[] args) {
        // Criar o objeto Scanner para capturar entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Pedir para o usuário digitar o nome
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        // Criação de um novo usuário
        Usuario usuario1 = new Usuario();
        
        // Registrando o usuário com o nome fornecido pelo usuário
        usuario1.registrarUsuario("12345678901", nome, "11987654321", "joao@email.com", "senha123");
        nome = scanner.nextLine();
        usuario1.registrarUsuario("12444444441", nome, "11987654321", "joao@email.com", "senha123");

        // Exibindo os dados do usuário
        
        System.out.println("Nome: " + usuario1.getNome());
        for(Usuario user : Usuario.usuarios){
            user.getNome();
        }

        // Fechar o scanner
        scanner.close();
    }
}
