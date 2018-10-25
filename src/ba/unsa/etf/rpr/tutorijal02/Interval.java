package ba.unsa.etf.rpr.tutorijal02;


public class Interval {
    private double pocetna_t, krajnja_t;
    boolean pocetna_ukljucena, krajnja_ukljucena;
    public Interval(double p, double k, boolean poc, boolean kraj) {
        if(p>k) throw new IllegalArgumentException("Greska: pocetna tacka veca od krajnje") ;
        this.pocetna_t = p;
        this.krajnja_t = k;
        this.pocetna_ukljucena = poc;
        this.krajnja_ukljucena = k;
    }
    public Interval() {
        this.pocetna_t = this.krajnja_t = 0;
        this.pocetna_ukljucena = this.krajnja_ukljucena = false;
    }
    public boolean isNull() { // moze biti efikasnija, ali duzi uslov u if
        Interval i = new Interval();
        if(this.equals(i)) return true;
        return false;
    }
    public boolean isIn(double tacka) {
        if(this.pocetna_ukljucena && this.krajnja_ukljucena) {
            if (tacka >= this.pocetna_t && tacka <= this.krajnja_t) return true;
        } else if(this.pocetna_ukljucena && !this.krajnja_ukljucena) {
            if(tacka >= this.pocetna_t && tacka < this.krajnja_t) return true;
        } else if(!this.pocetna_ukljucena && this.krajnja_ukljucena) {
            if(tacka > this.pocetna_t && tacka <= this.krajnja_t) return true;
        } else {
            if(tacka > this.pocetna_t && tacka < this.krajnja_t) return true;
        }
        return false;
    }
    public Interval intersect(Interval i);
    public static Interval intersect(Interval i1, Interval i2);
}
