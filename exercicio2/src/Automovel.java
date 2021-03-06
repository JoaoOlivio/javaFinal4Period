
public class Automovel {

    private double quilometragem;
    private double volumeCombustivel;
    private double capacidadeTanque ;
    private int velocidadeMaxima;
    private double velocidadeAtual = 0;
    private int aceleracaoMedia ;
    private double consumoMedio;

    public Automovel(double quilometragem, double volumeCombustivel, double capacidadeTanque, int velocidadeMaxima,
            int aceleracaoMedia, double consumoMedio) {
        this.quilometragem = quilometragem;
        this.capacidadeTanque = capacidadeTanque;
        this.velocidadeMaxima = velocidadeMaxima;
        this.aceleracaoMedia = aceleracaoMedia;
        this.consumoMedio = consumoMedio;

        if (volumeCombustivel > capacidadeTanque) {
            this.volumeCombustivel = capacidadeTanque;
            System.err.println("O volume de combustivel foi setado como a capacidade maxima do tanque.");
        } else {
            this.volumeCombustivel = volumeCombustivel;
        }
    }

    public void abastecer(double custoLitro, double valorPago) {

        double quantidade;
        double diferenca = 0;

        if (valorPago <= 0) {
            System.out.println("Valor pago não pode ser 0");
        } else {
            quantidade = valorPago / custoLitro;

            if (volumeCombustivel + quantidade > capacidadeTanque) {
                diferenca = (volumeCombustivel + quantidade) - capacidadeTanque;
                System.err.printf("Capacidade maxima do tanque atingida.\n");
                System.out.printf("Foi abastecido: %.2f L\n", capacidadeTanque - volumeCombustivel);
                System.out.printf("O troco foi de: R$ %.2f\n", custoLitro * diferenca);
                volumeCombustivel = capacidadeTanque;
            } else {
                volumeCombustivel += quantidade;
                System.out.printf("Foi abastecido: %.2f L\n",volumeCombustivel);
            }
        }

    }

    private double converterParaMetros(double velocidadeAtual){
        return velocidadeAtual / 3.6;
    }

    public void acelerar(int segundos) {
        for (int x = 1; x <= segundos; x++) {
            if (this.velocidadeAtual + this.aceleracaoMedia < this.velocidadeMaxima) {
                this.velocidadeAtual += this.aceleracaoMedia;
            } else {
                this.velocidadeAtual = this.velocidadeMaxima;
            }
            this.quilometragem += converterParaMetros(velocidadeAtual) / 1000;
            this.volumeCombustivel -= (converterParaMetros(velocidadeAtual) / 1000) / this.consumoMedio;
        }

        System.out.printf("Velocidade atual: %.2f km/h\n", velocidadeAtual);
        System.out.printf("KM percorrido: %.2f\n",quilometragem);
        System.out.printf("Combustível atual: %.2f L\n",volumeCombustivel);
    }

    public void frear(int segundos) {
        for (int x = 1; x <= segundos; x++) {
            if (this.velocidadeAtual - this.aceleracaoMedia > 0) {
                velocidadeAtual -= aceleracaoMedia;
            } else {
                velocidadeAtual = 0;
        }
            quilometragem += (converterParaMetros(velocidadeAtual)) / 1000;
            volumeCombustivel -= (converterParaMetros(velocidadeAtual) / 1000) / consumoMedio;
        }

        System.out.printf("Velocidade atual: %.2f km/h\n", velocidadeAtual);
        System.out.printf("KM percorrido: %.2f\n",quilometragem);
        System.out.printf("Combustível atual: %.2f L\n",volumeCombustivel);
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getVolumeCombustivel() {
        return volumeCombustivel;
    }

    public void setVolumeCombustivel(double volumeCombustivel) {
        if (volumeCombustivel > capacidadeTanque) {
            this.volumeCombustivel = capacidadeTanque;
            System.err.println("O volume de combustivel ultrapassou a capacidade maxima do tanque.");
        } else {
            this.volumeCombustivel = volumeCombustivel;
        }
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public int getaceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setaceleracaoMedia(int aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }
}
