import java.util.Scanner;
import java.util.Random;

public class UsernameGenerator {

    // Replace vowels in a string with fun emoji-like characters
    public static String replaceVowels(String input) {
        return input.replaceAll("a", "@")
                    .replaceAll("e", "3")
                    .replaceAll("i", "!")
                    .replaceAll("o", "0")
                    .replaceAll("u", "µ")
                    .replaceAll("A", "@")
                    .replaceAll("E", "3")
                    .replaceAll("I", "!")
                    .replaceAll("O", "0")
                    .replaceAll("U", "µ");
    }

    // Reverse a string
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Capitalize first letter, lowercase rest
    public static String capitalize(String input) {
        if (input.length() == 0) return input;
        return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Creative Username & Hashtag Generator!");
        System.out.print("Enter your name or favorite word: ");
        String input = scanner.nextLine().trim();

        // Generate username parts
        String part1 = capitalize(input.length() > 3 ? input.substring(0, 3) : input);
        String part2 = capitalize(reverseString(input.length() > 2 ? input.substring(input.length()-2) : input));
        String mood = "";
        int moodScore = random.nextInt(100);

        // Mood based on random score
        if (moodScore < 30) mood = "🌙 Chill";
        else if (moodScore < 70) mood = "🔥 Energetic";
        else mood = "⚡ Electric";

        // Build username
        String username = part1 + part2 + moodScore;

        // Build hashtag with vowel replacement and emoji suffix
        String hashtagBase = replaceVowels(input.toLowerCase());
        String hashtag = "#" + hashtagBase + (random.nextBoolean() ? "✨" : "🚀");

        System.out.println("\n✨ Your Creative Username: " + username);
        System.out.println("🎯 Mood Rating: " + mood);
        System.out.println("🏷️ Hashtag: " + hashtag);

        scanner.close();
    }
}
