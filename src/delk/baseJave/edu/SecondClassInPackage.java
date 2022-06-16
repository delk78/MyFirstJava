package delk.baseJave.edu;

public class SecondClassInPackage {
    public static void main(String[] args) {
        /*Days day = Days.MON; //так инициализируются енумы.
        System.out.println(day);
        printEnum();*/

        /* ParentClass pObject = new ParentClass();
        System.out.println(pObject.getName());
        pObject.printValues();
        ChildClass cObject = new ChildClass();
        cObject.printValues();*/
        testComplex();
    }
    public SecondClassInPackage() { // это конструктор
        OOP oop = new OOP(20);
        OOP.protectedValue = 0; //only static can be addressed.
    }

    public enum Days {
        MON,
        TUE,
        WEN,
        THU,
        FRI,
        SAT,
        SUN
    }

    public static void printEnum() {
        for (Days d : Days.values()) {
            int a = -1;
            int b = Math.abs(a);
            System.out.println(d.ordinal() + " " + d.name() );
        }

    }
    private static void testComplex() {
        ComplexNumber cn1 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn2 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn3 = new ComplexNumber(7.2434,2.3412);
        System.out.println("equals cn1 & cn2 true // " + cn1.equals(cn2));
        System.out.println("equals cn2 & cn1 true // " + cn2.equals(cn1));
        System.out.println("equals cn2 & cn3 false // " + cn2.equals(cn3));
        System.out.println("equals cn3 & cn1 false // " + cn3.equals(cn1));
        System.out.println("hash cn1 & cn2 true // " + (cn1.hashCode() == cn2.hashCode()));
        System.out.println("hash cn2 & cn1 true // " + (cn2.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn1 false // " + (cn3.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn2 false // " + (cn3.hashCode() == cn2.hashCode()));
    }

}