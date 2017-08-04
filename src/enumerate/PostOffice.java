package enumerate;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Mail {
    enum GeneralDelivery {YES,NO1, NO2, NO3, NO4, NO5}
    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;
    public String toString() {
        return "Mail: " + this.id;
    }
    public String details() {
        return this.toString() + ": \n" +
                "GeneralDelivery: " + this.generalDelivery + "\n" +
                "Scannable: " + this.scannability + "\n" +
                "Readability: " + this.scannability + "\n" +
                "Address: " + this.address + "\n" +
                "ReturnAddress: " + this.returnAddress;
    }
    public static Mail randomMail() {
        Mail mail = new Mail();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        return mail;
    }
    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    public boolean hasNext() {return n-- > 0;}
                    public Mail next() {return randomMail();}
                    public void remove() {throw new UnsupportedOperationException();}
                };
            }
        };
    }
}
public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            public boolean handle(Mail mail) {
                switch(mail.generalDelivery) {
                    case YES:
                        System.out.println("Using delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            public boolean handle(Mail mail) {
                switch(mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch(mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " automatic");
                                return true;
                        }
                }
            }
        },
        VIDUAL_INSPECTION {
            public boolean handle(Mail mail) {
                switch(mail.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " normaly");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            public boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + mail + " to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail mail);
    }
    static void handle(Mail mail) {
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handle(mail)) {
                return;
            }
        }
        System.out.println(mail + " is a dead letter");
    }
    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*********");
        }
    }
}
