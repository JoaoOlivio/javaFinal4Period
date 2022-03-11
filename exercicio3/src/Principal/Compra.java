package Principal;

import java.time.LocalDateTime;

public class Compra {

    private LocalDateTime dataCompra;
    private Double valorFinal;
    private Vendedor vendedor;
    private Veiculo veiculo;

    public Compra(LocalDateTime dataCompra, Double valorFinal,
            Vendedor vendedor, Veiculo veiculo) {
        this.dataCompra = dataCompra;
        this.valorFinal = valorFinal;
        this.vendedor = vendedor;
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return "Compra\n" + 
                "Data Compra: " + dataCompra + "\n" +
                "Valor Final: " + valorFinal + "\n" +
                veiculo +
                vendedor;
    }

}
