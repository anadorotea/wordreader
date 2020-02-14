package org.academiadecodigo.workreader;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        WordReader wordReader = new WordReader("/Users/codecadet/Documents/Projects/WordReader/diamau.txt");

        for (String word :wordReader){
            System.out.println(word);
        }

        Iterator<String> iterator = wordReader.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
