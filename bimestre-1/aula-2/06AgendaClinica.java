import java.util.Scanner;

/*
6. Determinado fisioterapeuta atende em sua clínica de segunda a sexta-feira no horário das 08:00 às 12:00. 
Cada sessão tem duração de uma hora, assim podemos ter sessões as 8, 9, 10 e 11 horas.
 Crie uma estrutura de array que nos permita representar a agenda semanal deste profissional.  
Feito isso vamos construir um programa que nos mostre na tela um menu com três opções: 
Agendar
Listar Agenda
Fim

Na opção “Agendar” você deverá digitar o nome do paciente, o dia desejado (2 para segunda, 3 para terça e assim por diante) 
e o horário (8, 9, 10 ou 11) e então realizar o agendamento, registrando no array o nome do paciente. 
Caso o horário não esteja disponível informar o fato através de mensagem de erro;

Na opção “Listar Agenda” deverão ser listados o dia (Segunda, Terça, ...) 
e os horários em que o fisioterapeuta terá sessão!
*/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        boolean continuar = true;
        String[][] agenda = new String[5][4];
         
         System.out.println("== AGENDAMENTO DE SESSÕES ==");
        while(continuar)
        {
            System.out.println("[1] - Agendar sessão");
            System.out.println("[2] - Listar Agenda");
            System.out.println("[3] - fim");
            System.out.println("Escolha uma opção: ");
            String escolhaMenu = in.next();
            switch(escolhaMenu)
            {
                case "1":
                    agendarSessao(agenda, in);
                    break;
                 case "2":
                     exibirAgenda(agenda);
                    break; 
                 case "3":
                     continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");  
                    break;
            }
        }
        in.close();
        System.out.println("Encerrando o programa...");
    }
    public static void agendarSessao(String[][] agenda, Scanner in)
    {
        boolean continuar = true;
        String nomePaciente;
        int dia = 0;
        int horario = 0;
        System.out.println("= Agendar Sessão =");
        while(continuar)
        {
        	System.out.print("Digite o nome do paciente: ");
            nomePaciente = in.next();
            boolean  continuarEscolhendo = true;
            while(continuarEscolhendo){
                System.out.println("Horários: ");
            	System.out.println(" 8:00hrs - 9:00hrs - 10:00hrs - 11:00hrs ");
                horario = validarNumero(in, "Digite o horário: ",  8,  11);
                System.out.println("Dias: ");
            	System.out.println(" Segunda [2] - Terça [3] - Quarta [4] - Quinta [5] - Sexta [6] ");
                dia = validarNumero(in, "Digite o dia: ",  2, 6);
                boolean disponivel = verificarDisponibilidade(dia, horario, agenda);
                if(disponivel)
                {
                    dia -= 2;
       			 horario -= 8;
                    agenda[dia][horario] = nomePaciente;
                    continuarEscolhendo = false;
                }
                else
                {
                    System.out.print("Horário indisponível!");
                }
            }
            
            System.out.println("Sessão marcada com sucesso!");
             
            System.out.print("digite 0 para sair ou qualquer tecla para agendar uma nova sessão: ");
            String opcao = in.next();
            continuar= !opcao.equals("0");
        }
        
    }
    public static void exibirAgenda(String [][] agenda)
    {
        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        String[] horarios = {"8:00", "9:00", "10:00", "11:00"};
        System.out.println("== Agenda ==");
        for(int i = 0; i < agenda.length; i++)
        {
            System.out.println("\n" + dias[i] +": ");
            for(int x = 0; x < agenda[i].length; x++)
            {
                if(agenda[i][x] != null)
                {
                    System.out.println(horarios[x] + " - " + agenda[i][x]);
                }
                else{
                    System.out.println(horarios[x] + " -  está disponível");
                }
            }
        }
    }
    public static boolean verificarDisponibilidade(int dia, int horario, String[][] agenda)
    {
        dia -= 2;
        horario -= 8;
        return (agenda[dia][horario] == null)
    }
    public static int validarNumero(Scanner in, String mensagem, int numMin, int numMax)
    {
        while (true) {
      	  System.out.print(mensagem);
        	if (in.hasNextInt()) {
           	 int valor = in.nextInt();
                if(valor >= numMin && valor <= numMax)
                {
                    return valor;
                }
                else
                {
                    System.out.println("Número inválido! Digite um número entre " + numMin + " a " + numMax);
                }
      	  } else {
           	 System.out.println("Número inválido! Digite novamente.");
           	 in.next(); 
        	}
   	 }
    }
}