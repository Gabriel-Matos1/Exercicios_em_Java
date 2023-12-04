package pontos3D.P_ublic;



public class Ponto3D {
    private double x;
    private double y;
    private double z;
    private String cor;
    private double intensidade;

    public Ponto3D(double x, double y, double z, String cor, double intensidade) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cor = cor;
        this.intensidade = intensidade;
    }

    // Métodos getters e setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(double intensidade) {
        this.intensidade = intensidade;
    }

    public double calculaDistancia(Ponto3D p) {
        double deltaX = this.x - p.x;
        double deltaY = this.y - p.y;
        double deltaZ = this.z - p.z;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

 
}
