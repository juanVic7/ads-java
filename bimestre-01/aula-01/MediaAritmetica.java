import java.util.Scanner;
/*
Exercício 2:
Calcular e exibir a média aritmética de quatro valores quaisquer que serão digitados. 
Se a média final for maior ou igual a 6 informar também que o aluno esta aprovado, 
se for menor que três que esta reprovado 
e se for maior ou igual a três e menor que seis que esta de exame.
 */
public class Main {
    public static void main(String[] args) {
        double[] notas = new double[4];
        Scanner in = new Scanner(System.in);
        boolean continuar=true;
        while(continuar)
        {
            
       	 for(int i = 0; i < notas.length; i ++)
       	 {
            	notas[i]=lerNota(in, i);
      	  }
        	double mediaFinal= calcularMediaAritmetica(notas);
        	System.out.print("\nA sua média final é:  "+mediaFinal);
        	if(mediaFinal>=6) System.out.print("\nVocê foi aprovado!");
            else if(mediaFinal <3) System.out.print("\nVocê foi reprovado!");
        	else System.out.print("\nVocê está de exame!");
        	System.out.print("\nDigite 0 para sair ou qualquer tecla para continuar: ");
        	 String opcao = in.next();
      	  continuar = !opcao.equals("0");
       }
        System.out.print("\nEncerrando programa...");
        in.close();
    }
    public static double lerNota(Scanner in, int i) {
        while (true) {
            System.out.print("Digite a "+(i+1)+"° nota: ");

            if (in.hasNextDouble()) {
                double nota= in.nextDouble();
                if(nota >= 0 && nota <=10)
                {
                    return nota;
                }
                else {
                System.out.println("A nota deve estar entre 0 e 10, digite novamente. ");
                }
            } else {
                System.out.println("Nota inválida! Digite novamente.");
                in.next(); 
            }
        }
    }
    public static double calcularMediaAritmetica(double[] notas)
    {
        double soma=0;
        for(int i = 0; i <notas.length; i++)
        {
            soma+= notas[i];
        }
        return soma/notas.length;
    }
}