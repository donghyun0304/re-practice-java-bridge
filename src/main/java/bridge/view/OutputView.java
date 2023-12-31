package bridge.view;

import bridge.constant.Delimiter;
import bridge.domain.Bridge;
import bridge.domain.Result;

import java.sql.SQLOutput;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        List<String> upBridge = result.getUpBridge();
        List<String> downBridge = result.getDownBridge();
        printFormat(upBridge, downBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result, boolean isSuccess, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(result);
        printSuccess(isSuccess);
        printTryCount(tryCount);
    }

    private void printSuccess(boolean isSuccess){
        if(isSuccess){
            System.out.println("게임 성공 여부: " + "성공");
            return;
        }
        System.out.println("게임 성공 여부: " + "실패");
    }

    private void printTryCount(int tryCount){
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    private void printLeftVerticalBar(){
        System.out.print("[ ");
    }

    private void printRightVerticalBar(){
        System.out.print(" ]");
    }

    private void printFormat(List<String> upBridge, List<String> downBridge){
        printLeftVerticalBar();
        System.out.print(String.join(" " + Delimiter.VERTICAL + " ", upBridge));
        printRightVerticalBar();
        System.out.println();

        printLeftVerticalBar();
        System.out.print(String.join(" " + Delimiter.VERTICAL + " ", downBridge));
        printRightVerticalBar();
        System.out.println();
    }




}
