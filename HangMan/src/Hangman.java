import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS =
            {"java", "programming", "hangman", "development", "challenge"};

    // Количество жизней
    private static final int MAX_LIVES = 6;

    public static void main(String[] args) {
        Random random = new Random();
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        StringBuilder guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));
        int livesCounter = MAX_LIVES;

        // Массив с 26 флагами. Если мы пытаемся угадать букву, то помечаем ее "true",
        // Чтобы не потом повторяться в выборе букв
        boolean[] guessedLetters = new boolean[26];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру 'Виселица'!");

        // Пока у нас есть жизни и буквы, которые еще не отгаданы, игра должна продолжаться
        while (livesCounter > 0 && guessedWord.toString().contains("_")) {
            System.out.println("Загаданное слово: " + guessedWord);
            System.out.println("Осталось жизней: " + livesCounter);
            System.out.print("Введите букву: ");
            char guess = scanner.next().charAt(0);

            // Проверка на уже угаданную букву
            // Если по этому индексу стоит true, значит мы уже выбирали эту букву
            if (guessedLetters[guess - 'a']) {
                System.out.println("Вы уже вводили эту букву. Попробуйте другую.");
                continue;
            }
            guessedLetters[guess - 'a'] = true;

            // Проверка, есть ли буква в слове
            if (wordToGuess.indexOf(guess) >= 0) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord.setCharAt(i, guess);
                    }
                }
            } else {
                livesCounter--;
                System.out.println("Неверно! Буквы нет в слове.");
            }
        }

        // Конец игры
        if (guessedWord.toString().equals(wordToGuess)) {
            System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
        } else {
            System.out.println("Вы проиграли! Загаданное слово было: " + wordToGuess);
        }

        scanner.close();
    }
}
