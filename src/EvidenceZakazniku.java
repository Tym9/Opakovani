import java.util.ArrayList;
import java.util.List;

public class EvidenceZakazniku {
    public List<Zakaznik> zakaznici = new ArrayList<>();

    public void pridejZakaznika(Zakaznik zakaznik) {
        zakaznici.add(zakaznik);

    }
    public void odeberZakaznika(Zakaznik zakaznik) {
        zakaznici.remove(zakaznik);
    }

    public List<Zakaznik> filtrovatPodleProdeju(int minProdeje) {
        List<Zakaznik> vybrani = new ArrayList<>();
        for (Zakaznik z : zakaznici) {
            if (z.getPocetProdeju() > minProdeje) {
                vybrani.add(z);
            }
        }
        return vybrani;
    }

    public double prumernyPocetProdeju(String mesto) {
        int soucet = 0, pocet = 0;
        for (Zakaznik z : zakaznici) {
            if (z.getMesto().equalsIgnoreCase(mesto)) {
                soucet += z.getPocetProdeju();
                pocet++;
            }
        }
        return (pocet == 0) ? 0 : (double) soucet / pocet;
    }



}
