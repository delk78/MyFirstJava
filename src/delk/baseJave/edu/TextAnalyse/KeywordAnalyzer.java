package delk.baseJave.edu.TextAnalyse;

/**
 * "Промежуточный" асбрактный класс, который позоволяет в стрроке, которую он получает через text искать ключевые слова,
 * которые он получает через getKeywords (), и в случае успеха возвращать getLabel (). Оба этих метода наследники должны переписать.
 * Таким образом, при вызове конкретного экзепляра этого абстрактного класса, мы будем искать разные ключевые слова и возращать разный результат
 *
 */
public abstract class KeywordAnalyzer implements TextAnalyzer {

    protected abstract String[] getKeywords ();
    protected abstract Label getLabel ();

    public Label processText(String text) {
        String [] keywords = getKeywords();
        for (String keyword: keywords) {
            if (text.contains(keyword) ) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}


