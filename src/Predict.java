import java.util.Scanner;

public class Predict implements Command {
    @Override
    public String name() {
        return "predict";
    }
    @Override
    public boolean run(Scanner sc) {
        System.out.println("the internet tend to using lorem ipsum is that a search for lorem ipsum is that a search for lorem");
        return true;
    }
}
