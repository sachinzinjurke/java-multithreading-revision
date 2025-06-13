package com.home.thread.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScrabbleGame {

    public static void main(String[] args) throws IOException {
        //https://introcs.cs.princeton.edu/java/data/ospd.txt
        Stream<String> lines = Files.lines(Paths.get("C:\\interview-workspace\\java-multithreading-revision\\src\\main\\resources\\ospd.txt"));
        //System.out.println(lines.count());
        Set<String> scrabbleWords = lines.map(word -> word.toLowerCase()).collect(Collectors.toSet());

        Stream<String> shakeSpearsWordsStream = Files.lines(Paths.get("C:\\interview-workspace\\java-multithreading-revision\\src\\main\\resources\\words.shakespeare.txt"));
       // Set<String> shakespeareWords = shakeSpearsWordsStream.map(word -> word.toLowerCase()).collect(Collectors.toSet());

        String name = "sachin";
        List<String> words = Arrays.asList("sachin","arjun","carli");

        int[] scrabbleScore = {

                //a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
                1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

        /*name.chars().forEach(letter->{
            System.out.println("letter : " + letter + " letter-a : " + (letter-'a'));
            System.out.println("Scrabble score: " + scrabbleScore[letter-'a']);
        });*/

        Function<String,Integer> score = word-> word.chars()
                .map(letter-> scrabbleScore[letter-'a'])
               // .peek(index -> System.out.println( scrabbleScore[index-'a']))
                .sum();

      /*  ToIntFunction<String> score1 = word-> word.chars()
                .map(letter-> scrabbleScore[letter-'a'])
                // .peek(index -> System.out.println( scrabbleScore[index-'a']))
                .sum();
        words.stream().map(score).forEach(System.out::println);

        OptionalInt max = shakespeareWords.stream().mapToInt(score1).max();
        System.out.println("Max Score :: " + max.getAsInt());

        String wordWithMaxScore = shakespeareWords.stream().max(Comparator.comparing(score)).get();
        System.out.println("Word with Max Score: " +wordWithMaxScore );*/

        Map<Integer, List<String>> histoShakeSpear = shakeSpearsWordsStream
                .map(word -> word.toLowerCase())
                .filter(scrabbleWords::contains)
                .collect(Collectors.groupingBy(score));
        System.out.println("#Histo : " + histoShakeSpear.size());

        histoShakeSpear.entrySet().stream()//Map.Entry<Integer, List<String>>
                .sorted(Comparator.comparing(entry -> -entry.getKey()))
                .limit(3)
                .forEach(entry -> System.out.println("key : " + entry.getKey() + " value : " + entry.getValue()) );

    }
}
