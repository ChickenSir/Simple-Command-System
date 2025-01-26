import java.util.List;

public interface Command {
    public String run(List<String> args);
}

class HelpCommand implements Command {
    @Override
    public String run(List<String> args) {
        String output = "test";

        return output;
    }
}
