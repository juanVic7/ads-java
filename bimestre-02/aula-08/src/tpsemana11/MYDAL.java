package tpsemana11;

import java.lang.reflect.*;
import java.sql.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MYDAL {
     
  private static Connection con;
  
  public static void conecta(String _bd)
    {
        Erro.setErro(false);
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + _bd);
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void desconecta()
    {
        Erro.setErro(false);
        try 
        {
            con.close();
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

  public static void geraTabela(Object obj) {
    Field[] f = obj.getClass().getDeclaredFields();
    String sql = "Create Table Tab" + obj.getClass().getSimpleName() + " (";

    for (int i = 0; i < f.length; ++i) {
      sql +=
          f[i].getName()
              + " "
              + (f[i].getType().getSimpleName().equals("String") ? "varchar(60)" : f[i].getType());
      if (i != (f.length - 1)) sql = sql + ", ";
    }
    sql += ")";
    System.out.println(sql);
  }

  public static void set(Object obj) {
    Field[] f = obj.getClass().getDeclaredFields();
    String sql = "Insert Into Tab" + obj.getClass().getSimpleName() + " (";
    Method mtd;

    for (int i = 0; i < f.length; ++i) {
      sql += f[i].getName();
      if (i != (f.length - 1)) sql = sql + ", ";
    }
    sql += ") values (";
    for (int i = 0; i < f.length; ++i) {
      try {
        String aux =
            "get" + f[i].getName().substring(0, 1).toUpperCase() + f[i].getName().substring(1);
        mtd = obj.getClass().getMethod(aux);

        if (f[i].getType().getSimpleName().equals("String")) sql += "'" + mtd.invoke(obj) + "'";
        else sql += mtd.invoke(obj);
      } catch (Exception e) {
      }
      if (i != (f.length - 1)) sql = sql + ", ";
    }
    sql += ")";
    System.out.println(sql);
  }

  public static void delete(Object obj) {
    Field[] f = obj.getClass().getDeclaredFields();
    String sql = "Delete from Tab" + obj.getClass().getSimpleName() + " where ";
    Method mtd;
    String aux1, aux2;
    boolean flag = false;

    for (int i = 0; i < f.length; ++i) {
      try {
        aux1 = "get" + f[i].getName().substring(0, 1).toUpperCase() + f[i].getName().substring(1);
        mtd = obj.getClass().getMethod(aux1);
        aux2 = mtd.invoke(obj).toString();
        if (!aux2.equals("")) {
          if (flag) sql += " and ";
          else flag = true;
          sql += f[i].getName() + " = ";
          if (f[i].getType().getSimpleName().equals("String")) sql += "'" + aux2 + "'";
          else sql += aux2;
        }
      } catch (Exception e) {
      }
    }

    System.out.println(sql);
  }

  public static void get(Object obj) {
    Field[] f = obj.getClass().getDeclaredFields();
    String sql = "Select * from Tab" + obj.getClass().getSimpleName() + " where ";
    Method mtd;
    String aux1, aux2;
    boolean flag = false;

    for (int i = 0; i < f.length; ++i) {
      try {
        aux1 = "get" + f[i].getName().substring(0, 1).toUpperCase() + f[i].getName().substring(1);
        mtd = obj.getClass().getMethod(aux1);
        aux2 = mtd.invoke(obj).toString();
        if (!aux2.equals("")) {
          if (flag) sql += " and ";
          else flag = true;
          sql += f[i].getName() + " = ";
          if (f[i].getType().getSimpleName().equals("String")) sql += "'" + aux2 + "'";
          else sql += aux2;
        }
      } catch (Exception e) {
      }
    }

    System.out.println(sql);
  }

  public static void update(Object dados, Object chaves) {
    Field[] f = dados.getClass().getDeclaredFields();
    String sql = "Update Tab" + dados.getClass().getSimpleName() + " set ";
    Method mtd;
    String aux1, aux2;
    boolean flag = false;

    for (int i = 0; i < f.length; ++i) {
      try {
        aux1 = "get" + f[i].getName().substring(0, 1).toUpperCase() + f[i].getName().substring(1);
        mtd = dados.getClass().getMethod(aux1);
        aux2 = mtd.invoke(dados).toString();
        if (!aux2.equals("")) {
          if (flag) sql += ", ";
          else flag = true;
          sql += f[i].getName() + " = ";
          if (f[i].getType().getSimpleName().equals("String")) sql += "'" + aux2 + "'";
          else sql += aux2;
        }
      } catch (Exception e) {
      }
    }

    sql += " where ";
    f = chaves.getClass().getDeclaredFields();
    flag = false;

    for (int i = 0; i < f.length; ++i) {
      try {
        aux1 = "get" + f[i].getName().substring(0, 1).toUpperCase() + f[i].getName().substring(1);
        mtd = chaves.getClass().getMethod(aux1);
        aux2 = mtd.invoke(chaves).toString();
        if (!aux2.equals("")) {
          if (flag) sql += " and ";
          else flag = true;
          sql += f[i].getName() + " = ";
          if (f[i].getType().getSimpleName().equals("String")) sql += "'" + aux2 + "'";
          else sql += aux2;
        }
      } catch (Exception e) {
      }
    }

    System.out.println(sql);
  }
      public static void serializaJSON(Object obj) {
        String json = "{";
        Field[] f = obj.getClass().getDeclaredFields();
        Method mtd;
        String aux1, aux2;
        boolean flag = false;

        for (int i = 0; i < f.length; ++i) {
            try {
                aux1 = "get" + f[i].getName().substring(0, 1).toUpperCase() + f[i].getName().substring(1);
                mtd = obj.getClass().getMethod(aux1);
                aux2 = mtd.invoke(obj).toString();

                if (!aux2.equals("")) {
                    if (flag) {
                        json += ",\n";
                    } else {
                        flag = true;
                    }
                    
                    // Usa \" para imprimir aspas duplas no nome da propriedade
                    json += "\"" + f[i].getName() + "\":";
                    
                    // Usa \" para imprimir aspas duplas no valor
                    if (f[i].getType().getSimpleName().equals("String")) {
                        json += "\"" + aux2 + "\"";
                    } else {
                        json += aux2;
                    }
                }
            } catch (Exception e) {
            }
        }
        json += "}";
        System.out.println("\nSerializacao em JSON:");
        System.out.println(json);
    }
        public static void geraClasse(String _tabela, String _package)
    {
        File arquivo = new File(_tabela + ".java");
        ResultSet rs;
        ResultSetMetaData rsmd;
        
        conecta("banco/Livros.mdb");
        Erro.setErro(false);
        try 
        {
            Statement st = con.createStatement();
            rs = st.executeQuery("Select * from " + _tabela);
            rsmd = rs.getMetaData();
            String aux, auxMaiuscula;
            
            FileWriter fw = new FileWriter(arquivo);
            fw.write("package " + _package + ";\n\n");
            fw.write("public class " + _tabela + " {\n");
            
            // 1. Atributos privados
            for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            {
                aux = rsmd.getColumnName(i).toLowerCase();
                fw.write("    private String " + aux + ";\n");
            }
            
            // 2. Construtor vazio
            fw.write("\n    public " + _tabela + "() {}\n");
            
            // 3. Métodos SET (em linha única)
            for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            {
                aux = rsmd.getColumnName(i).toLowerCase();
                auxMaiuscula = aux.substring(0, 1).toUpperCase() + aux.substring(1);
                
                fw.write("    public void set" + auxMaiuscula + "(String _" + aux + ") {" + aux + "=_" + aux + ";}\n");
            }
            
            fw.write("\n");
            
            // 4. Métodos GET (em linha única)
            for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            {
                aux = rsmd.getColumnName(i).toLowerCase();
                auxMaiuscula = aux.substring(0, 1).toUpperCase() + aux.substring(1);
                
                fw.write("    public String get" + auxMaiuscula + "() {return " + aux + ";}\n");
            }
            
            // FECHAMENTO DA CLASSE (faltava esta linha no seu código!)
            fw.write("}\n");
            
            fw.flush();
            fw.close();
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
        desconecta();
    }


      public static void serializaXML(Object obj) {
        String xml = "<" + obj.getClass().getSimpleName() + ">\n";
        Field[] f = obj.getClass().getDeclaredFields();
        Method mtd;
        String aux1, aux2;

        for (int i = 0; i < f.length; ++i) {
            try {
                aux1 = "get" + f[i].getName().substring(0, 1).toUpperCase() + f[i].getName().substring(1);
                mtd = obj.getClass().getMethod(aux1);
                aux2 = mtd.invoke(obj).toString();

                if (!aux2.equals("")) {
                    // Concatena a tag de abertura, o valor e a tag de fechamento direto
                    xml += "    <" + f[i].getName() + ">" + aux2 + "</" + f[i].getName() + ">\n";
                }
            } catch (Exception e) {
            }
        }
        xml += "</" + obj.getClass().getSimpleName() + ">\n";
        System.out.println("\nSerializacao em XML:");
        System.out.println(xml);
    }

}
