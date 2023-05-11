public class Produto {

    private int id;
    private String nome;
    private String modelo;
    private String marca;
    private double preco;
    private int qntMinProdutos;
    private int qtd;
    private static int calcId; 

    public Produto() {}

    public Produto(String nome, String modelo, String marca, double preco, int qntMinProdutos) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.qntMinProdutos = qntMinProdutos;
        this.qtd = 0;

        calcId++;
        id = calcId;
    }

    public Produto(String nome, String modelo, String marca, double preco, int qntMinProdutos, int qtd) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.qntMinProdutos = qntMinProdutos;
        this.qtd = qtd;

        
        calcId++;
        id = calcId;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPreco() {
        return preco;
    }

    public int getQntMinProdutos() {
        return qntMinProdutos;
    }

    public int getQnt() {
        return qtd;
    }

    public void setPreco(double novoValor) {
        this.preco = novoValor;
    }

    public void adicionarQtdProduto(int qntProdutos)throws Exception {
        this.qtd += qntProdutos;
    }

    public void removerQntProduto(int qntProdutos) throws Exception {
        if(qntProdutos < this.qtd)
          throw  new Exception("Quantidade de produtos não pode ser menor do que a quantidade em estoque");

        this.qtd -= qntProdutos;
    }

    @Override
    public String toString() {
        String stringProduto = "";

        stringProduto += "\nID: " + getId();
        stringProduto += "\nNome: " + getNome();
        stringProduto += "\nModelo: " + getModelo();
        stringProduto += "\nMarca: " + getMarca();
        stringProduto += "\nQuantidade: " + getQnt();
        stringProduto += "\nQuantidade minima: " + getQntMinProdutos();
        stringProduto += "\nPreço: " + getPreco();

        return stringProduto;
    }

}