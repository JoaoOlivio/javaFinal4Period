package Principal;

import java.util.Map;

import Principal.enums.TipoPessoa;

public class Vendedor extends Pessoa {

    private double comissao;

    public Vendedor(String nome, TipoPessoa tipoPessoa, String cpfCnpj, String telefone,
            double comissao) {
        super( nome, tipoPessoa, cpfCnpj, telefone);
        this.comissao = comissao;
    }

    public void mapToVendedor(Map<String, String> vendedor, int x) {
        mapToPessoa(vendedor, x);
        comissao = Double.parseDouble(vendedor.get("comissao" + x));
    }

    public Vendedor() {
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Comissao: " + comissao;
    }

}
