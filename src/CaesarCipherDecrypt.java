public class CaesarCipherDecrypt {
 
    //The method to count how many times each letter occurs in a message.
    public static int[] countLetters(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }

    //Return the index of the largest value rather than the value itself.
    public static int maxIndex(int[] vals) {
        int maxIndex = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] > vals[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    // First approach (README.md)
    public static String decrypt(String encrypted) {
        CaesarCipher message = new CaesarCipher();
        int[] frequency = countLetters(encrypted);
        int maxIndex = maxIndex(frequency);
        int distanceKey = maxIndex - 4;
        if (maxIndex < 4) {
            distanceKey = 26 - (4 - maxIndex);
        }
        return message.encrypt(encrypted, 26 - distanceKey);
    }

    //Second approach (README.md)
    public static String chiSquareMethod(String message) {
        CaesarCipher cc = new CaesarCipher();
        double[] Ei = {2.53177, 0.46252, 0.86242, 1.31843, 3.93762, 0.69068,
                0.62465, 1.88914, 2.16876, 0.04743, 0.23932, 1.24775,
                0.74576, 2.09219, 2.32717, 0.59799, 0.02945, 1.85597,
                1.96137, 2.80736, 0.85498, 0.30318, 0.73160, 0.04650,
                0.61194, 0.02294};
        String[] messages = new String[26];
        double[] results = new double[26];
        for (int i = 1; i <= 26; i++) {
            String result = cc.encrypt(message, i);
            messages[i - 1] = result;
            int[] Oi = countLetters(result);
            double formulaResults[] = new double[26];
            for (int j = 0; j < 26; j++) {
                double x = Oi[j];
                double y = Ei[j];
                formulaResults[j] = Math.pow(x - y, 2) / y;
            }
            for (int k = 0; k < 26; k++) {
                results[i - 1] += formulaResults[k];
            }
        }
        double currentValue = results[0];
        int solutionIndex = 0;
        for (int z = 0; z < 26; z++) {
            if (currentValue > results[z]) {
                currentValue = results[z];
                solutionIndex = z;
            }
        }

        return messages[solutionIndex].toString();
    }

    public static void main(String[] args) {
        //Place the encrypted message in the " " and then run the code.

        //First approach.
        System.out.println(decrypt(""));

        //Second approach.
        System.out.println(chiSquareMethod(""));

    }
}
