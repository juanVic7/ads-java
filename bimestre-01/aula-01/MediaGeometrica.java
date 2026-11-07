import java.util.Scanner;
/**
 Exercício 3:
 Calcular e exibir a média geométrica de quatro valores quaisquer que serão digitados
  (M = raiz quarta de (v1*v2*v3*v4)).
 * */
public class Main {
    public static void main(String[] args) {
        double[] valores = new double[4];
        Scanner in = new Scanner(System.in);
        boolean continuar=true;
        while(continuar)
        {
       	 for(int i = 0; i < valores.length; i ++)
       	 {
            	valores[i]=lerValor(in, i);
      	  }
        	double mediaFinal= calcularMediaGeometrica(valores);
        	System.out.print("\nA média geométrica dos valores digitados é: "+mediaFinal);
        	System.out.print("\nDigite 0 para sair ou qualquer tecla para continuar: ");
        	 String opcao = in.next();
      	  continuar = !opcao.equals("0");
       }
        System.out.print("\nEncerrando programa...");
        in.close();
    }
    public static double lerValor(Scanner in, int i) {
    while (true) {
        System.out.print("Digite o " + (i + 1) + "° valor: ");

        if (in.hasNextDouble()) {
            double valor = in.nextDouble();

            if (valor >= 0) {
                return valor;
            } else {
                System.out.println("O valor deve ser maior ou igual a zero. Digite novamente.");
            }
        } else {
            System.out.println("Valor inválido! Digite novamente.");
            in.next(); // Descarta a entrada inválida
        }
    }
}
    public static double calcularMediaGeometrica(double[] valores) {
    double produto = 1.0;

    for (double valor : valores) {
        produto *= valor;
    }

    return Math.pow(produto, 1.0 / valores.length);
}
}