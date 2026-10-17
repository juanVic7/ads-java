package tpsemana11;

public class TPSemana11 {

    public static void main(String[] args) {
        Livro umlivro = new Livro();
        
        //teste Create Table
        MYDAL.geraTabela(umlivro);
        
        //teste Insert
        umlivro.setTitulo("teste de titulo");
        umlivro.setAutor("teste de autor");
        umlivro.setEditora("teste de editora");
        umlivro.setAno("2026");
        umlivro.setLocalizacao("teste de local");
        MYDAL.set(umlivro);
        
        //teste Select & Delete
        umlivro.setTitulo("teste de titulo");
        umlivro.setAutor(null);
        umlivro.setEditora(null);
        umlivro.setAno(null);
        umlivro.setLocalizacao(null);
        MYDAL.get(umlivro);
        MYDAL.delete(umlivro);
       
        //teste Update
        Livro dados = new Livro();
        Livro chaves = new Livro();

        chaves.setTitulo("teste de titulo");
        dados.setAno("2026");
        dados.setLocalizacao("Santos/SP");
        MYDAL.update(dados, chaves);
        
        // Teste geraClasse
        umlivro.setTitulo("Serialização Java");
        umlivro.setAutor("Maurício Asenjo");
        umlivro.setEditora("Unisanta");
        umlivro.setAno("2026");
        umlivro.setLocalizacao("Santos/SP");
        
        MYDAL.set(umlivro);

        MYDAL.geraClasse("TabLivro", "tpsemana11");
        if (Erro.getErro()) {
            System.out.println("Erro ao gerar classe: " + Erro.getMens());
        } else {
            System.out.println("Classe gerada com sucesso!");
        }

        // Testes de serialização
        MYDAL.serializaJSON(umlivro);
        MYDAL.serializaXML(umlivro);

    }
    
}
