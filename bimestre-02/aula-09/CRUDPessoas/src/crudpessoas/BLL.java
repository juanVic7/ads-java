
package crudpessoas;

import tpsemana11.Erro;
import tpsemana11.AFDAL;
import tpsemana11.ALDAL;

public class BLL {

    public static void validaCpf(char digito, Pessoa _umaPessoa) {
        Erro.setErro(false);
        if (_umaPessoa.getCpf().equals("")) {
            Erro.setErro("O campo CPF é de preenchimento obrigatório...");
            return;
        }
        if (digito == 'd') {
            ALDAL.delete(_umaPessoa);
            if (Erro.getErro()) {
                return;
            }
        } else if (digito == 'c') {
            ALDAL.get(_umaPessoa);
            if (Erro.getErro()) {
                return;
            }
        }

    }

    public static void validaDados(Pessoa _umaPessoa) {
        Erro.setErro(false);
        if (_umaPessoa.getCpf().equals("")) {
            Erro.setErro("O campo CPF é de preenchimento obrigatório...");
            return;
        }
        if (_umaPessoa.getNome().equals("")) {
            Erro.setErro("O campo Nome é de preenchimento obrigatório...");
            return;
        }
        if (_umaPessoa.getEmail().equals("")) {
            Erro.setErro("O campo Email é de preenchimento obrigatório...");
            return;
        }
        if (_umaPessoa.getMae().equals("")) {
            Erro.setErro("O campo Mae é de preenchimento obrigatório...");
            return;
        }
        
        
        

        ALDAL.set(_umaPessoa);
        if (Erro.getErro()) {
            return;
        }

    }
    
    public static void validaDadosAtualizado(Pessoa _umaPessoa, Pessoa _umaPessoaAtualizada) {
        Erro.setErro(false);
        if (_umaPessoaAtualizada.getCpf().equals("")) {
            Erro.setErro("O campo CPF é de preenchimento obrigatório...");
            return;
        }
        if (_umaPessoaAtualizada.getNome().equals("")) {
            Erro.setErro("O campo Nome é de preenchimento obrigatório...");
            return;
        }
        if (_umaPessoaAtualizada.getEmail().equals("")) {
            Erro.setErro("O campo Email é de preenchimento obrigatório...");
            return;
        }
        if (_umaPessoaAtualizada.getMae().equals("")) {
            Erro.setErro("O campo Mae é de preenchimento obrigatório...");
            return;
        }
        
        
        

        ALDAL.update( _umaPessoaAtualizada, _umaPessoa);
        if (Erro.getErro()) {
            return;
        }

    }

}
