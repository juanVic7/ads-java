/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame05;

/**
 *
 * @author unisanta
 */
public class DisciplinaBLL {
    public static void validaDados(Disciplina umaDisciplina){
 Erro.setErro(false);
 
 if (umaDisciplina.getCodigo().equals(""))
   {Erro.setErro("O campo CÓDIGO é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(umaDisciplina.getCodigo());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo CÓDIGO deve ser numerico!"); return;
     }
 if (umaDisciplina.getNome().equals(""))
   {Erro.setErro("O campo NOME é de preenchimento obrigatório..."); return;}
 if (umaDisciplina.getCargaHoraria().equals(""))
   {Erro.setErro("O campo CARGA HORÁRIA é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(umaDisciplina.getCodigo());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo CARGA HORÁRIA deve ser numerico!"); return;
     }
 DisciplinaDAL.conecta("Livros.mdb");
 if (Erro.getErro()) return;
 DisciplinaDAL.inseriDisciplina(umaDisciplina);
 if (Erro.getErro()) return;
 DisciplinaDAL.desconecta();
} 
    public static void deleteDisciplina(Disciplina umaDisciplina){
        Erro.setErro(false);
        DisciplinaDAL.conecta("Livros.mdb");
        if (Erro.getErro()){
            return;
        }
        DisciplinaDAL.deletaDisciplina(umaDisciplina);
        if (Erro.getErro()){
            return;
            
        }
        DisciplinaDAL.desconecta();
    }
    public static void updateDisciplina(Disciplina umaDisciplina){
        if (umaDisciplina.getNome().equals("")){
            Erro.setErro("O Campo 'Nome' é de preenchimento obrigatório..." );
            return;
        }
        if (umaDisciplina.getCargaHoraria().equals("")){
            Erro.setErro("O Campo 'Carga Horária' é de preenchimento obrigatório...");
            return;
        }
        else {
            try{
               Integer.parseInt(umaDisciplina.getCargaHoraria());
            }
            catch(Exception e){
                Erro.setErro("O Campo 'Carga Horária' deve ser numérico");
                return;
            }
            DisciplinaDAL.conecta("Livros.mdb");
            if (Erro.getErro()){
                return;
            }
            DisciplinaDAL.atualizaDisciplina(umaDisciplina);
            if (Erro.getErro()){
                return;
            }
            DisciplinaDAL.desconecta();
        }
    }

public static void validaCodigo(Disciplina umaDisciplina)
{
 Erro.setErro(false);
 if (umaDisciplina.getCodigo().equals(""))
   {Erro.setErro("O campo CÓDIGO é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(umaDisciplina.getCodigo());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo CÓDIGO deve ser numerico!"); return;
     }
 DisciplinaDAL.conecta("Livros.mdb");
 if (Erro.getErro()) return;
 DisciplinaDAL.consultaDisciplina(umaDisciplina);
 if (Erro.getErro()) return;
 DisciplinaDAL.desconecta();
}
}
