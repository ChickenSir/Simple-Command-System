import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandSystem {
    private static HashMap<String, Command> commandList = new HashMap<String, Command>() {{
        put("help", new HelpCommand());
    }};

    public static void main(String[] args) {
        Console console = System.console();

        while(true) {
            System.out.print("> ");
            String input = console.readLine();

            List<String> cmd = Arrays.asList(input.split(" ", 2));
            List<String> cmdArgs = (cmd.size() != 1) ? Arrays.asList(cmd.get(1).split(" ")) : new ArrayList<String>();
            Command cmdType = commandList.get(cmd.get(0));

            if (cmdType != null) {
                System.out.println(cmdType.run(cmdArgs));
            } else {
                System.out.println("[ERROR] Unknown command '" + cmd.get(0) + "'. Enter 'help' for a list of commands.");
            }
        }
    }
}
