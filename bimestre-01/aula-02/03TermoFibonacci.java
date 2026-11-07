import java.util.Scanner;
/*
3. O programa deverá nos exibir os “n” primeiros termos
 da série de Fibonacci.( 1, 1, 2, 3, 5, 8, ...).
 Sendo que o valor de “n” deverá ser digitado pelo usuário. 
 Para gerar os termos da série utilize um método recursivo.
*/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continuar = true;
        while(continuar)
        {
            int num = validarNumero(in, "Digite um número: ");
            for(int i = 1; i <= num; i ++)
            {
                System.out.print(fibonacci(i) + " - ");
            }
            System.out.print("\nDigite 0 para sair ou qualquer tecla para continuar: ");
        	 String opcao = in.next();
      	  continuar = !opcao.equals("0");
        }
        System.out.print("\nEncerrando programa...");
        in.close();
    }
    public static int fibonacci(int num)
	{
    	if (num == 1 || num == 2)
  	  {
        	return 1;
  	  }
    	else
  	  {
        	return fibonacci(num - 1) + fibonacci(num - 2);
    	}
	}
    public static int validarNumero(Scanner in, String mensagem)
    {
        while (true) {
      	  System.out.print(mensagem);
        	if (in.hasNextInt()) {
           	 int valor = in.nextInt();
                if(valor > 0)
                {
                    return valor;
                }
                else
                {
                    System.out.println("Valor inválido! Digite um número positivo.");
                }
      	  } else {
           	 System.out.println("Valor inválido! Digite novamente.");
           	 in.next(); 
        	}
   	 }
    }
}