/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjpessoatp4;

/**
 *
 * @author unisanta
 */
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class PessoaDAL {
    private static ObjectContainer db;
    
    public static void conecta()
    {
    try {
        db = Db4o.openFile("meubancoPessoa.dbo");
      }
    catch (Exception e) {
      Erro.setErro(e.getMessage());
      }
    }

    public static void desconecta()
    {
    try {
      db.close();
      }
    catch (Exception e) {
      Erro.setErro(e.getMessage());
      }
    }

    public static void inseriPessoa(Pessoa _umaPessoa)
    {
      Erro.setErro(false);
      try {
          db.set(_umaPessoa);
      }
      catch(Exception e){
        Erro.setErro(e.getMessage());
      } 
    }

    public static void consultaPessoa(Pessoa _umaPessoa)
    {
      ObjectSet<Pessoa> lista;

      Erro.setErro(false);
      try {
        lista = db.get(_umaPessoa);
        if (lista.hasNext())
        {
            Pessoa aux = lista.next();
            _umaPessoa.setNome(aux.getNome());
            _umaPessoa.setSexo(aux.getSexo());
            _umaPessoa.setIdade(aux.getIdade());
        }
        else
        {
            Erro.setErro("Pessoa nao localizada."); return;
        }
      }
      catch(Exception e){
        Erro.setErro(e.getMessage());
      } 
    }

    public static void deletaPessoa(Pessoa _umaPessoa)
    {
      ObjectSet<Pessoa> lista;

      Erro.setErro(false);
      try {
        lista = db.get(_umaPessoa);
        if (lista.hasNext())
        {
            _umaPessoa = lista.next();
            db.delete(_umaPessoa);
        }
        else
        {
            Erro.setErro("Pessoa nao localizada."); return;
        }
      }
      catch(Exception e){
        Erro.setErro(e.getMessage());
      } 
    }

    public static void alteraPessoa(Pessoa _umaPessoa)
    {
      ObjectSet<Pessoa> lista;
      Pessoa consulta = new Pessoa();
      consulta.setCodigo(_umaPessoa.getCodigo());

      Erro.setErro(false);
      try {
        lista = db.get(consulta);
        if (lista.hasNext())
        {
            consulta = lista.next();
            consulta.setNome(_umaPessoa.getNome());
            consulta.setSexo(_umaPessoa.getSexo());
            consulta.setIdade(_umaPessoa.getIdade());
            db.set(consulta);
        }
        else
        {
            Erro.setErro("Pessoa nao localizada."); return;
        }
      }
      catch(Exception e){
        Erro.setErro(e.getMessage());
      } 
    } 
}
