import java.io.IOException;

public class App {

    public static void limparTela() throws InterruptedException, IOException  {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static void main(String[] args) throws Exception {

        limparTela();
        
        Automovel a1 = new Automovel(0, 50, 100,200,30, 10);

        System.out.println("Abastecendo...");
        a1.abastecer(10, 600);
        
        System.out.println("\nAcelerando...");
        a1.acelerar(4);

        System.out.println("\nFreando...");
        a1.frear(1);
        
    }
}
