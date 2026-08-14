/*
1.	Exibir os 15 primeiros termos da série: 2, 5, 10, 17, 26, .... 
Ao final exibir a somatória e a média aritmética destes termos. 
Atente para o fato de que o termo geral da série é :
x2 + 1 onde x = 1, 2, 3, 4, 5 
*/
public class Main {
    public static void main(String[] args) {
        
        int[] serieDeTermos = new int[15];
        int somaTermos = 0;
        System.out.println("Sequência dos 15 primeiros termos: ");
        for (int i = 0; i < serieDeTermos.length; i++) {
            int x = i + 1;
            serieDeTermos[i] = x * x + 1;
            somaTermos += serieDeTermos[i];
            System.out.print(serieDeTermos[i] + " - ");
        }
        System.out.println("\nA soma de todos os termos apresentados: " + somaTermos);
        double mediaTermos = (double)somaTermos/ serieDeTermos.length;
        System.out.print("A média de todos os termos apresentados: " + mediaTermos);
    }
}