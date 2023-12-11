package bridge.command;

import java.util.Arrays;

public enum TryCommand {

    RETRY("R"),
    END("Q");

    private String name;

    TryCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TryCommand findCommand(String tryCommand){
        return Arrays.stream(values())
                .filter(command -> command.name.equals(tryCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] R 또는 Q을 입력 해 주세요."));
    }
}
