package Veiculos;

class VeiculoTerrestre extends Veiculo {
    public VeiculoTerrestre(String modelo, String cor) {
        super(modelo, cor);
    }

    @Override
    public void andar() {
        System.out.println("Veículo terrestre andando.");
    }
}
