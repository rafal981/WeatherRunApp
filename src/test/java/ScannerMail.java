import java.util.Scanner;

public class ScannerMail extends MailValidator {
    public String yourMailAddress;
    public String yourMailPassword;
    public String anotherMailAddress;

    public String getYourMailAddress() {
        return yourMailAddress;
    }

    public void setYourMailAddress(String yourMailAddress) {
        this.yourMailPassword = yourMailAddress;
    }

    public String getYourMailPassword() {
        return yourMailPassword;
    }

    public void setYourMailPassword(String yourMailPassword) {
        this.yourMailPassword = yourMailPassword;
    }

    public String getAnotherMailAddress() {
        return anotherMailAddress;
    }

    public void setAnotherMailAddress(String anotherMailAddress) {
        this.anotherMailAddress = anotherMailAddress;
    }

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Podaj adres mailowy, z którego chcesz wysłać wiadomość");
            yourMailAddress = scanner.nextLine();

            if (!isValidEmail(yourMailAddress)) {
                System.out.println("Nieprawidłowy adres e-mail.");
            }
        } while (!isValidEmail(yourMailAddress));

                System.out.println("Podaj hasło do tego maila");
            yourMailPassword = scanner.nextLine();

            do {
                System.out.println("Podaj adres mailowy osoboy do której chcesz wysłać wiadomość");
                anotherMailAddress = scanner.nextLine();

                if (!isValidEmail(anotherMailAddress)) {
                    System.out.println("Nieprawidłowy adres e-mail.");
                }
            } while (!isValidEmail(anotherMailAddress)) ;
        }
    }