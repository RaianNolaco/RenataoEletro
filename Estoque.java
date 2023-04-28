import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> produtos;

    public void adicionarEstoque(Produto produto) {
        this.produtos.add(produto);
    }

    public String listarProdutos() {
        String listaProdutos = "";

        for (Produto produto : produtos) {
            listaProdutos += produto.toString();
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

        return produtoString;
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
}
