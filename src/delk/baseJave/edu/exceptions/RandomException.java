package delk.baseJave.edu.exceptions;

import java.util.Random;

public class RandomException extends Random {
    public void throwRandomly ( Throwable e, String msg) throws Throwable {
        if ( super.nextBoolean() ) {
            throw e;
        } else {
            System.out.println(msg);
        }
    }

}
