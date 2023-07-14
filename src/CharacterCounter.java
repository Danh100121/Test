import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a string: ");
        String input = scanner.nextLine();
        scanner.close();


        if (isValidInput(input)) {
            int count = countVietnameseCharacters(input);
            System.out.println("Output: " + count);
        } else {
            System.out.println("Chuỗi nhập vào không hợp lệ.");
        }
    }

    public static int countVietnameseCharacters(String input) {
        Map<String, String> characterMap = createCharacterMap();

        int count = 0;
        int i = 0;

        while (i < input.length()) {
            String currentChar = Character.toString(input.charAt(i));
            if (characterMap.containsKey(currentChar)) {
                count++;
                i++;
            } else if (i < input.length() - 1) {
                String nextTwoChars = input.substring(i, i + 2);
                if (characterMap.containsKey(nextTwoChars)) {
                    count++;
                    i += 2;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return count;
    }

    private static Map<String, String> createCharacterMap() {
        Map<String, String> characterMap = new HashMap<>();
        characterMap.put("aw", "ă");
        characterMap.put("aa", "â");
        characterMap.put("dd", "đ");
        characterMap.put("ee", "ê");
        characterMap.put("oo", "ô");
        characterMap.put("ow", "ơ");
        characterMap.put("w", "ư");
        return characterMap;
    }
    private static boolean isValidInput(String input) {
        return input.matches("[a-zA-Z]+");
    }
}
