/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudpessoas;

/**
 *
 * @author unisanta
 */
public class Pessoa {
    
    private String cpf;
  private String nome;
  private String email;
  private String mae;

  public Pessoa() {}

  public void setCpf(String _cpf) {
    cpf = _cpf;
  }

  public void setNome(String _nome) {
    nome = _nome;
  }

  public void setEmail(String _email) {
    email = _email;
  }

  public void setMae(String _mae) {
    mae = _mae;
  }

  public String getCpf() {
    return cpf;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getMae() {
    return mae;
  }
    
}
