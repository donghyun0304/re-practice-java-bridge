package bridge;

import bridge.command.MoveCommand;
import bridge.domain.ErrorMessage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            addBridgeOnCondition(bridge, bridgeNumberGenerator.generate());
        }
        return bridge;
    }


    private void addBridgeOnCondition(List<String> bridge, int generatedNumber) {
        if (generatedNumber == 0) {
            bridge.add(MoveCommand.DOWN.getName());
            return;
        }
        if (generatedNumber == 1) {
            bridge.add(MoveCommand.UP.getName());
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_VALID_CONDITION);
    }
}
