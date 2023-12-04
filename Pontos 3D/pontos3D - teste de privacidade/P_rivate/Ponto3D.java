package pontos3D.P_rivate;
;

 class Ponto3D {
    private double x;
    private double y;
    private double z;
    private String cor;
    private double intensidade;

    private Ponto3D(double x, double y, double z, String cor, double intensidade) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cor = cor;
        this.intensidade = intensidade;
    }

    // Métodos getters e setters
    private double getX() {
        return x;
    }

    private void setX(double x) {
        this.x = x;
    }

    private double getY() {
        return y;
    }

    private void setY(double y) {
        this.y = y;
    }

    private double getZ() {
        return z;
    }

    private void setZ(double z) {
        this.z = z;
    }

    private String getCor() {
        return cor;
    }

    private void setCor(String cor) {
        this.cor = cor;
    }

    private double getIntensidade() {
        return intensidade;
    }

    private void setIntensidade(double intensidade) {
        this.intensidade = intensidade;
    }

    private double calculaDistancia(Ponto3D p) {
        double deltaX = this.x - p.getX();
        double deltaY = this.y - p.getY();
        double deltaZ = this.z - p.getZ();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }
}
