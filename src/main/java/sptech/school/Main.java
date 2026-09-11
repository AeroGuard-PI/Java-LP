package sptech.school;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        AeroGuard sistema = new AeroGuard();

        sistema.iniciar(scanner);

        scanner.close();
    }
}
