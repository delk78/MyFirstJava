package delk.baseJave.edu;

public final class ChildClass extends ParentClass {
    private final int childField     = 0;
    public ChildClass(){
        pubstat = 101;
       // privstat = 102; don't have access to that!
        protstat = 103;
        pubint = 104;
    }
    @Override //this annotation asks compiler to check if we really override parent method.
    public void printValues () {

        super.printValues();
        System.out.println("ChildField:" + childField);
    }
}
