package example;

import java.util.*;
import enumerate.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Mail9 {
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4}
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    private static long count = 0;
    private final long id = count++;
    public String toString() {
        return "Mail: " + this.id;
    }
    public String detail() {
        return this.toString() + ":\n" +
                "GeneralDelivery: " + this.generalDelivery + "\n" +
                "Scannability: " + this.scannability + "\n" +
                "Readability: " + this.readability + "\n" +
                "Address: " + this.address + "\n" +
                "ReturnAddress: " + this.returnAddress;
    }
    public static Mail9 randomMail() {
        Mail9 mail = new Mail9();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        return mail;
    }
    public static Iterable<Mail9> generator(final int count) {
        return new Iterable<Mail9>() {
            int n = count;
            public Iterator<Mail9> iterator() {
                return new Iterator<Mail9>() {
                    public boolean hasNext() {return n-- > 0;}
                    public Mail9 next() {
                        return randomMail();
                    }
                    public void remove() {throw new UnsupportedOperationException();}
                };
            }
        };
    }
}
interface Handler {
    abstract boolean handle(Mail9 mail);
}
public class PostOffice_Ex9 {
    enum MailHandler {GENERAL_DELIVERY, MACHINE_SCAN, VIDUAL_INSPECTION, RESEND_TO_SENDER}
    public static void handle(Mail9 mail, EnumMap<MailHandler, Handler> enumMap) {
        for (Map.Entry<MailHandler, Handler> entry : enumMap.entrySet()) {
            if (entry.getValue().handle(mail)) return;
        }
        System.out.println("This is a dead mail");
    }
    public static void main(String[] args) {
        EnumMap<MailHandler, Handler> enumMap = new EnumMap<MailHandler, Handler>(MailHandler.class);
        enumMap.put(MailHandler.GENERAL_DELIVERY, new Handler() {
            public boolean handle(Mail9 mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        System.out.println("Using Delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        });
        enumMap.put(MailHandler.MACHINE_SCAN, new Handler() {
            public boolean handle(Mail9 mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " automatic");
                                return true;
                        }
                }
            }
        });
        enumMap.put(MailHandler.VIDUAL_INSPECTION, new Handler() {
            public boolean handle(Mail9 mail) {
                switch (mail.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Deliverying " + mail + " nomarly");
                                return true;
                        }
                }
            }
        });
        enumMap.put(MailHandler.RESEND_TO_SENDER, new Handler() {
            public boolean handle(Mail9 mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Resending to sender");
                        return true;
                }
            }
        });
        for (Mail9 mail : Mail9.generator(5)) {
            System.out.println(mail.detail());
            PostOffice_Ex9.handle(mail, enumMap);
            System.out.println("--------");
        }
    }
}
