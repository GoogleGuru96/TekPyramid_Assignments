package TrainingProgs4;

public class LwrUpprSwch {
    public static void main(String[] args) {
        String input = "GooGle GuRu";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch); // keep other characters as-is
            }
        }

        System.out.println("Original String : " + input);
        System.out.println("Modified String : " + result.toString());
    }
}
