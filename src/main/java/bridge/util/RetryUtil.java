package bridge.util;

import java.util.function.Supplier;

public class RetryUtil {

    public static <T> T getInput(Supplier<T> inputSupplier){
        while(true){
            try{
                return inputSupplier.get();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
