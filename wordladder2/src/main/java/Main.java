import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WordLadder word = new WordLadder();
        String firstWord = "";
        String secondWord = "";
        while (!firstWord.equals("-1") && !secondWord.equals("-1")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第一个单词(-1 to quit)：");
            firstWord = sc.nextLine();
            if (firstWord.equals("-1")) {
                break;
            }
            System.out.println("请输入第二个单词(-1 to quit)：");
            secondWord = sc.nextLine();
            if (secondWord.equals("-1")) {
                break;
            }
            String result = word.dfs(firstWord, secondWord);
            System.out.println(result);
        }
        System.out.println("Have a nice day");

    }
}
