package bridge.view;

import bridge.command.MoveCommand;
import bridge.command.TryCommand;
import bridge.util.RetryUtil;
import bridge.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return RetryUtil.getInput(() -> {
            System.out.println("다리의 길이를 입력해주세요.");
            String input = Console.readLine();
            //검증
            InputValidator.validateOnlyNumber(input);
            InputValidator.validateRangeNumber(Integer.parseInt(input));
            return Integer.parseInt(input);
        });
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MoveCommand readMoving() {
        return RetryUtil.getInput(() -> {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = Console.readLine();
            return MoveCommand.findCommand(input);
        });
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public TryCommand readGameCommand() {
        return RetryUtil.getInput(() -> {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String input = Console.readLine();
            return TryCommand.findCommand(input);
        });
    }
}
