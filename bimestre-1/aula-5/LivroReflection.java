

import java.lang.reflect.*;
import java.util.Scanner;

public class LivroReflection {
    public static void main(String[] args) {
        Livro obj = new Livro();
        int qtdcampos = 0, i = 0;
        Scanner in = new Scanner(System.in);

        
        for (Field f : obj.getClass().getDeclaredFields()) {
            ++qtdcampos;
        }
        

        String sqlCreateTable = "CREATE TABLE " + obj.getClass().getSimpleName() + " (";

        for (Field f : obj.getClass().getDeclaredFields()) {
            ++i;

            if (f.getType() == String.class)
                sqlCreateTable += f.getName() + " VARCHAR(200)";

            if (i < qtdcampos) {
                sqlCreateTable += ",";
            }
        }

        sqlCreateTable += ");";
        System.out.println("COMANDO SQL PARA CRIAR A TABELA " + obj.getClass().getSimpleName()+": ");
        System.out.println("\n" + sqlCreateTable);       
       
       
    }
}
