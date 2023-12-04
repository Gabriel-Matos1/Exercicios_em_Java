package pontos3D.P_rotected;

class Ponto3D {
    protected double x;
    protected double y;
    protected double z;
    protected String cor;
    protected double intensidade;

    protected Ponto3D(double x, double y, double z, String cor, double intensidade) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cor = cor;
        this.intensidade = intensidade;
    }

    // Métodos getters e setters
    protected double getX() {
        return x;
    }

    protected void setX(double x) {
        this.x = x;
    }

    protected double getY() {
        return y;
    }

    protected void setY(double y) {
        this.y = y;
    }

    protected double getZ() {
        return z;
    }

    protected void setZ(double z) {
        this.z = z;
    }

    protected String getCor() {
        return cor;
    }

    protected void setCor(String cor) {
        this.cor = cor;
    }

    protected double getIntensidade() {
        return intensidade;
    }

    protected void setIntensidade(double intensidade) {
        this.intensidade = intensidade;
    }

    protected double calculaDistancia(Ponto3D p) {
        double deltaX = this.x - p.getX();
        double deltaY = this.y - p.getY();
        double deltaZ = this.z - p.getZ();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }
}
