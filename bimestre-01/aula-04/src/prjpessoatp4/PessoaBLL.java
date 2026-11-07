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
public class PessoaBLL {
    public static void validaCodigo(char _op, Pessoa _umaPessoa)
{
 Erro.setErro(false);
 if (_umaPessoa.getCodigo().equals(""))
   {Erro.setErro("O campo CÓDIGO é de preenchimento obrigatório..."); return;}

 PessoaDAL.conecta();
 if (Erro.getErro()) return;
 switch (_op)
 {
     case 'c':  PessoaDAL.consultaPessoa(_umaPessoa); break;
     case 'd':  PessoaDAL.deletaPessoa(_umaPessoa); break;   
    
 }
 PessoaDAL.desconecta();
}

public static void validaDados(char _op, Pessoa _umaPessoa)
{
 Erro.setErro(false);
 if (_umaPessoa.getCodigo().equals(""))
   {Erro.setErro("O campo CÓDIGO é de preenchimento obrigatório..."); return;}
 if (_umaPessoa.getNome().equals(""))
   {Erro.setErro("O campo NOME é de preenchimento obrigatório..."); return;}
 if (_umaPessoa.getSexo().equals(""))
   {Erro.setErro("O campo SEXO é de preenchimento obrigatório..."); return;}
 if (_umaPessoa.getIdade().equals(""))
   {Erro.setErro("O campo IDADE é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(_umaPessoa.getCodigo());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo CÒDIGO deve ser numerico!"); return;
     }
    try
        {
        Integer.parseInt(_umaPessoa.getIdade());
        }
      catch (Exception e)
        {
        Erro.setErro("O campo IDADE deve ser numerico!"); return;
        }
 
 PessoaDAL.conecta();
 if (Erro.getErro()) return;
 switch (_op)
 {
     case 'i':  PessoaDAL.inseriPessoa(_umaPessoa); break;
     case 'a':  PessoaDAL.alteraPessoa(_umaPessoa); break;    
 }
 PessoaDAL.desconecta();
 
}
    
}
