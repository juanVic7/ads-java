package packProduto;

import java.sql.*;

public class ProdutoDAL {
    private static Connection con;

    public static void conecta(String _alias, String _usuario, String _senha)
    {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://"+_alias,_usuario,_senha);
        }
        catch (Exception e) { Erro.setErro(e.getMessage()); }
    }

    public static void desconecta()
    {
        try {
            con.close();
        }
        catch (Exception e) { Erro.setErro(e.getMessage()); }
    }

    public static void consultaProduto()
    {
        ResultSet rs;
        String aux = "SELECT * FROM TabProduto where codigo=" + Produto.getCodigo();
        
        Erro.setErro(false);
        conecta("C:\\matar\\BD.mdb","","");
        if (Erro.getErro()) return;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(aux);
            if (rs.next())
            {
                Produto.setDescricao(rs.getString("descricao"));
                Produto.setFabricante(rs.getString("fabricante"));
                Produto.setQtd(rs.getInt("qtd"));
                Produto.setPreco(rs.getBigDecimal("preco"));
                
                Erro.setErro(false);
            }
            else
            {
                Erro.setErro(true); 
            }
            st.close();
        }
        catch(Exception e){ Erro.setErro(e.getMessage()); }
        desconecta();
    }    

    public static void insereProduto()
    {
        String aux = "INSERT INTO TabProduto (codigo, descricao, fabricante, qtd, preco ) "
                + "VALUES (" + Produto.getCodigo() + ",'" + Produto.getDescricao() 
                + "','" + Produto.getFabricante() 
                + "'," + Produto.getQtd() 
                + "," + Produto.getPreco() + ")";
        
        Erro.setErro(false);
        conecta("C:\\matar\\BD.mdb","","");
        if (Erro.getErro()) return;
        try {
            Statement st = con.createStatement();
            st.executeUpdate(aux);
            st.close();
        }
        catch(Exception e){ Erro.setErro("Erro ao inserir produto: " + e.getMessage()); }
        desconecta();
    }

    public static void alteraProduto()
    {
        String aux = "UPDATE TabProduto SET "
                + "descricao = '" + Produto.getDescricao() + "', "
                + "fabricante = '" + Produto.getFabricante() + "', "
                + "qtd = " + Produto.getQtd() + ", "
                + "preco = " + Produto.getPreco() 
                + " WHERE codigo = " + Produto.getCodigo();

        Erro.setErro(false);
        conecta("C:\\matar\\BD.mdb","","");
        if (Erro.getErro()) return;
        try {
            Statement st = con.createStatement();
            int linhasAfetadas = st.executeUpdate(aux);
            if (linhasAfetadas > 0) {
                Erro.setErro(false);
            } else {
                Erro.setErro(true); 
            }
            st.close();
        }
        catch(Exception e){ Erro.setErro(e.getMessage()); }
        desconecta();
    }

    public static void deleteProduto() {
        String aux = "DELETE FROM TabProduto WHERE codigo = " + Produto.getCodigo();
        
        Erro.setErro(false);
        conecta("C:\\matar\\BD.mdb","","");
        if (Erro.getErro()) return;
        try {
            Statement st = con.createStatement();
            int linhasAfetadas = st.executeUpdate(aux); 
            if (linhasAfetadas > 0)
            {
                Erro.setErro(false); 
            }
            else
            {
                Erro.setErro(true);
            }
            st.close();
        }
        catch(Exception e){ Erro.setErro(e.getMessage()); }
        desconecta();
    }
}