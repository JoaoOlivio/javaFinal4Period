package Principal;

import Principal.enums.TipoVeiculo;

public class Carro extends Veiculo {

	private String categoria;
	private double versao;
	private int qntPorta;

	public Carro(String placa, double preco, int ano, int capacidadeTanque, String nomeVeiculo, String marca, String cor,
			String cambio,
			TipoVeiculo tipoVeiculo, String categoria, double versao, int qntPorta) {
		super(placa,preco, ano, capacidadeTanque, nomeVeiculo, marca, cor, cambio, tipoVeiculo);
		this.categoria = categoria;
		this.versao = versao;
		this.qntPorta = qntPorta;
	}


	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getVersao() {
		return versao;
	}

	public void setVersao(double versao) {
		this.versao = versao;
	}

	public int getQntPorta() {
		return qntPorta;
	}

	public void setQntPorta(int qntPorta) {
		this.qntPorta = qntPorta;
	}

	@Override
	public String toString() {
		return super.toString() + "Categoria: " + categoria + "\n" +
				"Versao do motor: " + versao + "\n" +
				"Quantidade de porta: " + qntPorta + "\n" +
				"---------------------------------------" + "\n";
	}

}
