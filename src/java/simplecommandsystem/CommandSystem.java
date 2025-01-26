import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandSystem {
    private static HashMap<String, Command> commandList = new HashMap<String, Command>() {{
        put("help", new HelpCommand());
        put("exit", new ExitCommand());
        put("display", new DisplayCommand());
    }};

    public static void main(String[] args) {
        Console console = System.console();

        while(true) {
            // Get input from the user
            System.out.print("> ");
            String input = console.readLine();

            // Split input into command name and arguments
            List<String> cmd = Arrays.asList(input.split(" ", 2));
            List<String> cmdArgs = (cmd.size() != 1) ? Arrays.asList(cmd.get(1).split(" ")) : new ArrayList<String>();

            // Get command from command list
            Command cmdType = commandList.get(cmd.get(0));

            if (cmdType != null) {
                // Run command from command list with arguments
                System.out.println(cmdType.run(cmdArgs));
            } else {
                // Display error if command does not exist
                System.out.println("[ERROR] Unknown command '" + cmd.get(0) + "'. Enter 'help' for a list of commands.");
            }
        }
    }
}
