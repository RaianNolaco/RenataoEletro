import java.util.Scanner;

public class Geral {

    private static Scanner sc = new Scanner(System.in); 

    public static void limparTela () {
        try {

            new ProcessBuilder("cmd", "/c" , "cls" ).inheritIO().start().waitFor();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void continuar(){
        String input = sc.nextLine();
        while (!input.isEmpty()) {
            input = sc.nextLine();
        }
    }
}
