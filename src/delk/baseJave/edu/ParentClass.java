package delk.baseJave.edu;

/**
 * Experiments with classes inheritance
 */

public class ParentClass {
    public static int pubstat;
    private static int privstat;
    protected static int protstat;
    public int pubint;
    public ParentClass () {
        pubstat = 1;
        privstat = 2;
        protstat = 3;
        pubint = 4;
    }
    public String getName (){
       //return getClass().getName() +'@' +Integer.toHexString(hashCode()) + "manual";
        return toString();
    }
    public void printValues (){
        System.out.println("pubstat: "+pubstat);
        System.out.println("privstat: "+privstat);
        System.out.println("protstat: "+protstat);
        System.out.println("pubint: "+pubint);
    }
}
