package tts.lab;

public class AsciiChars {
    public static void printNumbers() {
        for (int i = 48; i <= 57; i++) System.out.print((char) i + " ");
    }

    public static void printUpperCaseLetters() {
        for (int i = 65; i <= 90; i++) System.out.print((char) i + " ");
    }

    public static void printLowerCaseLetters() {
        for (int i = 97; i <= 122; i++) System.out.print((char) i + " ");
    }
}