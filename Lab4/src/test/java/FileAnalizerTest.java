import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FileAnalizerTest
{
    @org.junit.Test
    public void countLetters() throws Exception
    {
        FileAnalizer customAnalizer = new FileAnalizer("file.txt");

        int actual = customAnalizer.CountLetters();
        int expect = 21;
        assertEquals(actual, expect);
    }

    @org.junit.Test
    public void countWords() throws Exception
    {
        FileAnalizer customAnalizer = new FileAnalizer("file.txt");

        int actual = customAnalizer.CountWords();
        int expect = 4;
        assertEquals(actual, expect);
    }

    @org.junit.Test
    public void countLines() throws Exception
    {
        FileAnalizer customAnalizer = new FileAnalizer("file.txt");

        int actual = customAnalizer.CountLines();
        int expect = 4;
        assertEquals(actual, expect);
    }

    @org.junit.Test
    public void countFrequencyCharacteristic() throws Exception
    {
        FileAnalizer customAnalizer = new FileAnalizer("file.txt");

        Map actual = customAnalizer.CountFrequencyCharacteristic();

        Map<Character, Integer> expect = new HashMap<Character, Integer>();
        expect.put('Б', 2);
        expect.put('О', 1);
        expect.put('С', 1);
        expect.put('а', 3);
        expect.put('б', 1);
        expect.put('г', 1);
        expect.put('и', 1);
        expect.put('о', 2);
        expect.put('к', 1);
        expect.put('л', 1);
        expect.put('н', 2);
        expect.put('р', 2);
        expect.put('у', 1);
        expect.put('х', 1);
        expect.put('ь', 1);

        assertEquals(actual, expect);
    }

}