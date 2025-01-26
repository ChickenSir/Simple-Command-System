import java.util.List;

public interface Command {
    public String run(List<String> args);
}

class HelpCommand implements Command {
    @Override
    public String run(List<String> args) {
        if (args.size() != 0) {
            return "Command 'help' takes no arguments";
        }

        String output = "==========[Command List]==========\n\n"
            + "help - Displays a list of commands\n"
            + "exit - Exits the program\n"
            + "\n"
            + "============[Page 1/1]============";

        return output;
    }
}

class ExitCommand implements Command {
    @Override
    public String run(List<String> args) {
        System.exit(0);

        return null;
    }
}
