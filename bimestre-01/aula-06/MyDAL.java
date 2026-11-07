package tpsemana11;

import java.lang.reflect.*;

public class MyDAL {

    public static void geraTabela(Object obj) {
        Field[] f  = obj.getClass().getDeclaredFields();
        String sql = "Create Table Tab" + obj.getClass().getSimpleName() + " (";

        for(int i = 0; i < f.length; ++i) {
            sql += f[i].getName() + " " + (f[i].getType().getSimpleName().equals("String") ? "varchar(60)" : f[i].getType());
            if (i != (f.length - 1)) sql = sql + ", ";
        }
        sql += ")";
        System.out.println(sql);
    }

    public static void set(Object obj) {
        Field[] f = obj.getClass().getDeclaredFields();
        String sql = "Insert Into Tab" + obj.getClass().getSimpleName() + " (";
        
        for(int i = 0; i < f.length; ++i) {
            sql += f[i].getName();
            if (i != (f.length - 1)) sql = sql + ", ";
        }
        
        sql += ") values (";
        
        try {
            for(int i = 0; i < f.length; ++i) {
                String atributo = f[i].getName();
                
                String nomeMetodo = "get" + atributo.substring(0, 1).toUpperCase() + atributo.substring(1);
                
                Method mtd = obj.getClass().getMethod(nomeMetodo);
                
                Object valor = mtd.invoke(obj); 
                
                sql += "'" + valor + "'";
                
                if (i != (f.length - 1)) {
                    sql += ", ";
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao acessar os métodos via Reflection: " + e.getMessage());
        }

        sql += ")";
        System.out.println(sql);
    }
    public static void delete(Object obj) {
        Field[] f = obj.getClass().getDeclaredFields();
        String sql = "Delete From Tab" + obj.getClass().getSimpleName() + " where ";
        int qtdSettada = 0;
        
        try {
            for (int i = 0; i < f.length; ++i) {
                String atributo = f[i].getName();
                
                String nomeMetodo = "get" + atributo.substring(0, 1).toUpperCase() + atributo.substring(1);
                Method mtd = obj.getClass().getMethod(nomeMetodo);
                Object valor = mtd.invoke(obj); 
                
                if (valor != null) {

                    if (qtdSettada > 0) {
                        sql += " and ";
                    }
                    
                    sql += atributo + " = '" + valor + "'";
                    qtdSettada++;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao acessar os métodos via Reflection: " + e.getMessage());
        }
        
        if (qtdSettada == 0) {
            System.out.println("Nenhum parâmetro informado para a exclusão.");
        } else {
            System.out.println(sql);
        }
    }
}
