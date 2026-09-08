package sptech.scholl;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        AeroGuard sistema = new AeroGuard();

        sistema.iniciar(scanner);

        scanner.close();
    }
}