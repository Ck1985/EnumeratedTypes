package example;

import containers.Unsupported;
import enumerate.*;

import java.util.Iterator;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Mail8 {
    enum Scannability {
        UNSCANNABLE, YES1,YES2, YES3, YES4
    }
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }
    enum Readability {
        ILLEGIBLE, YES1, YES2, YES3, YES4
    }
    enum Address {
        INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
    }
    enum ReturnAddress {
        MISSING, OK1, OK2, OK3, OK4, OK5
    }
    enum Forwardability {
        UNFORWARDABLE, OK1, OK2, OK3, OK4
    }
    Scannability scannability;
    GeneralDelivery generalDelivery;
    Readability readability;
    Forwardability forwardability;
    Address address;
    ReturnAddress returnAddress;
    static long count = 0;
    long id = count++;
    public String toString() {
        return "Mail: " + this.id;
    }
    public String detail() {
        return toString() +
                "GeneralDelivery: " + this.generalDelivery + "\n" +
                "Scannable: " + this.scannability + "\n" +
                "Readability: " + this.readability + "\n" +
                "Address: " + this.address + "\n"+
                "ReturnAddress: " + this.returnAddress;
    }
    public static Mail8 randomMail() {
        Mail8 mail = new Mail8();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        mail.forwardability = Enums.random(Forwardability.class);
        return mail;
    }
    public static Iterable<Mail8> generator(final int count) {
        return new Iterable<Mail8>() {
            int n = count;
            public Iterator<Mail8> iterator() {
                return new Iterator<Mail8>() {
                    public boolean hasNext() {return n-- > 0;}
                    public Mail8 next() {
                        return randomMail();
                    }
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
class PostOffice8 {
    enum MailHandler {
        GENERAL_DELIVERY {
            public boolean handle(Mail8 mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        System.out.println("Using Delivery for: " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCANNA {
            public boolean handle(Mail8 mail) {
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
        },
        VIDUAL_INSPECTION {
            public boolean handle(Mail8 mail) {
                switch (mail.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " nomarly");
                                return true;
                        }
                }
            }
        },
        RESEND_TO_SENDER {
            public boolean handle(Mail8 mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Resending mail");
                        return true;
                }
            }
        },
        FORWARDING_ANOTHER {
            public boolean handle(Mail8 mail) {
                switch (mail.forwardability) {
                    case UNFORWARDABLE:
                        return false;
                    default:
                        System.out.println("Forwarded mail");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail8 mail);
    }
    public static void handle(Mail8 mail) {
        for (MailHandler mh : MailHandler.values()) {
            if (mh.handle(mail)) {
                return;
            }
        }
        System.out.println("It's a dead mail");
    }
}
public class Example_8 {
    public static void main(String[] args) {
        for (Mail8 mail : Mail8.generator(8)) {
            System.out.println(mail.detail());
            PostOffice8.handle(mail);
            System.out.println("---------");
        }
    }
}
