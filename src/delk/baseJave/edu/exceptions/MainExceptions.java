package delk.baseJave.edu.exceptions;

public class MainExceptions {

    public static void main(String[] args) {
        // testException (new StringBuilder("JustText"));
        // sqrt (-10001);
        System.out.println(getCallerClassAndMethodName ());
        anotherMethod();
        System.out.println(sqrt1(-1000));
        System.out.println(sqrt(-1000));

    }
    private static void anotherMethod() {

        System.out.println(getCallerClassAndMethodName());
    }
    public static String getCallerClassAndMethodName() {
        Throwable throwable = new Throwable();
        StringBuilder buffer = new StringBuilder();
        if (throwable.getStackTrace().length < 3) { // if only 1 element or no elements, mean we called this from main..
            return (null);
        }
        StackTraceElement traceElement = throwable.getStackTrace()[2];
        buffer.append(traceElement.getClassName() + '#'+traceElement.getMethodName());
        return buffer.toString();
    }

    public static double sqrt (double x)  {
        if (x < 0) {
            throw new java.lang.IllegalArgumentException("First option: Expected non-negative number, got " + x);
        }
        return Math.sqrt(x) ;

    }
    public static double sqrt1 (double x)  {
        try {
            return sqrt(x);
        }
        catch (Throwable exception){
            //throw new java.lang.IllegalArgumentException("Second Option: Expected non-negative number, got " + x);
            System.out.println("Illegal Argument, got" + x);
        }
        finally{
            System.out.println("Finally I'm still here...");

        }
        return Double.NaN;

    }

    private static void testException(Object object) {

    int [] justArray = (int []) object;
    }
   /* public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) throw e;
            }
        }
    } */
}

