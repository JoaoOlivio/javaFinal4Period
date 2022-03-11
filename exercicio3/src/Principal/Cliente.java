package Principal;

import Principal.enums.TipoPessoa;

public class Cliente extends Pessoa {


    public Cliente(String nome, TipoPessoa tipoPessoa, String cpfCnpj, String telefone) {
        super(nome, tipoPessoa, cpfCnpj, telefone);
    }

}
