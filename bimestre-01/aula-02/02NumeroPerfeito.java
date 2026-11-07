import java.util.Scanner;
/*
2. Digitado um número verificar se este é perfeito ou não. 
Lembro que um número é dito perfeito quando a soma dos seus
 divisores, excetuando-se ele próprio é igual a ele mesmo, 
 por exemplo 6 é um número perfeito 
 pois seus divisores são 1, 2 e 3 e (1 + 2 + 3) = 6.
*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continuar = true;
        int somaDivisores;
        while(continuar) {
       	 int numeroDigitado = validarNumero(in, "Digite um número: ");
 	       somaDivisores = 0;
        	for(int i = 1; i < numeroDigitado; i++)
        	{
            	if(numeroDigitado % i == 0)
            	{
                	somaDivisores += i;
           	 }
        	}
        	if(somaDivisores == numeroDigitado)
        	{
            	System.out.print("O número " + numeroDigitado + " é perfeito! ");
       	 }
        	else
        	{
           	 System.out.print("O número " + numeroDigitado + " não é perfeito! ");
        	}
       	 System.out.print("\nDigite 0 para sair ou qualquer tecla para continuar: ");
        	 String opcao = in.next();
      	  continuar = !opcao.equals("0");
       }
        System.out.print("\nEncerrando programa...");
        in.close();
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