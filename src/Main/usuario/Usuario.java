package Main.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    protected long cpf, telefone;
    protected String nome, email, senha;
    protected String tipo = "Cliente"; // Diz se o usuário é um cliente, administrador ou profissional.

    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    // Setters
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(long numero) {
        this.telefone = numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Getters
    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public static void registrarUsuario() {
        Usuario novoUsuario = new Usuario();
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Cadastro de Usuario ===");
        while (true) {
            System.out.print("Digite seu CPF (11 dígitos): ");
            String cpf = scan.next();
            if (cpf.length() == 11) {
                novoUsuario.setCpf(Long.parseLong(cpf));
                break;
            } else {
                System.out.println("CPF inválido. Deve ter exatamente 11 dígitos.");
            }
        }

        System.out.print("Digite seu nome: ");
        scan.nextLine(); 
        novoUsuario.setNome(scan.nextLine());

        while (true) {
            System.out.print("Digite um número de contato (11 dígitos com DDD): ");
            String telefone = scan.next();
            if (telefone.length() == 11) {
                novoUsuario.setTelefone(Long.parseLong(telefone));
                break;
            } else {
                System.out.println("Número inválido. Deve ter 11 dígitos.");
            }
        }

        System.out.print("Digite seu email: ");
        novoUsuario.setEmail(scan.next());

        while (true) {
            System.out.print("Digite uma senha (mínimo 8 caracteres): ");
            String senha = scan.next();
            if (senha.length() >= 8) {
                novoUsuario.setSenha(senha);
                break;
            } else {
                System.out.println("Senha muito curta.");
            }
        }

        usuarios.add(novoUsuario);
        System.out.println("Usuário registrado com sucesso!");
    }

    public static Usuario login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Faça seu Login ===");
        System.out.println("Digite seu email: ");
        String email = scan.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scan.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return usuario;
            }
        }
        System.out.println("Email ou senha inválidos.");
        return null;
    }

    public void editarPerfil() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um número de contato (11 dígitos com DDD): ");
            String telefone = scan.next();
            if (telefone.length() == 11) {
                this.setTelefone(Long.parseLong(telefone));
                break;
            } else {
                System.out.println("Número inválido. Deve ter 11 dígitos.");
            }
        } 

        System.out.print("Digite o novo email da conta: ");
        scan.nextLine();
        this.setEmail(scan.nextLine());

        while (true) {
            System.out.print("Digite uma senha (mínimo 8 caracteres): ");
            String senha = scan.next();
            if (senha.length() >= 8) {
                this.setSenha(scan.nextLine());
                break;
            } else {
                System.out.println("Senha muito curta.");
            }
        }

        System.out.println("Perfil atualizado com sucesso!");
    }
    
    public String visualizarPerfil() {
        return "Nome: " + nome +
            "\nCPF: " + cpf +
            "\nTelefone: " + telefone +
            "\nEmail: " + email +
            "\nTipo: " + tipo;
    }

    static {
        Profissional profissional1 = new Profissional();
        profissional1.setCpf(11111111111L);
        profissional1.setNome("Neto");
        profissional1.setTelefone(11999999999L);
        profissional1.setEmail("edilsonAlves@exemplo.com");
        profissional1.setSenha("senha123");
        profissional1.setEspecialidade("Cabeleireiro");
        profissional1.adicionarHorario("09:00 - 10:00");

        Profissional profissional2 = new Profissional();
        profissional2.setCpf(22222222222L);
        profissional2.setNome("Maria Oliveira");
        profissional2.setTelefone(11988888888L);
        profissional2.setEmail("maria.oliveira@exemplo.com");
        profissional2.setSenha("senha456");
        profissional2.setEspecialidade("Manicure");
        profissional2.adicionarHorario("13:00 - 15:00");

        Profissional profissional3 = new Profissional();
        profissional3.setCpf(33333333333L);
        profissional3.setNome("Alice");
        profissional3.setTelefone(11977777777L);
        profissional3.setEmail("aliceMaria@exemplo.com");
        profissional3.setSenha("senha789");
        profissional3.setEspecialidade("Massoterapeuta");
        profissional3.adicionarHorario("10:00 - 10:50");

        Administrador administrador = new Administrador();
        administrador.setCpf(44444444444L);
        administrador.setNome("Mateus Administrador");
        administrador.setTelefone(11966666666L);
        administrador.setEmail("admin@admin");
        administrador.setSenha("admin123");

        // Adicionar à lista de usuários
        usuarios.add(profissional1);
        usuarios.add(profissional2);
        usuarios.add(profissional3);
        usuarios.add(administrador);
    }
}
