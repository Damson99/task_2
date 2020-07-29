package main;

import model.WordsInfo;
import utils.MyReader;

import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        MyReader reader = new MyReader();
        Scanner bufferedReader = new Scanner(reader.getFileReader());
        LinkedList<WordsInfo> listOfWordsInfo =  reader.makeDuplicates(bufferedReader);
        reader.printResults(reader.sortWords(listOfWordsInfo));
    }
}
