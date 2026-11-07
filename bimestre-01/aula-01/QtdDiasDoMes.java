import java.util.Scanner;
/*
Exercício 4:
O programa deverá nos solicitar a digitação dos valores de mês e ano em formato numérico, 
se o valor do mês estiver fora do intervalo de 1 a 12 sinalizar o erro,
 caso contrário informar quantos dias tem o mês em questão.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continuar= true;
        while(continuar)
        {
            int mes, ano;
            mes = validarEntrada(in, "Digite o mês desejado:  ", 1, 12);
            ano = validarEntrada(in, "Digite o ano desejado:  ", 1926, 2026);
            int qtdDias = informarQtdDias(mes, ano);
            System.out.println("O mês " + mes + " de "+ ano + " possui " + qtdDias +" dias!");
            
            System.out.print("Digite 0 para sair ou qualquer tecla para continuar: ");
            String opcao = in.next();
            continuar = !opcao.equals("0");
        }
        System.out.print("\nEncerrando programa...");
        in.close();
    }
    public static int validarEntrada(Scanner in, String msg, int faixa_min, int faixa_max) {
        while (true) {
            System.out.print(msg);

            if (in.hasNextInt()) {
                int entradaDigitada = in.nextInt();
                
                if(entradaDigitada < faixa_min || entradaDigitada > faixa_max){
                    System.out.println("Valor inválido! Digite um número dentro da faixa de " + faixa_min + " a " + faixa_max);
                } else {
                    return entradaDigitada;
                }
                
            } else {
                System.out.println("Valor inválido! Digite um número.");
                in.next(); 
            }
        }
    }
    public static int informarQtdDias(int mes, int ano){
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes ==8 || mes == 10 || mes == 12){
            return 31;
        }
        else if(mes==2){
            if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0){
                return 29;
            }
            else{
                return 28;
            }
        }
        else{
            return 30;
        }
    }
}