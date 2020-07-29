package model;


public class WordsInfoCreator
{
    public WordsInfo create(String s, Long lineNumber)
    {
        WordsInfo wordsInfo = new WordsInfo(s);
        wordsInfo.addLineNumber(lineNumber);
        return wordsInfo;
    }
}
