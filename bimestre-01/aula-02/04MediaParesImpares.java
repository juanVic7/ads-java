import java.util.Random;
/*
4. Criar um array com 20 posições e inicializá-lo com valores aleatórios. 
Exibir os números gerados e ao final: 
a média aritmética destes e a quantidade de pares e ímpares.
*/
public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();
        int[] arrayNumeros = new int[20];
        System.out.println("Números Aleatórios: ");
        
        for (int i = 0; i < arrayNumeros.length; i++){
            arrayNumeros[i] = gerador.nextInt(40);   
            System.out.print(arrayNumeros[i] + " - ");
        }	
        calcularMedia(arrayNumeros);
        calcularQtParesImpares(arrayNumeros);
    }
    
    public static void calcularMedia(int[] arrayNumeros)
    {
        double soma = 0;
        for(int i = 0; i < arrayNumeros.length; i ++)
        {
            soma += arrayNumeros[i];
        }
        double  media = soma/arrayNumeros.length;
        System.out.println("\nMédia: " + media);
    }
    
    public static void calcularQtParesImpares(int[] arrayNumeros)
    {
        int pares = 0;
        int impares = 0;
        for(int i = 0; i < arrayNumeros.length; i ++)
        {
            if(arrayNumeros[i] % 2 == 0)
            {
                pares ++;
            }
            else
            {
                impares ++;
            }
        }
        System.out.println("Quantidade de números pares: " + pares);
        System.out.println("Quantidade de números impares: " + impares);
    }
    
    
}