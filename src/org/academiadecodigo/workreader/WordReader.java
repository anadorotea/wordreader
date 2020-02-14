package org.academiadecodigo.workreader;

import java.io.*;
import java.util.Iterator;

public class WordReader implements Iterable<String>{


    FileReader reader;
    BufferedReader bReader;
    String file;


    public WordReader(String file) throws FileNotFoundException {
        this.file = file;


    }


    private void close() throws IOException {
        try {

            bReader.close();
            reader.close();

        } catch (IOException e){

            System.out.println(e.getMessage());

        }

    }


    @Override
    public Iterator iterator(){
            return new WordIterator();
    }




    public class WordIterator implements Iterator <String>{

        private String[] words;
        private int index = 0;
        private String sentence;

        public WordIterator() {
            try  {
                reader = new FileReader(file);
                bReader = new BufferedReader(reader);

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
            wordIterator();
        }


        public void wordIterator() {

                try {
                    sentence = bReader.readLine();
                    if (sentence == null) {
                        close();
                    } else {
                        words = sentence.split(" ");
                    }

                } catch (IOException e) {

                    System.out.println(e.getMessage());

                }



        }


                @Override
                public boolean hasNext() {
                    if(index == words.length) {

                        wordIterator();
                        if(sentence == null){
                            return false;
                        }
                        index = 0;
                        return true;
                    }


                    if(index < words.length) {
                        return true;

                    }


                    return false;
                }

                @Override
                public String next() {
                    return words[index++];
                }
            };

    }

