import java.util.List;

public interface Command {
    public String run(List<String> args) throws CommandArgumentException;
}

class HelpCommand implements Command {
    @Override
    public String run(List<String> args) throws CommandArgumentException {
        if (args.size() != 0) {
            throw new CommandArgumentException("help", 0);
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
    public String run(List<String> args) throws CommandArgumentException {
        if (args.size() != 0) {
            throw new CommandArgumentException("exit", 0);
        }
        System.exit(0);

        return null;
    }
}

class DisplayCommand implements Command {
    @Override
    public String run(List<String> args) throws CommandArgumentException {
        if (args.size() < 1) {
            throw new CommandArgumentException("display", 1);
        }

        String output = String.join(" ", args);

        return output;
    }
}
