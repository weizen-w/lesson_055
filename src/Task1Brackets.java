import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task1Brackets {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    boolean correct = checkBrackets(line);
    System.out.println(correct);
  }

  public static boolean checkBrackets(String brackets) {
    Deque<Character> openedBrackets = new ArrayDeque<>();
    for (int i = 0; i < brackets.length(); ++i) {
      char c = brackets.charAt(i);
      switch (c) {
        case '(', '{', '[', '<' -> openedBrackets.offerLast(c);
        case ')', '}', ']', '>' -> {
          Character opened = openedBrackets.pollLast();
          if (opened == null ||
              c == ')' && opened != '(' ||
              c == '}' && opened != '{' ||
              c == ']' && opened != '[' ||
              c == '>' && opened != '<') {
            return false;
          }
        }
        default -> {
        }
      }
    }
    return openedBrackets.isEmpty();
  }
}
