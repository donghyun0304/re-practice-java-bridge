package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Result {

    private final List<String> upBridge;
    private final List<String> downBridge;

    public Result(List<String> upBridge, List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    @Override
    public String toString() {
        return "Result{" +
                "upBridge=" + upBridge +
                ", downBridge=" + downBridge +
                '}';
    }

    public List<String> getUpBridge() {
        return Collections.unmodifiableList(upBridge);
    }

    public List<String> getDownBridge() {
        return Collections.unmodifiableList(downBridge);
    }
}
