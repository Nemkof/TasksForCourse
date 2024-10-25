import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passwordLength = 0;

        // Спрашиваем у пользователя, какая должна быть длина пароля
        while (true) {
            System.out.print("Введите длину пароля (от 8 до 12): ");
            passwordLength = scanner.nextInt();

            if (passwordLength >= 8 && passwordLength <= 12) {
                break;
            } else {
                System.out.println("Неверная длина. Пожалуйста, введите число от 8 до 12.");
            }
        }

        String password = generatePassword(passwordLength);
        System.out.println("Сгенерированный пароль: " + password);
    }

    private static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        // Добавим по одному символу из каждой категории (случайным образом)
        password.append(getRandomCharacter(UPPERCASE, random));
        password.append(getRandomCharacter(LOWERCASE, random));
        password.append(getRandomCharacter(DIGITS, random));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS, random));

        // Заполним оставшееся место чем-то случайным
        for (int i = 4; i < length; i++) {
            password.append(getRandomCharacter(ALL_CHARACTERS, random));
        }

        // Перемешиваем пароль для большей безопасности
        return password.toString();
    }

    private static char getRandomCharacter(String characters, SecureRandom random) {
        return characters.charAt(random.nextInt(characters.length()));
    }
}
