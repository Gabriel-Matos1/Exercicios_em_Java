package Veiculos;
import java.util.Scanner;
public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos veículos deseja criar? ");
        int quantidadeVeiculos = scanner.nextInt();

        Veiculo[] veiculos = new Veiculo[quantidadeVeiculos];

        for (int i = 0; i < quantidadeVeiculos; i++) {
            System.out.println("Informe os dados do veículo " + (i + 1) + ":");
            System.out.print("Modelo: ");
            String modelo = scanner.next();

            System.out.print("Cor: ");
            String cor = scanner.next();

            System.out.print("Tipo de veículo (1 - Carro, 2 - Trem, 3 - Avião, 4 - Barco): ");
            int tipoVeiculo = scanner.nextInt();

            switch (tipoVeiculo) {
                case 1:
                    veiculos[i] = new Carro(modelo, cor);
                    break;
                case 2:
                    veiculos[i] = new Trem(modelo, cor);
                    break;
                case 3:
                    veiculos[i] = new Aviao(modelo, cor);
                    break;
                case 4:
                    veiculos[i] = new Barco(modelo, cor);
                    break;
                default:
                    System.out.println("Tipo de veículo inválido.");
            }
        }

        System.out.println("\nMovimentos dos veículos:");
        for (Veiculo veiculo : veiculos) {
            veiculo.andar();
        }

    scanner.close();
    }
}
