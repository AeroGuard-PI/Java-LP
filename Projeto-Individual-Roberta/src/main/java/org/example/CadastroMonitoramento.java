package org.example;

import java.util.Scanner;

public class CadastroMonitoramento {

    static void main() {

        Scanner leitor = new Scanner(System.in);
        Scanner leitorLinha = new Scanner(System.in);

        System.out.println("----- CONFIGURAÇÃO DE MONITORAMENTO -----");

        System.out.println("Digite o nome da máquina:");
        String maquina = leitorLinha.nextLine();

        System.out.println("Digite o componente que deseja monitorar:");
        String componente = leitorLinha.nextLine();

        System.out.println("Digite o limite de alerta (%):");
        Double limite = leitor.nextDouble();

        System.out.println("Digite a frequência de coleta (segundos):");
        Integer frequencia = leitor.nextInt();

        System.out.println("\n----- MONITORAMENTO CADASTRADO COM SUCESSO! -----");

        System.out.println("Máquina: " + maquina);
        System.out.println("Componente: " + componente);
        System.out.println("Limite de alerta: " + limite + "%");
        System.out.println("Frequência de coleta: " + frequencia + " segundos");

        System.out.println("\nO componente foi adicionado à configuração de monitoramento!");

    }

}