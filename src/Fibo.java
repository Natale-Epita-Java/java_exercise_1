import java.util.Scanner;

public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner sc) {
        System.out.println("Veuillez entrer votre nombre: ");
        String line = sc.nextLine();
        try {
            int nb = Integer.parseInt(line);
            int i = 1;
            int j = 1;
            for (int k = 2; k < nb; k++) {
                int temp = i + j;
                i = j;
                j = temp;
            }
            System.out.println(j);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Il fallait rentrer un nombre");
            return false;
        }

    }

}

