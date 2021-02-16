package lab3;

public class Lab3 {
    public int[] convert(String string) {
        checkIsEmpty(string);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String lower = format(string);
        int[] result = getNumericValues(lower, alphabet);
        return result;
    }

    private int[] getNumericValues(String string, String alphabet) {
        int[] result = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (string.charAt(i) == alphabet.charAt(j)) {
                    result[i] = j + 1;
                }
            }
        }
        return result;
    }

    private String format(String string) {
        return string.trim().toLowerCase();
    }

    private void checkIsEmpty(String string) {
        if (string.isEmpty()) {
            System.out.println("String is empty");
            System.exit(-1);
        }
    }
}
