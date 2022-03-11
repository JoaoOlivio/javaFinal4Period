package Principal;

import Principal.enums.TipoVeiculo;

public class Moto extends Veiculo {

	private int cilindrada;
	private String tipoDePartida;

	public Moto(String placa, double preco, int ano, int capacidadeTanque, String nomeVeiculo, String marca, String cor,
			String cambio,
			TipoVeiculo tipoVeiculo, int cilindrada, String tipoDePartida) {
		super(placa, preco, ano, capacidadeTanque, nomeVeiculo, marca, cor, cambio, tipoVeiculo);
		this.cilindrada = cilindrada;
		this.tipoDePartida = tipoDePartida;
	}


	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getTipoDePartida() {
		return tipoDePartida;
	}

	public void setTipoDePartida(String tipoDePartida) {
		this.tipoDePartida = tipoDePartida;
	}

	@Override
	public String toString() {
		return super.toString() + "Cilindrada: " + cilindrada + "\n" +
				"Tipo de partida: " + tipoDePartida + "\n" +
				"---------------------------------------" + "\n";
	}

}
