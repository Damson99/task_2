package model;

import java.util.LinkedList;

public class WordsInfo
{

    private String word;

    private LinkedList<Long> lineNumbers = new LinkedList<>();


    public WordsInfo(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public LinkedList<Long> getLineNumbers() {
        return lineNumbers;
    }

    public void addLineNumber(Long lineNumber) {
        lineNumbers.add(lineNumber);
    }

    @Override
    public String toString()
    {
        return getWord() + " - " + countLineNumbers() + " - " + "pozycje -> " + getLineNumbers();
    }

    private int countLineNumbers()
    {
        return getLineNumbers().size();
    }
}

