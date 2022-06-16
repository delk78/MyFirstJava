package delk.baseJave.edu.mail;

/**
 * Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
 * Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
 * Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость
 * всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки, которая пришла вору,
 * он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
 */
public class Thief implements MailService {
    private int minPrice;// minimal cost I want to steal;
    private int stolenValue;

    public Thief (int minPrice) {
        this.minPrice = minPrice;
        this.stolenValue = 0;
    }

    public int getStolenValue() {
        return stolenValue;
    }
    @Override
    public Sendable processMail (Sendable mail) {
        if (! (mail instanceof MailPackage ) ) return mail;
        Package thePackage = ((MailPackage) mail).getContent();
        System.out.println("Price is "+thePackage.getPrice() + ", while min price is " + this.minPrice);
        if  ( thePackage.getPrice() < this.minPrice ) return mail; //we don't steal if price is so low.

        this.stolenValue += thePackage.getPrice();
        return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of" + thePackage.getContent(), 0));
    }
}
