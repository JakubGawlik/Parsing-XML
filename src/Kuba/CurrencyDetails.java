package Kuba;

public class CurrencyDetails {

    String nazwa;
    String kod;
    double kurs;

    public CurrencyDetails(String nazwa, String kod, double kurs) {
        this.nazwa = nazwa;
        this.kod = kod;
        this.kurs = kurs;
    }
    public String getNazwa() {
        return nazwa;
    }
    public String getKod() {
        return kod;
    }
    public double getKurs() {
        return kurs;
    }
}
