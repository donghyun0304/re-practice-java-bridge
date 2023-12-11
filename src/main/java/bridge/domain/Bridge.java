package bridge.domain;

import bridge.command.BridgeMark;

import java.util.Collections;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int bridgeSize(){
        return bridge.size();
    }

    public boolean isAbleMove(String command, int index){
        if(bridge.get(index).equals(command)){
            return true;
        }
        return false;
    }

    public void write(BridgeMark bridgeMark){
        bridge.add(bridgeMark.getMark());
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }
}
