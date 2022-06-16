package delk.baseJave.edu.TextAnalyse;

/**
 * Должен конструироваться конструктором по-умолчанию.
 */

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    @Override
    protected String[] getKeywords() {
        String [] negativeSmiles = {":(", "=(", ":|"};
        return negativeSmiles;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
