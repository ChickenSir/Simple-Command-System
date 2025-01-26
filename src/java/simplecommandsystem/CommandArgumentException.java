public class CommandArgumentException extends Exception {
    public CommandArgumentException(String name, int num) {
        super("[ERROR] Command '" + name + "' takes " + num + " arguments");
    }
}
