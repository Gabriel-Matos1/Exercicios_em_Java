
class C1_2 extends C implements I1 {
    int[][] atributo3;

    // Construtor sem parâmetros
    C1_2() {
        super(); // Chama o construtor da superclasse C
        this.atributo3 = new int[2][2];
    }

    // Construtor com parâmetros
    C1_2(String p1, float p2) {
        super(p1, p2); // Chama o construtor da superclasse C com parâmetros
        this.atributo3 = new int[3][3];
        // Inicializa a matriz com elementos 1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.atributo3[i][j] = 1;
            }
        }
    }

    @Override
    public void operacao1() {
        super.operacao1(); // Chama operacao1() da superclasse C
        System.out.println("Chamando operacao1() em C1_2 - Matriz atributo3:");
        for (int i = 0; i < atributo3.length; i++) {
            for (int j = 0; j < atributo3[i].length; j++) {
                System.out.print(atributo3[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void operacao2() {
        System.out.println("Chamando operacao2() em C1_2");
    }
}
