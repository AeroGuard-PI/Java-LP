package sptech.scholl;

import java.util.Scanner;

public class AeroGuard {
    Usuario[] usuarios = new Usuario[10];
    Integer quantidadeUsuarios = 0;

    void iniciar(Scanner scanner){
        Integer opcao = 0;
        while (opcao != 3){
            System.out.println("""
                    ------AERO GUARD------
                    1 - Cadastrar 
                    2 - Login
                    3 - Sair
                    
                    """);
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1 ) {
                cadastrar(scanner);

            } else if (opcao == 2) {
                login(scanner);

            } else if (opcao == 3) {
                System.out.println("Saindo...");

            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
    void cadastrar(Scanner scanner) {

        if (quantidadeUsuarios >= usuarios.length) {
            System.out.println("Limite de usuários atingido!");
            return;
        }

        Usuario usuario = new Usuario();

        System.out.println("------ CADASTRO------");

        System.out.print("Nome: ");
        usuario.nome = scanner.nextLine();

        System.out.print("Cargo: ");
        usuario.cargo = scanner.nextLine();

        System.out.print("E-mail: ");
        usuario.email = scanner.nextLine();

        System.out.print("Senha: ");
        usuario.senha = scanner.nextLine();

        usuarios[quantidadeUsuarios] = usuario;

        quantidadeUsuarios++;

        System.out.println("\nUsuário cadastrado com sucesso!");
    }


    void login(Scanner scanner) {

        System.out.println("------LOGIN------");

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (int i = 0; i < quantidadeUsuarios; i++) {

            if (usuarios[i].email.equals(email) && usuarios[i].senha.equals(senha)) {
                System.out.println("\nLogin realizado com sucesso!");
                menuUsuario(scanner, usuarios[i]);
                return;
            }
        }

        System.out.println("\nE-mail ou senha incorretos.");
    }


    void menuUsuario(Scanner scanner, Usuario usuario) {
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("""
                   ------MENU AER0_GUARD------
                    1 - Ver meus dados
                    2 - Monitoramento de hardware
                    3 - Logout
                    
                   """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                exibirDados(usuario);

            } else if (opcao == 2) {
                monitoramento();

            } else if (opcao == 3) {
                System.out.println("Logout realizado!");

            } else {
                System.out.println("Opção inválida!");
            }
        }
    }


    void exibirDados(Usuario usuario) {

        System.out.printf("""
                ------MEUS DADOS------
                Nome: %s
                Cargo: %s
                E-mail: %s
                """,
                usuario.nome,
                usuario.cargo,
                usuario.email);
    }


    void monitoramento() {

        System.out.println("""
                ---MONITORAMENTO DE HARDWARE---
                
                Servidor: SRV-TRAFEGO-01
                
                CPU:          42%
                Memória:      68%
                Temperatura:  54°C
                
                STATUS: NORMAL
                
                """);
    }


}
