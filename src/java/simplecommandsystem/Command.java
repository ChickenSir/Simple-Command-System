import java.util.List;

public interface Command {
    public String run(List<String> args);
}

class HelpCommand implements Command {
    @Override
    public String run(List<String> args) {
        if (args.size() != 0) {
            return "[ERROR] Command 'help' takes no arguments";
        }

        String output = "==========[Command List]==========\n\n"
            + "help - Displays a list of commands\n"
            + "exit - Exits the program\n"
            + "display - Displays text\n"
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

class DisplayCommand implements Command {
    @Override
    public String run(List<String> args) {
        if (args.size() < 1) {
            return "[ERROR] Command 'display' takes at least one argument";
        }

        String output = String.join(" ", args);

        return output;
    }
}
