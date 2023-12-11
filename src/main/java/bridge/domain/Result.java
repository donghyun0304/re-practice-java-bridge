package bridge.domain;

import java.util.List;

public class Result {

    private final List<String> upBridge;
    private final List<String> downBridge;

    public Result(List<String> upBridge, List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    
}
