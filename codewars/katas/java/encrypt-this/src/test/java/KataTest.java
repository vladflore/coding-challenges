import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {
    @Test
    public void fixedTests() {
        assertEquals("", Kata.encryptThis(""));
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", Kata.encryptThis("A wise old owl lived in an oak"));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", Kata.encryptThis("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", Kata.encryptThis("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", Kata.encryptThis("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", Kata.encryptThis("Thank you Piotr for all your help"));
    }

    @Test
    public void randomTests() {
        String ri;
        for (int i = 0; i < 100; i++) {
            ri = randomInput();
            assertEquals(solution(ri), Kata.encryptThis(ri));
        }
    }

    private Random rnd = new Random();
    private String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int length = alphabet.length();

    private String randomWord() {
        int wordLength = 1 + rnd.nextInt(20);
        char[] randomChars = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            randomChars[i] = alphabet.charAt(rnd.nextInt(length));
        }
        return new String(randomChars);
    }

    private String randomInput() {
        return String.join(" ", IntStream.range(0, 50).mapToObj(i -> randomWord()).collect(Collectors.toList()));
    }


    private String solution(String text) {
        return Arrays.stream(text.split(" "))
                .map(this::encryptWord)
                .collect(Collectors.joining(" "));
    }

    private String encryptWord(String word) {
        if (word.equals("")) {
            return word;
        }

        char[] cs = word.toCharArray();
        String fs = String.valueOf((int) cs[0]);

        if (word.length() == 1) {
            return fs;
        }

        char t = cs[1];
        cs[1] = cs[cs.length - 1];
        cs[cs.length - 1] = t;

        return fs + new String(Arrays.copyOfRange(cs, 1, cs.length));
    }
}