package sptech.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AeroGuard {

    List<Usuario> listaDeUsuarios = new ArrayList<>();

    void iniciar(Scanner scanner){

        while (true){

            int opcao = 0;

            System.out.println("""
                    \n------AERO GUARD------
                    1 - Cadastrar 
                    2 - Login
                    3 - Sair
                    \n""");

            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

           if(opcao < 0 || opcao > 3){
                System.out.println("ATENÇÃO! Digite apenas 1, 2 ou 3");

           } else if (opcao == 1 ) {
                cadastrar(scanner);

           } else if (opcao == 2) {
                login(scanner);

           } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;

           }
        }
    }

    void cadastrar(Scanner scanner) {

        Usuario usuario = new Usuario();

        System.out.println("------ CADASTRO------");

        System.out.print("Nome: ");
        usuario.nome = scanner.nextLine();

        System.out.print("Cargo: ");
        usuario.cargo = scanner.nextLine();

        System.out.print("E-mail: ");
        usuario.email = scanner.nextLine();

        while (true) {

            System.out.print("Senha: ");
            usuario.senha = scanner.nextLine();

            System.out.println("Confirme sua senha: ");
            usuario.confirmeSenha = scanner.nextLine();

            if(usuario.senha.equals(usuario.confirmeSenha)){
                System.out.println("Senha cadastrada com sucesso!");
                break;
            } else {
                System.out.println("As senhas não coincidem. Tente novamente");
            }
        }

        System.out.print("CPF: ");
        usuario.cpf = scanner.nextLine();

        listaDeUsuarios.add(usuario);

        System.out.println("\nUsuário cadastrado com sucesso!");
    }


    void login(Scanner scanner) {

        while (true) {
            System.out.println("------LOGIN------");

            System.out.print("E-mail: ");
            String email = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            for (Usuario usuario : listaDeUsuarios) {

                if (usuario.email.equalsIgnoreCase(email) && usuario.senha.equalsIgnoreCase(senha)) {
                    System.out.println("\nLogin realizado com sucesso!\n");
                    menuUsuario(scanner, usuario);
                    return;

                }

            }
                System.out.println("\nE-mail ou senha incorretos.\n");

        }
    }


    void menuUsuario(Scanner scanner, Usuario usuario) {
        int opcao = 0;

        System.out.println("Olá, bom te ver aqui, " + usuario.nome + "!");

        while (true) {

            System.out.println("""
                   \n------ESCOLHA UMA DAS OPÇÕES------
                    1 - Ver meus dados
                    2 - Monitoramento de hardware
                    3 - Logout
                   """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao < 1 || opcao > 3){
                System.out.println("ATENÇÃO! Digite apenas 1, 2 ou 3");

            }
            if (opcao == 1) {
                exibirDados(usuario);

            } else if (opcao == 2) {
                monitoramento(scanner);

            } else if (opcao == 3) {
                System.out.println("Logout realizado!");
                break;

            }
        }
    }


    void exibirDados(Usuario usuario) {

        System.out.printf("""
                \n------MEUS DADOS------
                Nome: %s
                Cargo: %s
                E-mail: %s
                CPF: %s
                \n""",
                usuario.nome,
                usuario.cargo,
                usuario.email,
                usuario.cpf);
    }


    void monitoramento(Scanner scanner) {

        Scanner leitor = new Scanner(System.in);
        Scanner leitorLinha = new Scanner(System.in);

        int num = 0;
        String componente = "";

        System.out.println("\n----- CONFIGURAÇÃO DE MONITORAMENTO -----");
        System.out.println("Digite o nome da máquina:");
        String maquina = leitorLinha.nextLine();

        System.out.println("""
                Informe o componente que deseja monitorar:
                1 - CPU
                2 - Memória
                3 - Disco
                4 - Dados de Rede
                """);
        num = scanner.nextInt();
        scanner.nextLine();

        if(num < 1 || num > 4){
            System.out.println("Digite um número entre 1 e 4");

        } else if(num == 1){
            componente = "CPU";

        } else if(num == 2){
            componente = "Memória";

        } else if(num == 3){
            componente = "Disco";

        } else if(num == 4){
            componente = "Dados de Rede";

        }

        System.out.println("Digite o limite de alerta (%):");
        Double limite = leitor.nextDouble();

        System.out.println("Digite a frequência de coleta (segundos):");
        Integer frequencia = leitor.nextInt();

        System.out.println("\n----- MONITORAMENTO CADASTRADO COM SUCESSO! -----");

        System.out.println("Máquina: " + maquina);
        System.out.println("Componente: " + componente);
        System.out.println("Limite de alerta: " + limite + "%");
        System.out.println("Frequência de coleta: " + frequencia + " segundos");

        System.out.println("\nO componente foi adicionado à configuração de monitoramento!\n");
    }
}
