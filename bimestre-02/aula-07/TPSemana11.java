package tpsemana11;

public class TPSemana11 {

  public static void main(String[] args) {
    Livro umlivro = new Livro();
    Livro dados = new Livro();
    Livro chaves = new Livro();

    umlivro.setTitulo("1");
    umlivro.setAutor("1");
    umlivro.setEditora("1");
    umlivro.setAno("1");
    umlivro.setLocalizacao("1");
    MyDAL.set(umlivro);
    System.out.println("--------------------------------------------");

    umlivro.setTitulo("1");
    umlivro.setAutor(null);
    umlivro.setEditora(null);
    umlivro.setAno(null);
    umlivro.setLocalizacao(null);
    MyDAL.delete(umlivro);
    System.out.println("--------------------------------------------");
    
    umlivro.setTitulo("1");
    umlivro.setAutor(null);
    umlivro.setEditora(null);
    umlivro.setAno(null);
    umlivro.setLocalizacao(null);
    MyDAL.get(umlivro);
    System.out.println("--------------------------------------------");
    
    chaves.setTitulo(null);
    chaves.setAutor(null);
    chaves.setEditora(null);
    chaves.setAno("2017");
    chaves.setLocalizacao(null);
    
    dados.setTitulo("Um Titulo Qualquer");
    dados.setAutor("Um autor qualquer");
    dados.setEditora("Uma editora qualquer");
    dados.setAno(null);
    dados.setLocalizacao("Santos/SP");
    MyDAL.update(dados, chaves);
    System.out.println("--------------------------------------------");
  }
}
