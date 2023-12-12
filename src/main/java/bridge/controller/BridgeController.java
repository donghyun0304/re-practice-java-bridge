package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.command.MoveCommand;
import bridge.command.TryCommand;
import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
//        System.out.println("initBridge = " + bridge);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.init();


        while(!bridgeGame.isEnd()){
            MoveCommand moveCommand = inputView.readMoving();
//        System.out.println(moveCommand);
            if(bridgeGame.move(moveCommand)){
                outputView.printMap(bridgeGame.getResult());
                continue;
            }
            outputView.printMap(bridgeGame.getResult());
            TryCommand tryCommand = inputView.readGameCommand();
            bridgeGame.retry(tryCommand);

        }

        if(bridgeGame.isEnd()){
            outputView.printResult(bridgeGame.getResult(), bridgeGame.isSuccess(), bridgeGame.getRetryCount());
        }




    }
}
