package bridge;

import bridge.command.BridgeMark;
import bridge.command.MoveCommand;
import bridge.command.TryCommand;
import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import bridge.domain.Result;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge gameBridge;
    private Bridge upBridge;
    private Bridge downBridge;
    private int moveCount;
    private int retryCount;
    private GameStatus gameStatus;

    public BridgeGame(Bridge gameBridge) {
        this.gameBridge = gameBridge;
    }

    public void init(){
        upBridge = new Bridge(new ArrayList<String>());
        downBridge = new Bridge(new ArrayList<String>());
        moveCount = 0;
        retryCount = 1;
        gameStatus = GameStatus.CONTINUE;
    }



    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(MoveCommand moveCommand) {
        boolean ableMove = gameBridge.isAbleMove(moveCommand.getName(), this.moveCount);
        if(ableMove){
            if(moveCommand.getName().equals("U")){
                upBridge.write(BridgeMark.SUCCESS);
                downBridge.write(BridgeMark.EMPTY);
            }
            if(moveCommand.getName().equals("D")){
                upBridge.write(BridgeMark.EMPTY);
                downBridge.write(BridgeMark.SUCCESS);
            }
            this.moveCount++;
            return true;
        }
        if(!ableMove){
            if(moveCommand.getName().equals("U")){
                upBridge.write(BridgeMark.FAIL);
                downBridge.write(BridgeMark.EMPTY);
            }
            if(moveCommand.getName().equals("D")){
                upBridge.write(BridgeMark.EMPTY);
                downBridge.write(BridgeMark.FAIL);
            }
            this.moveCount++;
            gameStatus = GameStatus.END;
            return false;
        }
        throw new IllegalStateException("[ERROR] 코드를 확인 해 주세요.");
    }

    public Result getResult(){
        return new Result(upBridge.getBridge(), downBridge.getBridge());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(TryCommand tryCommand) {
        if(tryCommand == TryCommand.RETRY){
            return true;
        }
        if(tryCommand == TryCommand.END){
            return false;
        }
        throw new IllegalStateException("[ERROR] 코드를 확인 해 주세요.");
    }

    public boolean isEnd(){
        if(gameStatus == GameStatus.END){
            return true;
        }
        if(gameStatus == GameStatus.CONTINUE){
            return false;
        }
        throw new IllegalStateException("[ERROR] 코드를 확인 해 주세요.");
    }
}
