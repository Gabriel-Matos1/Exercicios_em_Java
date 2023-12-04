package Veiculos;


class VeiculoAquatico extends Veiculo {
    public VeiculoAquatico(String modelo, String cor) {
        super(modelo, cor);
    }

    @Override
    public void andar() {
        System.out.println("Veículo aquático navegando.");
    }
}



