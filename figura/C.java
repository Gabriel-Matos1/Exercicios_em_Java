
class C {
    String atributo1;
    float atributo2;

    C() {
        this.atributo1 = "VAZIO";
        this.atributo2 = -999.99f;
    }

    C(String p1, float p2) {
        this.atributo1 = p1;
        this.atributo2 = p2;
    }

    void operacao1() {
        System.out.println("Chamando operacao1() em C - Atributo1: " + atributo1 + ", Atributo2: " + atributo2);
    }

    void operacao2() {
        System.out.println("Chamando operacao2() em C");
    }
}

