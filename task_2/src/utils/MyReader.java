package utils;

import model.WordsInfo;
import model.WordsInfoCreator;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class MyReader
{
    private FileReader fileReader;

    private LinkedList<WordsInfo> duplicates = new LinkedList<>();

    private WordsInfoCreator wordsInfoCreator = new WordsInfoCreator();


    public Reader getFileReader()
    {
        try
        {
            fileReader = new FileReader("src/resources/zadanie.txt");
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return fileReader;
    }

    public LinkedList<WordsInfo> makeDuplicates(Scanner scanner)
    {
        String line;
        String[] wordsFromLine;
        long lineNumber = 0;
        while (scanner.hasNextLine())
        {
            line = scanner.nextLine().replaceAll("[-.,?!%:;()_]","");
            wordsFromLine = line.split(" ");
            if(!line.isEmpty())
                lineNumber++;

            for(String word : wordsFromLine)
            {
                Optional<WordsInfo> wi;
                if((wi = duplicates.stream().filter(d -> d.getWord().equals(word)).findAny()).isPresent())
                    wi.get().addLineNumber(lineNumber);
                else duplicates.add(wordsInfoCreator.create(word, lineNumber));
            }
        }

        return duplicates;
    }

    public Stream<WordsInfo> sortWords(LinkedList<WordsInfo> listOfWordsInfo)
    {
        listOfWordsInfo.removeIf(l -> l.getLineNumbers().size() < 2 || l.getWord().startsWith("-"));
        return listOfWordsInfo.stream().sorted(Comparator.comparing(WordsInfo::getWord));
    }

    public void printResults(Stream<WordsInfo> infoStream)
    {
        infoStream.forEach(System.out::println);
    }
}
