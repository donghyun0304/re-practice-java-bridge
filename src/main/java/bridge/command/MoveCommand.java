package bridge.command;

import java.util.Arrays;

public enum MoveCommand {
    UP("U"),
    DOWN("D");

    private String name;

    MoveCommand(String name) {
        this.name = name;
    }

    public static MoveCommand findCommand(String moveCommand){
        return Arrays.stream(values())
                .filter(command -> command.name.equals(moveCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] U 또는 D을 입력 해 주세요."));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MoveCommand{" +
                "name='" + name + '\'' +
                '}';
    }
}
