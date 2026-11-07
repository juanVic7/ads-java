package packProduto;

import java.math.BigDecimal;

public class Produto {
    private static int codigo;
    private static String descricao;
    private static String fabricante;
    private static int qtd;
    private static BigDecimal preco;
    
    public static void setCodigo(int _codigo) {codigo=_codigo;}
    public static void setDescricao(String _descricao) {descricao=_descricao;}
    public static void setFabricante(String _fabricante){fabricante=_fabricante;}
    public static void setQtd(int _qtd){qtd=_qtd;}
    public static void setPreco(BigDecimal _preco){preco=_preco;}
    
    
    public static int getCodigo() {return codigo;}
    public static String getDescricao() {return descricao;}
    public static String getFabricante() {return fabricante;}
    public static int getQtd() {return qtd;}
    public static BigDecimal getPreco() {return preco;}
}
