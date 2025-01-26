import java.io.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandSystem {
    private static HashMap<String, Command> commandList = new HashMap<String, Command>() {{
        put(null, null);
    }};

    public static void main(String[] args) {
        Console console = System.console();

        while(true) {
            System.out.print("> ");
            String input = console.readLine();

            List<String> cmd = Arrays.asList(input.split(" ", 2));
            List<String> cmdArgs = Arrays.asList(cmd.get(1).split(" "));
            Command cmdType = commandList.get(cmd.get(0));

            cmdType.run(cmdArgs);
        }
    }
}
