public class CaesarCipher {
//This class encrypts a Caesar Cipher which is then used to decrypt in the main class. 
        public static String encrypt (String input, int key){

            StringBuilder encrypted = new StringBuilder(input);
            String uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
            String shiftedAlphabetUppercase = uppercaseAlphabet.substring(key) + uppercaseAlphabet.substring(0, key);
            String shiftedAlphabetLowercase = lowercaseAlphabet.substring(key) + lowercaseAlphabet.substring(0, key);

            for (int i = 0; i < encrypted.length(); i++){
                char currentChar = encrypted.charAt(i);
                if (currentChar == Character.toUpperCase(currentChar)){
                    int index = uppercaseAlphabet.indexOf(currentChar);
                    if (index != -1){
                        char newChar = shiftedAlphabetUppercase.charAt(index);
                        encrypted.setCharAt(i, newChar);
                    }
                }
                else {
                    int index = lowercaseAlphabet.indexOf(currentChar);
                    if (index != -1) {
                        char newChar = shiftedAlphabetLowercase.charAt(index);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
            return encrypted.toString();
        }
}
