package bridge.command;

public enum BridgeMark {

    SUCCESS("O"),
    FAIL("X"),
    EMPTY("");

    private String mark;

    BridgeMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
