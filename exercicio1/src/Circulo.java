public class Circulo {
    
    private double raio;
    private double cordenadaX;
    private double cordenadaY;

    public Circulo(double raio, double cordenadaX, double cordenadaY) {
        if(raio < 0){
            this.raio = raio * -1;
        }else{
            this.raio = raio;
        }
        this.cordenadaX = cordenadaX;
        this.cordenadaY = cordenadaY;
        
    }

    private double calcularProcertagem(double valor, double porcetagem){
        return valor *(porcetagem/100);
    }
    
    public void aumentarRaio(double porcetagem){
        raio += calcularProcertagem(raio, porcetagem);
    }

    public void centroCirculo(double x, double y){
        //Falta Fazer LETRA C
    }

    public double comprimentoCircuferencia(double raio){
        return (2 * 3.14) * raio;
    }

    public double calcularArea() {
        return 3.14 * (raio * raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if(raio < 0){
            this.raio = raio * -1;
        }else{
            this.raio = raio;
        }
    }

    public double getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(double cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public double getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaY(double cordenadaY) {
        this.cordenadaY = cordenadaY;
    }

    

   
}

