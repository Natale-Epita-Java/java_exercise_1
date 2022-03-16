import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");

        Scanner shell = new Scanner(System.in);

        List<Command> listCmd = Arrays.asList(new Quit(), new Fibo(), new Freq(), new Predict());

        boolean t = true;
        while (t) {
            String nextline = shell.nextLine();
            for (int i = 0; i < listCmd.size(); i++) {
                if (listCmd.get(i).name().equals(nextline.toLowerCase())) {
                    t = listCmd.get(i).run(shell);
                    break;
                } else if (i == listCmd.size() - 1) {
                    System.out.println("Unknown command");
                }
            }

            if (!t) {
                break;
            }

        }
    }
}