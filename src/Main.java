
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Main {


    public static void main(String[] args) {
        Zakaznik zakaznik = new Zakaznik("Pepa", LocalDate.of(1990, 1, 1), "Praha", 5);
        Zakaznik zakaznik2 = new Zakaznik("Jana", LocalDate.of(1995, 2, 2), "Brno", 3);

        EvidenceZakazniku evidence = new EvidenceZakazniku();
        evidence.pridejZakaznika(zakaznik);
        evidence.pridejZakaznika(zakaznik2);

        List<Zakaznik> aktivniZakaznici = evidence.filtrovatPodleProdeju(20);
        System.out.println("Zákazníci s více než 20 prodeji:");
        for (Zakaznik z : aktivniZakaznici) {
            System.out.println(z);
        }

        double prumer = evidence.prumernyPocetProdeju("Uherské Hradiště");
        System.out.println("Průměrný počet prodejů v Uherském Hradišti: " + prumer);



    }

    public void odeberPoslenihoZakaznika() {

        EvidenceZakazniku evidence = new EvidenceZakazniku();
        evidence.odeberZakaznika(evidence.zakaznici.get(evidence.zakaznici.size() - 1));
    }

    public static void zapisZakaznikuDoSouboru(EvidenceZakazniku evidence) {
        String soubor = "src/soubor.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(soubor))) {
            for (Zakaznik zakaznik : evidence.zakaznici) {
                writer.write(zakaznik.getJmeno() + ";" + zakaznik.getDatumNarozeni() + ";" + zakaznik.getMesto() + ";" + zakaznik.getPocetProdeju());
                writer.newLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void nactiZakaznikyZeSouboru(EvidenceZakazniku evidence, String soubor) {
        evidence = new EvidenceZakazniku();
        String text = "src/text.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(text))) {
            String radek = reader.readLine();
            while (radek != null) {
                String[] zaznamy = radek.split(";");
                String jmeno = zaznamy[0];
                LocalDate datumNarozeni = LocalDate.parse(zaznamy[1]);
                String mesto = zaznamy[2];
                int pocetProdeju = Integer.parseInt(zaznamy[3]);
                evidence.pridejZakaznika(new Zakaznik(jmeno, datumNarozeni, mesto, pocetProdeju));
                radek = reader.readLine();
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);


        }

    }


}