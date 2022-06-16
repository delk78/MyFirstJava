package delk.baseJave.edu.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readCollection {
    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if ( scanner.hasNextInt() ) buffer.add(scanner.nextInt());
            else scanner.next();
        }
        // trivial way:
        for (int i = buffer.size()-1; i >=0 ; i--) {
           if (i%2 == 1) System.out.print(buffer.get(i).toString() + " ");
        }
    }
}
