import java.util.InputMismatchException;
import java.util.Scanner;

class TorreDeHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // Captura y validación del número de discos
        while (true) {
            try {
                System.out.print("Ingrese el número de discos: ");
                n = scanner.nextInt();
                if (n <= 0) {
                    throw new IllegalArgumentException("El número de discos debe ser mayor a cero.");
                }