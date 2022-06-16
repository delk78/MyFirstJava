import java.util.Arrays;
import java.lang.*;
import java.math.*;
import java.util.Locale;

/**
 * this is javadoc comment. it will be included to documentation.
 * Program prints <code> Hello World </code>
 *
 * @author D. Elkind
 * @version 1.0
 */
public class HelloWorld_1 {
    public static void main(String[] args) {
        /**
         * Not clear how to insert standart comments...
         * @params args command line arguments
         */
        /*System.out.println("Hello World");
        System.out.println(Arrays.toString(args));
        System.out.println (Math.abs(-1.1111));
        System.out.println (Integer.numberOfLeadingZeros(3));
        System.out.println( Integer.numberOfTrailingZeros(3));
        System.out.println("A" + ('\t' + '\u0003'));
        System.out.println('A' + '1' + "2");
        System.out.println( 'A' + "12");
        System.out.println("A" + 12);
        System.out.println(isPalindrome ("Madam, I'm Adam!")); */
        //System.out.println(factorial(5));
        //int [] a1 = {0,2,2,3};
        //int [] a2 = {1,4,5};
        //mergeArrays(a1, a2);
        //psvm - public static void main
        //suot - System.out.println();
        //ctrl + Space - подсказк
        //ctrl + p - параметры
        // ctrl + q - документация
        // shift + tab - форматирование
        // clrl + shift + l - форматировать всё
        // shift + f6 - переименование всех элементов

        String[] roles = {
                "Городничий", "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));

    }

        /**
         * Checks if given <code>text</code> is a palindrome.
         *
         * @param text any string
         * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
         */
        public static boolean isPalindrome (String text){
            String loText = text.toLowerCase();
            System.out.println("1:" + loText);
            String wospecText = loText.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println("2:" + wospecText);
            StringBuilder reversedText = new StringBuilder(wospecText).reverse();
            System.out.println("3:" + reversedText);
            return wospecText.equals(reversedText.toString());
        }
        /**
         * Calculates factorial of given <code>value</code>.
         *
         * @param value positive number
         * @return factorial of <code>value</code>
         */
        public static BigInteger factorial ( int value){
            BigInteger factorial = BigInteger.valueOf(1);
            for (int i = 1; i <= value; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return factorial; // your implementation here
        }

        /**
         * Merges two given sorted arrays into one
         *
         * @param a1 first sorted array
         * @param a2 second sorted array
         * @return new array containing all elements from a1 and a2, sorted
         */
        public static int[] mergeArrays ( int[] a1, int[] a2){
            int len = a1.length + a2.length;
            int[] resultA = new int[len];
            int i = 0;
            int j = 0;
            System.out.println("i:" + i + " j:" + j);
            while (i < a1.length) {
                while ((j < a2.length) && (a1[i] > a2[j])) {
                    resultA[j + i] = a2[j];
                    System.out.println("i:" + i + " j:" + j);
                    j++;
                }
                resultA[i + j] = a1[i];
                System.out.println("i:" + i + " j:" + j);
                i++;

            } //last element in a1 copied, but maybe still elements in a2...
            while (j < a2.length) {
                resultA[i + j] = a2[j];
                System.out.println("i:" + i + " j:" + j);
                j++;
            }
            for (i = 0; i < len; i++) {
                System.out.println(resultA[i]);
            }
            return resultA;
        }
        public static int[] mergeArrays1 ( int[] a1, int[] a2){
            int n = a1.length, m = a2.length;
            int i = 0, j = 0;
            int[] array = new int[n + m];

            while (i < n || j < m)
                array[i + j] = (i < n && (j == m || a1[i] < a2[j])) ? a1[i++] : a2[j++];

            return array;
        }
    public static String printTextPerRole(String[] roles, String[] textLines) {
            StringBuilder resultText = new StringBuilder();
            int rolesIndex = 0;//current index in Roles arrar
            int textIndex = 0; // current index in Text array
            int outIndex = 0; //curretn index in Result text

            while (rolesIndex < roles.length) {
                resultText.append(roles[rolesIndex]);
                resultText.append(":\n");
                textIndex = 0; // start from begging of text
                while (textIndex < textLines.length) {
                    if (textLines[textIndex].startsWith(roles[rolesIndex]+":")) {
                        resultText.append(textIndex+1);
                        resultText.append(':');
                        int start = roles[rolesIndex].length() + 1; // skip :
                        int stop = textLines[textIndex].length();
                        resultText.append(textLines[textIndex].substring(start, stop));
                        resultText.append('\n');
                    }
                    textIndex++;
                }
                resultText.append("\n");
                rolesIndex++;
            }

            return resultText.toString();
        }

    }