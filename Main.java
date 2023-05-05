import java.util.Scanner;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        boolean sair = false;
        while (!sair) {
            String resp = menu();

            switch (resp) {
                case "1":
                    Produto produto = cadastrarProduto();
                    String responseAdd = estoque.adicionarEstoque(produto);
                    System.out.println(responseAdd);
                    Geral.continuar();
                    break;
  
                case "2":
                    System.out.print("Digite o ID do produto que deseja consultar: ");
                    int idConsulta = sc.nextInt();
                    String responseBuscar = estoque.exibirProduto(idConsulta);
                    System.out.println(responseBuscar);
                    Geral.continuar();
                    break;
 
                case "3":
                    System.out.print("Digite o ID do produto que deseja remover: ");
                    int idRemover = sc.nextInt();
                    String responseRemover = estoque.removerEstoque(idRemover);
                    System.out.println(responseRemover);
                    Geral.continuar();
                    break;
 
                case "4":
                    String responseBuscarTodos = estoque.listarProdutos();
                    System.out.println(responseBuscarTodos);
                    Geral.continuar();
                    break;
 
                case "5":
                    int responseProdEstoque = estoque.qntProdutosEstoque();
                    System.out.println("EXISTEM: " + responseProdEstoque + " EM ESTOQUE");
                    Geral.continuar();
                    break;
 
                case "6":
                    double responseCapitalEstoque = estoque.capitalTotalEstoque();
                    System.out.println("O VALOR DE PRODUTOS EM ESTOQUE É DE: R$"+ responseCapitalEstoque);
                    Geral.continuar();
                    break;

                case "7":
                        System.out.println("DESLIGANDO SISTEMA");
                        sair = true;
                    break;
 
 
                default:
                    System.out.println("ERRO: OPÇÃO INVALIDA");
                    break;
            }

        }
        sc.close();
    }

    public static String menu() {
        Geral.limparTela();
        System.out.println("\n");
        System.out.println("+========================================+");
        System.out.println("| 1 - Adicionar produto                  |");
        System.out.println("| 2 - Visualizar produto                 |");
        System.out.println("| 3 - Remover produto                    |");
        System.out.println("| 4 - Listar Produtos                    |");
        System.out.println("| 5 - Quantidade de produtos em estoque  |");
        System.out.println("| 6 - Capital em estoque                 |");
        System.out.println("| 7 - Sair                               |");
        System.out.println("+========================================+");

    
        System.out.print("Digite o numero corresponsente a uma opção: ");
        String resp = sc.nextLine(); 

        return resp;
    }

    public static Produto cadastrarProduto(){
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        

        System.out.print("Preço: ");
        Double preco = sc.nextDouble();
        
        System.out.print("Quantidade minima: ");
        int qntMin = sc.nextInt();

        int qntAtt = 0;
        
        boolean sair = false;
        while (!sair) {
            System.out.println("Deseja adicionar produto ao estoque?(1 = sim, 2 = não)");
            String desjaAddProduto = sc.next();
            
            switch(desjaAddProduto){
                case "1":
                    System.out.print("Quantidade: ");
                    qntAtt = sc.nextInt();
                    sair = true;
                    break;

                case "2":
                    sair = true;
                    break;

                default:
                    System.out.println("ERRO: OPÇÃO INVALIDA");
                    break;
            }
            
        }

        Produto produto = new Produto(nome, modelo, marca, preco, qntMin, qntAtt); 
        
        return produto;
    }
}
