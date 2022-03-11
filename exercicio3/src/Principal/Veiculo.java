package Principal;

import Principal.enums.TipoVeiculo;

public class Veiculo {

	private String placa;
	private double preco;
	private int ano;
	private int capacidadeTanque;
	private String nomeVeiculo;
	private String cor;
	private String cambio;
	private String marca;
	private TipoVeiculo tipoVeiculo;

	public Veiculo(String placa, double preco, int ano, int capacidadeTanque, String nomeVeiculo, String marca, String cor,
			String cambio,TipoVeiculo tipoVeiculo) {
		super();
		this.placa = placa;
		this.preco = preco;
		this.ano = ano;
		this.capacidadeTanque = capacidadeTanque;
		this.nomeVeiculo = nomeVeiculo;
		this.marca = marca;
		this.cor = cor;
		this.cambio = cambio;
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}


	@Override
	public String toString() {
		return "---------+= DADOS COMPLETO DO VEICULO =+--------" + "\n" +
				"Preco: " + preco + "\n" +
				"Tipo de veiculo: " + tipoVeiculo + "\n" +
				"Nome do veiculo: " + nomeVeiculo + "\n" +
				"Ano: " + ano + "\n" +
				"Marca: " + marca + "\n" +
				"Cor: " + cor + "\n" +
				"Cambio: " + cambio + "\n" +
				"Capacidade do tanque: " + capacidadeTanque + "\n";

	}

}
