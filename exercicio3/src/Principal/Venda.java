package Principal;

import java.time.LocalDateTime;

public class Venda {

    private LocalDateTime dataVenda;
    private Double valorFinal;
    private Vendedor vendedor;
    private Veiculo veiculo;

    public Venda(LocalDateTime dataVenda, Double valorFinal,
            Vendedor vendedor, Veiculo veiculo) {
        this.dataVenda = dataVenda;
        this.valorFinal = valorFinal;
        this.vendedor = vendedor;
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
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
        return "\n\nVenda\n" + 
                "Data Venda: " + dataVenda + "\n" +
                "Valor Final: " + valorFinal + "\n" +
                veiculo +
                vendedor;
    }

}
