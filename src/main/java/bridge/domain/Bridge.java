package bridge.domain;

import bridge.command.BridgeMark;
import bridge.command.MoveCommand;

import java.util.Collections;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getbridgeSize(){
        return bridge.size();
    }

    public boolean isAbleMove(MoveCommand command, int index){
        String bridgeMark = bridge.get(index);
        if(bridgeMark.equals(command.getName())){
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

    @Override
    public String toString() {
        return "Bridge{" +
                "bridge=" + bridge +
                '}';
    }

}
