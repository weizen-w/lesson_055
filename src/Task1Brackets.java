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
        case '(':
        case '{':
        case '[':
        case '<':
          openedBrackets.offerLast(c);
          break;
        case ')': {
          Character opened = openedBrackets.pollLast();
          if (opened == null || !opened.equals('(')) {
            return false;
          }
          break;
        }
        default:
          break;
      }
    }
    return openedBrackets.isEmpty();
  }
}
