import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/* Skriv en metod som sänker priset på alla öl från
 * tillverkaren Dugges med 10% om pubben antingen är
 * Rover eller BrewDog.
 *
 * Metoden tar "vår ArrayList:a allOurBeer" som parameter
 * och returnerar hur många öl som fick nytt pris.
 *
 * Kommentar: Nej, metoden tar en List<BeerSeller> som
 * argument, och vi kan då anropa den med t ex vår lista
 * allOurBeer (som rimligen borde heta något annat eftersom
 * det inte är en lista med Öl utan en lista med BeerSeller).
 *
 * Kommentar 2 - klassen BeerSeller är väldigt konstig och
 * inte speciellt typisk. Det känns mer som en tabell i en
 * databas än som en typisk Java-klass. Det naturliga hade
 * varit en klass Beer och en klass Seller (eller Pub).
 * En Pub skulle då kunna ha en List<Beer> över sina ölsorter.
 * Klassen Beer skulle INTE känna till vilken Pub som säljer
 * den. Men om vi bortser från detta så finns det ett lösnings-
 * förslag nedan.
 *
 * Kommentar 3 - man skulle i ett riktigt system inte använda
 * double för price, då flyttal i Java inte har så hög precision.
 * Man skulle använda BigDecimal men det har vi inte lärt ut.
 *
 * Kommentar 4 - man skulle inte använda ArrayList rakt av, utan
 * använda List så som vi använder det nedan.
 *
 * Lösningsförslag är static int newPrice(List<BeerSeller>)
 * nedan.
 *
 * Bonuslösningsförslag: 
 * int newPrice(List<BeerSeller>, Predicate<BeerSeller>)
 * Använder det funktionella interface:et Predicate<T>
 * Så att vi kan använda samma metod för att sänka pris
 * på fler kriterier. Anropas med lambdauttryck.
 *
 * Kommentar: Det vore ännu bättre om vi kunde skicka in som
 * argument även prisförändringen i procent eller så.
 */
public class BeerSeller {

  private String pub;
  private String manufacturer;
  private String beerName;
  private double price;

  public BeerSeller(String pub, String manufacturer,
                    String beerName, double price) {
    this.pub = pub;
    this.manufacturer = manufacturer;
    this.beerName = beerName;
    this.price = price;
  }

  public String pub() { return pub; }
  public String manufacturer() { return manufacturer; }
  public String beerName() { return beerName; }
  public double price() { return price; }

  public void changePrice(double newPrice) {
    // Ideally, we'd have some sanity check here
    // and throw IllegalArgumentException if the
    // new price seems off.
    price = newPrice;
  }
  @Override
  public String toString() {
    return new StringBuilder(pub)
      .append(", ")
      .append(manufacturer)
      .append(", ")
      .append(beerName)
      .append(", ")
      .append(String.format("%.2f", price))
      .append(" kr")
      .toString();
  }
}

class TestBeerSeller {
  static int newPrice(List<BeerSeller> sellers) {
    int count = 0;
    /* Loop through all beer sellers, and if
       the current seller has manufacturer Dugges
       AND pub is (either Rover or BrewDog), 
       then lower the price with 10% */
    for (BeerSeller seller : sellers) {
      if(seller.manufacturer().equals("Dugges") &&
         (seller.pub().equals("Rover") ||
          seller.pub().equals("BrewDog"))) {
        seller.changePrice(seller.price()*0.9);
        count++;
      }
    }
    return count;
  }

  static int newPrice(List<BeerSeller> sellers, Predicate<BeerSeller> pred) {
    int count = 0;
    /* Loop through all beer sellers, and if
       the current seller has manufacturer Dugges
       AND pub is (either Rover or BrewDog), 
       then lower the price with 10% */
    for (BeerSeller seller : sellers) {
      if(pred.test(seller)) {
        seller.changePrice(seller.price()*0.9);
        count++;
      }
    }
    return count;
  }
  
  public static void main(String[] args) {
    List<BeerSeller> allOurBeer = getSellers();
    System.out.println(allOurBeer);
    System.out.println(newPrice(allOurBeer) + " sellers changed");
    System.out.println(allOurBeer);

    System.out.println("=========Using predicate===========");
    allOurBeer = getSellers();
    System.out.println(allOurBeer);
    System.out.println(newPrice(allOurBeer, (seller)-> {
          return seller.manufacturer().equals("Dugges") &&
            (seller.pub().equals("Rover") || seller.pub().equals("BrewDog"));
            }) + " sellers changed");
    System.out.println(allOurBeer);
    
  }
  
  static List<BeerSeller>getSellers() {
    List<BeerSeller> sellers = new ArrayList<>();
    sellers.add(new BeerSeller("Rover", "Dugges", "Dugges tönt-ipa", 30.0));
    sellers.add(new BeerSeller("Rover", "Dugges", "Dugges Fixed-steering DIPA", 40.0));
    sellers.add(new BeerSeller("Rover", "Pripps", "Ett skepp i nöd", 30.0));
    sellers.add(new BeerSeller("BrewDog", "Dugges", "Dugges stor stark", 30.0));
    sellers.add(new BeerSeller("BrewDog", "Dugges", "Dugges tönt-ipa", 30.0));
    sellers.add(new BeerSeller("BrewDog", "Spendrups", "Old Gold", 30.0));
    sellers.add(new BeerSeller("DaMario", "Dugges", "PIPA", 30.0));
    sellers.add(new BeerSeller("Golden Days", "Dugges", "Dugges tönt-ipa", 30.0));
    return sellers;
  }

  /* Example run:
$ javac BeerSeller.java && java TestBeerSeller
[Rover, Dugges, Dugges tönt-ipa, 30.00 kr, Rover, Dugges, Dugges Fixed-steering DIPA, 40.00 kr, Rover, Pripps, Ett skepp i nöd, 30.00 kr, BrewDog, Dugges, Dugges stor stark, 30.00 kr, BrewDog, Dugges, Dugges tönt-ipa, 30.00 kr, BrewDog, Spendrups, Old Gold, 30.00 kr, DaMario, Dugges, PIPA, 30.00 kr, Golden Days, Dugges, Dugges tönt-ipa, 30.00 kr]
4 sellers changed
[Rover, Dugges, Dugges tönt-ipa, 27.00 kr, Rover, Dugges, Dugges Fixed-steering DIPA, 36.00 kr, Rover, Pripps, Ett skepp i nöd, 30.00 kr, BrewDog, Dugges, Dugges stor stark, 27.00 kr, BrewDog, Dugges, Dugges tönt-ipa, 27.00 kr, BrewDog, Spendrups, Old Gold, 30.00 kr, DaMario, Dugges, PIPA, 30.00 kr, Golden Days, Dugges, Dugges tönt-ipa, 30.00 kr]
   */
}
