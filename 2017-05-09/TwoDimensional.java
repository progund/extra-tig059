import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/* Exam question:
 * Skriv en metod som skriver ut veckoförsäljningen i en tabell.
 */
public class TwoDimensional {

  public static void main(String[] args) {
    /*
     * Let's use English names. OK?
     * And let's use the correct type of the array.
     * double veckoForsaljning [] is NOT a two dimensional array.
     * It is a ONE DIMENSIONAL array, so the exam question is
     * wrong and won't compile.
     *
     * We're going to use:
     * double weeklySales[][] as the type and name.
     *
     * On the other hand, the exam question states that
     * we can assume that there are exactly four weeks
     * in the array, so perhaps monthSales would be an even
     * better name? Who knows. There are however months with
     * not exactly four weeks, so...
     */
    double weeklySales[][] =
      {{61.34, 45.09, 761.01, 9836.34, 2145.65, 7423.34, 543.77},
       {23.3, 432534.2, 12312.2, 234423.2, 2312.5, 33.23, 33.32},
       {3.3, 43234.52, 1212.22, 2423.32, 232.55, 323.53, 3.99},
       {24.3, 42534.4, 122.32, 233.55, 232.99, 333.23, 233.25}
      };
    
    printWeeklySalesTable(weeklySales);

    // Let's try with an array of many weeks
    double weeklySales2[][] =
      {{61.34, 45.09, 761.01, 9836.34, 2145.65, 7423.34, 543.77},
       {23.3, 432534.2, 12312.2, 234423.2, 2312.5, 33.23, 33.32},
       {3.3, 4324.52, 1212.22, 2423.32, 232.55, 323.53, 3.99},
       {2.3, 434.52, 122.22, 223.32, 299.55, 325.53, 63.99},
       {1.3, 434.52, 1412.22, 2993.32, 222.55, 383.53, 33.99},
       {5.3, 44.52, 1262.22, 2523.32, 292.55, 453.53, 73.99},
       {54.3, 44.4, 172.32, 237.55, 272.99, 353.23, 933.25}
      };
    System.out.println("\n\nMore than four weeks:");
    printWeeklySalesTable(weeklySales2);
  }
  /* Let's use English names, as usual.
   * Let's use a descriptive name which actually describes
   * what this method does.
   *
   * Note that this method works, regardles of how many weeks
   * are inside the array of weeks.
   *
   * This method has a flaw, though. In the exam, the table
   * has boxes around each value. We haven't found the correct
   * unicode signs for producing these borders or boxes.
   *
   * Please ask the one who wrote the exam how to print
   * these borders/boxes from Java.
   */
  static void printWeeklySalesTable(double[][] weeklySales) {
    System.out.println(String.format("%-6s%11s%11s%11s%11s%11s%11s%11s%11s",
                                     "Vecka",
                                     "Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag",
                                     "Lördag", "Söndag",
                                     "Veckotal"));
    int weekNumber = 1;
    // Loop over all week arrays
    for(double[] weekSales : weeklySales) {
      System.out.print(String.format("%-6d", weekNumber++));
      double weekTotal=0.0;
      // Loop over all the sales in this week
      for(double sale : weekSales) {
        weekTotal += sale;
        System.out.print(formatSale(sale));
      }
      System.out.println(formatSale(weekTotal));
    }
  }
  
  /* Formats one double as ###,###.00 which means
   * first the whole number pad thousands with comma, then two digits
   * and pad with 0s.
   */
  static String formatSale(double sale) {
    String pattern = "###,###.00";
    String result = "";
    DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
    symbols.setGroupingSeparator(' ');
    DecimalFormat df = new DecimalFormat(pattern, symbols);
    result = df.format(sale);
    return String.format("%11s", result);
  }

  /*
Test run:
$ javac TwoDimensional.java && java TwoDimensional
Vecka      Måndag     Tisdag     Onsdag    Torsdag     Fredag     Lördag     Söndag   Veckotal
1           61.34      45.09     761.01   9 836.34   2 145.65   7 423.34     543.77  20 816.54
2           23.30 432 534.20  12 312.20 234 423.20   2 312.50      33.23      33.32 681 671.95
3            3.30  43 234.52   1 212.22   2 423.32     232.55     323.53       3.99  47 433.43
4           24.30  42 534.40     122.32     233.55     232.99     333.23     233.25  43 714.04


More than four weeks:
Vecka      Måndag     Tisdag     Onsdag    Torsdag     Fredag     Lördag     Söndag   Veckotal
1           61.34      45.09     761.01   9 836.34   2 145.65   7 423.34     543.77  20 816.54
2           23.30 432 534.20  12 312.20 234 423.20   2 312.50      33.23      33.32 681 671.95
3            3.30   4 324.52   1 212.22   2 423.32     232.55     323.53       3.99   8 523.43
4            2.30     434.52     122.22     223.32     299.55     325.53      63.99   1 471.43
5            1.30     434.52   1 412.22   2 993.32     222.55     383.53      33.99   5 481.43
6            5.30      44.52   1 262.22   2 523.32     292.55     453.53      73.99   4 655.43
7           54.30      44.40     172.32     237.55     272.99     353.23     933.25   2 068.04

  */
}
