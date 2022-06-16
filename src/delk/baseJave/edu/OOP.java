package delk.baseJave.edu;
import static java.lang.System.*; //use all classes from this package w/o prefix....
/**
 * package for stepic training
 */
public final class OOP {    //final means no inheritance allowed...Can be only one root public class in one java file.
    /**
     * Class for 3.x part of the training
     */
    public static final int CONST_VALUE = 0x80000;
    private final int constValue; //final means this value can be only set once - here or(!) in constructor
    protected static int protectedValue;// accessible in same package and for inherited classes
    int defaultValue; //accessible in in same package.
// about private and protected - https://javarush.ru/groups/posts/1988-modifikatorih-dostupa-private-protected-default-public
    public OOP (int value){
        this.constValue = value;
    }

}
