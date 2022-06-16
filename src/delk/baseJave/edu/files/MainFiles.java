package delk.baseJave.edu.files;
import java.io.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MainFiles {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int C  = 0;
        int b = inputStream.read();
        while (b >= 0) {
            C = Integer.rotateLeft(C,1) ^ b;
            b = inputStream.read();
        }
        return C;
    }
    public static String utf8code(char ch) throws IOException{
        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream ();
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        writer.write(ch);
        writer.flush();
        byte [] result = outputStream.toByteArray();

        StringBuilder buffer =  new StringBuilder();
        for (byte b: result) {
            buffer.append(Byte.toUnsignedInt(b));
            buffer.append(" ");
        }
        return buffer.toString();

    }
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
        final int MAX_BUF = 1024;
        InputStreamReader isr = new InputStreamReader(inputStream, charset);
        StringBuilder sb = new StringBuilder();

        char[] cbuf = new char[MAX_BUF];
        while(true){
            int bytesRead = isr.read(cbuf, 0, MAX_BUF);
            if(bytesRead == -1)
                break;
            sb.append(cbuf, 0, bytesRead);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        String [] names = {
                "a\\..\\b\\c\\file.txt",
                "a\\.\b\\..\\c\\.\\file.txt",
                "a\\b\\c\\file.txt",
                ".\\a\\b\\..\\b\\c\\.\\file.txt",
                "a\\b\\..\\file.txt"};
    for (String s: names) {
        File f = new File(s);
        System.out.println(f.getCanonicalPath());
    }
    ///////////////// array as input stream...
        byte [] data = {48,49,50,51};
        try (InputStream is = new ByteArrayInputStream(data)) {
            System.out.println(checkSumOfStream(is));
        }
    //////// UTF codes for symbols.
        System.out.println("UTF-code:"+ utf8code('Ы'));
    //// other way to do translate to UTF
        int res;

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Ы".getBytes(StandardCharsets.UTF_8));
        while ((res = byteArrayInputStream.read()) >= 0) {
            System.out.println(res);
        }
        /// Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        //Что будет фактически записано в outputStream, если мы попытаемся вывести через writer символ,
        // не представимый в указанной ему кодировке ASCII? Например, какой-нибудь иероглиф или символ кириллицы.
        OutputStream outputStream = System.out;
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        writer.write("Ы");
        writer.flush();

        //

        System.out.println(readAsString(new ByteArrayInputStream(data), StandardCharsets.US_ASCII));

    }
}
