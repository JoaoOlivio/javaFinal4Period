import java.io.IOException;

public class App {
    public static void limparTela() throws InterruptedException, IOException  {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        limparTela();

        Circulo c1 = new Circulo(2, 5, 20);

        System.out.printf("Aréa: %.2f\n", c1.calcularArea());
        System.out.printf("Comprimento Circuferencia: %.2f\n", c1.comprimentoCircuferencia(c1.getRaio()));
        System.out.printf("Raio normal: %.2f\n", c1.getRaio());
        c1.aumentarRaio(5);
        System.out.printf("Raio Aumentado: %.2f\n", c1.getRaio());

    }
}
