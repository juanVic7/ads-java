import java.util.Scanner;
/*
Exercício 1:
Entrar via teclado com o valor de uma temperatura em graus Celsius, 
calcular e exibir sua temperatura equivalente em Fahrenheit (F = C *1.8 + 32).
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            double temperatura = lerTemperatura(in);
            double resultado = converterEmFahrenheit(temperatura);

            System.out.printf("Temperatura em Fahrenheit: %.2f°F%n", resultado);

            System.out.print("Digite 0 para sair ou qualquer tecla para continuar: ");
            String opcao = in.next();

            continuar = !opcao.equals("0");
        }

        System.out.print("\nEncerrando programa...");
        in.close();
    }

    public static double lerTemperatura(Scanner in) {
        while (true) {
            System.out.print("Digite a temperatura em graus Celsius: ");

            if (in.hasNextDouble()) {
                return in.nextDouble();
            } else {
                System.out.println("Valor inválido! Digite um número.");
                in.next(); // Descarta a entrada inválida
            }
        }
    }

    public static double converterEmFahrenheit(double tempCelsius) {
        return tempCelsius * 1.8 + 32;
    }
}