package bridge.validation;

import bridge.domain.ErrorMessage;
import bridge.domain.RegexPattern;

public class InputValidator {

    public static void validateOnlyNumber(String input){
        if(!RegexPattern.ONLY_NUMBER.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_ALL_NUMERIC);
        }
    }

    public static void validateRangeNumber(int number){
        if(!(number >= 3 && number <= 20)){
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE);
        }
    }
}
