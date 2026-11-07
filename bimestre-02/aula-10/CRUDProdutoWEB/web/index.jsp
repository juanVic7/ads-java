<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="packProduto.Erro"%>
<%@page import="packProduto.ProdutoDAL"%>
<%@page import="packProduto.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String acao = request.getParameter("acao");
    
    String codigo = "";
    String descricao = "";
    String fabricante = "";
    String quantidade = "";
    String preco = "";
    String mensagem = "";
    
    if (acao != null) {
        try {
            String codigoStr = request.getParameter("codigo");
            
            if (codigoStr == null || codigoStr.trim().isEmpty()) {
                mensagem = "Erro: O campo Código é obrigatório!";
            } else {
                Produto.setCodigo(Integer.parseInt(codigoStr));
                codigo = codigoStr;
                
                if (acao.equals("consultar")) {
                    ProdutoDAL.consultaProduto();
                    if (!Erro.getErro()) {
                        descricao = Produto.getDescricao() != null ? Produto.getDescricao() : "";
                        fabricante = Produto.getFabricante() != null ? Produto.getFabricante() : "";
                        quantidade = String.valueOf(Produto.getQtd());
                        
                        if (Produto.getPreco() != null) {
                            preco = Produto.getPreco().setScale(2, RoundingMode.HALF_UP).toString();
                        } else {
                            preco = "";
                        }
                        
                        mensagem = "Produto consultado com sucesso!";
                    } else {
                        mensagem = "Erro: Produto não encontrado.";
                    }
                } 
                else if (acao.equals("cadastrar") || acao.equals("alterar")) {
                    descricao = request.getParameter("descricao");
                    fabricante = request.getParameter("fabricante");
                    quantidade = request.getParameter("quantidade");
                    String precoStr = request.getParameter("preco");
                    
                    Produto.setDescricao(descricao);
                    Produto.setFabricante(fabricante);
                    Produto.setQtd(Integer.parseInt(quantidade));
                    Produto.setPreco(new BigDecimal(precoStr));
                    
                    if (acao.equals("cadastrar")) {

                        ProdutoDAL.consultaProduto();
                        if (!Erro.getErro()) {

                            mensagem = "Erro: Já existe um produto cadastrado com o código " + codigo + "!";
                        } else {
                            ProdutoDAL.insereProduto();
                            if (!Erro.getErro()) {
                                mensagem = "Produto cadastrado com sucesso!";
                            } else {
                                mensagem = "Erro ao cadastrar: " + Erro.getMens();
                            }
                        }
                    } else { 
                        ProdutoDAL.alteraProduto();
                        if (!Erro.getErro()) {
                            mensagem = "Produto alterado com sucesso!";
                        } else {
                            mensagem = "Erro ao alterar: Produto não encontrado para atualização.";
                        }
                    }
                } 
                else if (acao.equals("excluir")) {
                    ProdutoDAL.deleteProduto();
                    if (!Erro.getErro()) {
                        mensagem = "Produto excluído com sucesso!";
                        codigo = "";
                        descricao = "";
                        fabricante = "";
                        quantidade = "";
                        preco = "";
                    } else {
                        mensagem = "Erro ao excluir: Produto não encontrado.";
                    }
                }
            }
            
        } catch (NumberFormatException e) {
            mensagem = "Erro de validação: Verifique se os campos numéricos foram preenchidos corretamente.";
        } catch (Exception e) {
            mensagem = "Erro: " + e.getMessage();
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Projeto Produtos - CRUD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <div class="container">
            <h2>Gestão de Produtos</h2>
            
            <% if (!mensagem.isEmpty()) { %>
                <div class="mensagem"><%= mensagem %></div>
            <% } %>
            
            <form action="index.jsp" method="POST">
                <label>Código:</label>
                <div class="linha-codigo">
                    <input type="number" name="codigo" value="<%= codigo %>" required />
                    <button type="submit" name="acao" value="consultar" formnovalidate>Consultar</button>
                </div>
                
                <label>Descrição:</label>
                <input type="text" name="descricao" value="<%= descricao %>" required />
                
                <label>Fabricante:</label>
                <input type="text" name="fabricante" value="<%= fabricante %>" required />
                
                <label>Quantidade:</label>
                <input type="number" name="quantidade" value="<%= quantidade %>" required />
                
                <label>Preço (R$):</label>
                <input type="number" step="0.01" name="preco" value="<%= preco %>" required />

                <div class="botoes-acao">
                    <button type="submit" name="acao" value="cadastrar">Cadastrar</button>
                    <button type="submit" name="acao" value="alterar">Alterar</button>
                    <button type="submit" name="acao" value="excluir" formnovalidate>Excluir</button>
                </div>
            </form>
        </div>
    </body>
</html>