package Principal;

import java.io.Serializable;
import java.util.Map;

import Principal.enums.TipoPessoa;

public class Pessoa implements Serializable {

	private String nome;
	private TipoPessoa tipoPessoa;
	private String cpfCnpj;
	private String telefone;

	public Pessoa( String nome, TipoPessoa tipoPessoa, String cpfCnpj, String telefone) {
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.cpfCnpj = cpfCnpj;
		this.telefone = telefone;
	}

	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public void mapToPessoa(Map<String, String> pessoa, int x) {
		nome = String.valueOf(pessoa.get("nome" + x));
		telefone = String.valueOf(pessoa.get("telefone" + x));
		tipoPessoa = Enum.valueOf(TipoPessoa.class, pessoa.get("tipodepessoa" + x));
		cpfCnpj = String.valueOf(pessoa.get("cpf"+ x) != null ? pessoa.get("cpf" + x) : pessoa.get("cnpj" + x));
	}

	@Override
	public String toString() {
		return "--------+= DADOS DA PESSOA =+-------" + "\n" +
				"Nome: " + nome + "\n" +
				"Telefone: " + telefone + "\n" +
				"Tipo de pessoa: " + tipoPessoa + "\n" +
				String.valueOf(
						tipoPessoa.equals(TipoPessoa.JURIDICA) ? "CNPJ: " + cpfCnpj + "\n" : "CPF: " + cpfCnpj + "\n");

	}

}
