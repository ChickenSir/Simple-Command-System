import java.io.Console;

public class CommandSystem {
    public static void main(String[] args) {
        Console console = System.console();

        while(true) {
            System.out.print("> ");
            String input = console.readLine();
        }
    }
}
