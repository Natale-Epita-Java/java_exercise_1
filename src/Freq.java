import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner sc) {
        System.out.println("Entrer un fichier: ");
        String command = sc.nextLine();
        Path fichier = Paths.get(command);
        try {
            String thisLine = Files.readString(fichier);
            thisLine = thisLine.replaceAll("\\p{Punct}", "");
            thisLine = thisLine.replaceAll("( +)", " ").trim();
            thisLine = thisLine.toLowerCase();
            Scanner scanner = new Scanner(thisLine);
            while (scanner.hasNextLine()) {
                thisLine = scanner.nextLine();
                String[] tab = thisLine.split(" ");
                Map<String, Long> result = Arrays.stream(tab).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                Map<String, Long> finalMap = new LinkedHashMap<>();
                result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
                int size = finalMap.size();
                List<String> theList = new ArrayList(finalMap.keySet());
                for (int i = 0; i < size; i++) {
                    if (i < 3) {
                        System.out.print(theList.get(i) + " ");
                    }
                }
                System.out.print("\n");
                return true;
            }

        } catch (IOException e) {
            System.out.println("Fichier inconnu");
            return false;
        }

        return false;
    }
}
