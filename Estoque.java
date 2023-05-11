import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public String adicionarEstoque(Produto produto) {
        this.produtos.add(produto);

        return "O PRODUTO: " + produto.getNome() + " FOI ADICIONADO\nID:" + produto.getId();
    }

    public String listarProdutos() {
        String listaProdutos = "";

        for (Produto produto : produtos) {
            listaProdutos += produto.toString() + "\n";
        }

        return listaProdutos;
    }

    public void alterarPrecoProduto(int id, double novoValor) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setPreco(novoValor);
            }
        }
    }

    public String exibirProduto(int id) {
        String produtoString = "";
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtoString = produto.toString();
            }
        }
        if(produtoString.isEmpty())
            return "PRODUTO NÃO ENCONTRADO";

        return produtoString;
    }

    public String removerEstoque(int id){

        Produto remover = null;
        for (Produto prod : produtos) {
            if(prod.getId() == id){
                remover = prod;
                break;
            }
        }

        if(remover.equals(null))
            return "PRODUTO NÃO ENCONTRADO";
        
        String nome = remover.getNome();

        produtos.remove(remover);
        return  "O PRODUTO: " + nome + " FOI REMOVIDO\nID:" + id;
    }

    public int qntProdutosEstoque() {
        int qntTotal = 0;
        for (Produto produto : produtos) {
            qntTotal += produto.getQnt();
        }

        return qntTotal;
    }

    public double capitalTotalEstoque() {

        double valorEstoque = 0;
        for (Produto produto : produtos) {
            valorEstoque += produto.getPreco() * produto.getQnt();
        }

        return valorEstoque;
    }


    public String relatorio(){
       String relatorio =""; 
       relatorio += "Quantidade de produtos em estoque: " +qntProdutosEstoque() +"\n";
       relatorio += "PRODUTOS: \n" +listarProdutos()+ "\n"; 
       relatorio += "Capital acumulado de produtos: " + capitalTotalEstoque();
        return relatorio;
    }

}
