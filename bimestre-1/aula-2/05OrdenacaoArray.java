import java.util.Random;
import java.util.Arrays;
/*
5. Volte ao exercício anterior e na hora de listar os números gerados eu os quero ordenados. 
Com certeza você irá pensar em implementar o algoritmo para ordenação de arrays 
visto lá no primeiro ano com o Prof. Sobrino. 
Porém o Java nos oferece esse recurso através do método “sort”. 
Pesquise e use-o!
*/

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();
        int[] arrayNumeros = new int[20];
        
        for (int i = 0; i < arrayNumeros.length; i++){
            arrayNumeros[i] = gerador.nextInt(40);  
        }
        mostrarNumerosOrdenados(arrayNumeros);	
        calcularMedia(arrayNumeros);
        calcularQtParesImpares(arrayNumeros);
    }
    
    public static void mostrarNumerosOrdenados(int[] arrayNumeros)
    {
        System.out.println("Números Aleatórios Ordenados: ");
        Arrays.sort(arrayNumeros);
        for (int i = 0; i < arrayNumeros.length; i++){
            
            System.out.print(arrayNumeros[i] + " - "); 
        }
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