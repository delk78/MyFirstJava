package delk.baseJave.edu.TextAnalyse;

/**
 * Должен конструироваться от массива строк с ключевыми словами.
 * Объект этого класса должен сохранять в своем состоянии этот массив строк в приватном поле keywords.
 */
public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String [] keywords;
    public SpamAnalyzer (String [] theKeywords) {
        this.keywords = theKeywords.clone();
    }
    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {

        return Label.SPAM;
    }

}
