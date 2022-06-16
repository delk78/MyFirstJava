package delk.baseJave.edu.files;

import java.io.InputStream;
import java.io.StringReader;
import java.util.Locale;
import java.util.Scanner;
public class MainIO {
    public static void main(String[] args) {
        double sum = 0;

        try (Scanner scanner = new Scanner(System.in) ) {
            scanner.useDelimiter(" |\\n");
            scanner.useLocale(Locale.forLanguageTag("en"));
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    sum += scanner.nextDouble();
                }
                else {
                    System.out.println("Not double!: "+ scanner.next());
                }
            }
        }
        System.out.printf("%.6f", sum);
    }
}