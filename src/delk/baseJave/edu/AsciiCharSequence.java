package delk.baseJave.edu;

import java.util.Arrays;

public class AsciiCharSequence implements java.lang.CharSequence {
    private final byte[] bytes;
    private final int length;
    public  AsciiCharSequence ( byte[] theBytes) {
        length = theBytes.length;
        // this.bytes = new byte[theBytes.length]; можно было и так, и потом цикл инициализации
        this.bytes = theBytes.clone(); //но так короче Ж)

    }

    @Override
    public int length () {
        return  this.length;
    }
    @Override
    public char charAt (int index) {
        return (char) bytes[index] ;
    }
    @Override
    public AsciiCharSequence subSequence(int start, int end) {

        /* byte [] buffer = new byte[end-start];
        for (int i = start; (i < end) && (i<this.length); i++) {
            buffer [i-start] = bytes [i];
        }
        return new AsciiCharSequence(buffer); */

        return new AsciiCharSequence(Arrays.copyOfRange(bytes, start, end));
    }
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("");
        for (int i=0; i < length; i++) {
            buffer.append((char)bytes[i]);
        }
        return buffer.toString();
    }
    public void printMe () {
        System.out.println("Len:" + length);
        System.out.println("Symbols:" + this.toString());
    }

    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Sequence- " + answer.toString());//Hello!
        System.out.println("Length - " + answer.length());//6
        System.out.println("Symbol at 1 - " + answer.charAt(1));//e
        System.out.println("Subseq - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello
    }

}
