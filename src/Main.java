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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.next(); // Limpiar buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nSecuencia de movimientos para resolver la Torre de Hanoi:");
        resolverHanoi(n, 'A', 'C', 'B');
    }

/**
 * Método recursivo para resolver la Torre de Hanoi.
 * @param n Número de discos
 * @param origen Poste de origen
 * @param destino Poste de destino
 * @param auxiliar Poste auxiliar
 */
private static void resolverHanoi(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return;
        }

        // Mover n-1 discos de origen a auxiliar, usando destino como apoyo
        resolverHanoi(n - 1, origen, auxiliar, destino);

        // Mover el disco restante de origen a destino
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);

        // Mover los n-1 discos de auxiliar a destino, usando origen como apoyo
        resolverHanoi(n - 1, auxiliar, destino, origen);
    }
}
