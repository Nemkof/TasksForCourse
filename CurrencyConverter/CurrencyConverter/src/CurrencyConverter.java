import java.util.Scanner;

public class CurrencyConverter {
    // Константы для курсов валют
    private static final double RUB_TO_EUR = 0.009541;
    private static final double RUB_TO_USD = 0.010345;
    private static final double RUB_TO_CNY = 0.07407;
    private static final double RUB_TO_KZT = 5.02;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в российских рублях (RUB): ");
        double amountInRUB = scanner.nextDouble();

        System.out.println("Конвертируемая сумма: " + amountInRUB + " USD");
        System.out.printf("Сумма в евро (EUR): %.2f EUR%n", convertToEUR(amountInRUB));
        System.out.printf("Сумма в долларах США (USD): %.2f USD%n", convertToUSD(amountInRUB));
        System.out.printf("Сумма в китайских юанях (CNY): %.2f CNY%n", convertToCNY(amountInRUB));
        System.out.printf("Сумма в казахстанских тенге (KZT): %.2f KZT%n", convertToKZT(amountInRUB));

        scanner.close();
    }

    private static double convertToEUR(double amount) {
        return amount * RUB_TO_EUR;
    }

    private static double convertToUSD(double amount) {
        return amount * RUB_TO_USD;
    }

    private static double convertToCNY(double amount) {
        return amount * RUB_TO_CNY;
    }

    private static double convertToKZT(double amount) {
        return amount * RUB_TO_KZT;
    }
}
