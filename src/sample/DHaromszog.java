package sample;

import java.security.spec.ECField;

public class DHaromszog {

    private double aOldal;
    private double bOldal;
    private double cOldal;
    private int sorSzama;

    public DHaromszog(String sor, int sorSzama) throws Exception {
        this.sorSzama = sorSzama;
        //sor 1,11 1,48 1,85
        sor = sor.replace(',', '.');
        String[] adatok = sor.split(" ");

        this.setaOldal(Double.parseDouble(adatok[0]));
        this.setbOldal(Double.parseDouble(adatok[1]));
        this.setcOldal(Double.parseDouble(adatok[2]));

        this.EllNovekvoSorrend();
        this.EllMegszerkesztheto();
        this.EllDerekszogu();


    }

    public double getaOldal() {
        return aOldal;
    }

    public double getbOldal() {
        return bOldal;
    }

    public double getcOldal() {
        return cOldal;
    }

    public void setaOldal(double aOldal) throws Exception{
        if (aOldal > 0){
            this.aOldal = aOldal;
        }
        else{
            throw new Exception(String.format("%d. sor: A(z) 'a' oldal nem lehet nulla vagy negatív!",this.sorSzama));
        }

    }

    public void setbOldal(double bOldal) throws Exception{
        if (bOldal > 0){
            this.bOldal = bOldal;
        }
        else{
            throw new Exception(String.format("%d. sor: A(z) 'b' oldal nem lehet nulla vagy negatív!",this.sorSzama));
        }

    }

    public void setcOldal(double cOldal) throws Exception{
        if (cOldal > 0){
            this.cOldal = cOldal;
        }
        else{
            throw new Exception(String.format("%d. sor: A(z) 'c' oldal nem lehet nulla vagy negatív!",this.sorSzama));
        }

    }

    private boolean EllDerekszogu() throws Exception {
        if ((Math.pow(this.aOldal, 2) + Math.pow(this.bOldal, 2)) == Math.pow(this.cOldal, 2)){
            return true;
        }
        else{
            throw new Exception(String.format("%d. sor: A háromszög nem darékszögű!", this.sorSzama));
        }

    }

    private boolean EllMegszerkesztheto() throws Exception {
        if ((this.aOldal + this.bOldal) > this.cOldal){
            return true;
        }
        else{
            throw new Exception(String.format("%d. sor: A háromszöget nem lehet megszerkeszteni!",this.sorSzama));
        }
    }

    private boolean EllNovekvoSorrend() throws Exception {
        if (this.aOldal <= this.bOldal && this.bOldal <= this.cOldal){
            return true;
        }
        else{
            throw new Exception(String.format("%d. sor: Az adatok nincsenek növekvő sorrendben!",this.sorSzama));
        }
    }

    public double getKerulet(){
        return this.aOldal + this.bOldal + this.cOldal;
    }

    public double getTerulet(){
        return (this.aOldal * this.bOldal) / 2;
    }

    @Override
    public String toString() {
        return String.format("%d. sor: a=%.2f b=%.2f c=%.2f", this.sorSzama, this.aOldal, this.bOldal, this.cOldal);
    }
}
