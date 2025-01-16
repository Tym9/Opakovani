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

}
