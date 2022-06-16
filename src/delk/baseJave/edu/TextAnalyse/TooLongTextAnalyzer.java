package delk.baseJave.edu.TextAnalyse;

/**
 * должен конструироваться от int'а с максимальной допустимой длиной комментария.
 * Объект этого класса должен сохранять в своем состоянии это число в приватном поле maxLength.
 */
public class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;

    public TooLongTextAnalyzer(int aLength) {
        maxLength = aLength;
    }

    @Override
    public Label processText(String text) {
        return (text.length() > this.getMaxLength()? Label.TOO_LONG: Label.OK );
    }

    public int getMaxLength() {
        return maxLength;
    }
}
