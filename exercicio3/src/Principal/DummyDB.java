package Principal;

import java.util.ArrayList;

import Principal.enums.TipoVeiculo;

public class DummyDB {

    private  ArrayList<Venda> vendasDB = new ArrayList<>();
    private  ArrayList<Compra> comprasDB = new ArrayList<>();
    private  ArrayList<Carro> carrosDB = new ArrayList<>();
    private  ArrayList<Moto> motosDB = new ArrayList<>();
    private  ArrayList<Vendedor> vendedoresDB = new ArrayList<>();
    private  ArrayList<Cliente> clientesDB = new ArrayList<>();


    public Cliente getClienteByDocumento(String documento) {

        for (Cliente cliente : clientesDB) {
            if (cliente.getCpfCnpj().equals(documento)) {
                return cliente;
            }
        }

        return null;
    }

    public Veiculo getVeiculoByPlaca(TipoVeiculo v, String placa) {

        if(v == TipoVeiculo.CARRO){
            for (Carro carro : carrosDB) {
                if (carro.getPlaca().equals(placa)) {
                    return carro;
                }
            }
        }else{
            for (Moto moto : motosDB) {
                if (moto.getPlaca().equals(placa)) {
                    return moto;
                }
            }
        }
        

        return null;
    }

    public Vendedor getVendedorByDocumento(String documento) {

        for (Vendedor vendedor : vendedoresDB) {
            if (vendedor.getCpfCnpj().equals(documento)) {
                return vendedor;
            }
        }

        return null;
    }

    public ArrayList<Venda> getVendasDB() {
        return vendasDB;
    }

    public void setVendasDB(ArrayList<Venda> vendasDB) {
        this.vendasDB = vendasDB;
    }

    public ArrayList<Compra> getComprasDB() {
        return comprasDB;
    }

    public void setComprasDB(ArrayList<Compra> comprasDB) {
        this.comprasDB = comprasDB;
    }

    public ArrayList<Carro> getCarrosDB() {
        return carrosDB;
    }

    public void setCarrosDB(ArrayList<Carro> carrosDB) {
        this.carrosDB = carrosDB;
    }

    public ArrayList<Moto> getMotosDB() {
        return motosDB;
    }

    public void setMotosDB(ArrayList<Moto> motosDB) {
        this.motosDB = motosDB;
    }

    public ArrayList<Vendedor> getVendedoresDB() {
        return vendedoresDB;
    }

    public void setVendedoresDB(ArrayList<Vendedor> vendedoresDB) {
        this.vendedoresDB = vendedoresDB;
    }

    public ArrayList<Cliente> getClientesDB() {
        return clientesDB;
    }

    public void setClientesDB(ArrayList<Cliente> clientesDB) {
        this.clientesDB = clientesDB;
    }

    
    
}
