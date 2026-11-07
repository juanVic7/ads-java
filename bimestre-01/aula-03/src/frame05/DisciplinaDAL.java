/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame05;
import java.sql.*;
/**
 *
 * @author unisanta
 */
public class DisciplinaDAL {
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
    public static void atualizaDisciplina(Disciplina umaDisciplina)
    {
        Erro.setErro(false);
        try 
        {
            PreparedStatement st = con.prepareStatement("UPDATE TabDisciplinas SET Nome = ? ,CargaHoraria = ? WHERE Código = ?");
            st.setString(1,umaDisciplina.getNome());
            st.setString(2,umaDisciplina.getCargaHoraria());
            st.setString(3,umaDisciplina.getCodigo());
            
            st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }
    public static void deletaDisciplina(Disciplina umaDisciplina)
{
   Erro.setErro(false);
        try 
        {
            PreparedStatement st = con.prepareStatement("DELETE FROM  TabDisciplinas WHERE Código = ?");
            st.setString(1,umaDisciplina.getCodigo());
            
            st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }

}
    

    public static void inseriDisciplina(Disciplina umaDisciplina)
    {
        Erro.setErro(false);
        try 
        {
            PreparedStatement st = con.prepareStatement("insert into TabDisciplinas (Código,Nome,CargaHoraria) values (?,?,?)");
            st.setString(1,umaDisciplina.getCodigo());
            st.setString(2,umaDisciplina.getNome());
            st.setString(3,umaDisciplina.getCargaHoraria());
            
            st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void consultaDisciplina(Disciplina umaDisciplina)
    {
        ResultSet rs;

        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM TabDisciplinas WHERE Código=?");
            st.setString(1,umaDisciplina.getCodigo());
            rs = st.executeQuery();
            if (rs.next())
            {
                umaDisciplina.setCodigo(rs.getString("Código"));
                umaDisciplina.setNome(rs.getString("Nome"));
                umaDisciplina.setCargaHoraria(rs.getString("CargaHoraria"));
      
            }
            else
            {
                Erro.setErro("Disciplina nao localizada.");
                return;
            }
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }
}
