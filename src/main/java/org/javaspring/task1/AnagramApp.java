package org.javaspring.task1;

import java.io.*;

public class AnagramApp {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            Anagram anagram = new Anagram();
            System.out.println(anagram.apply(br.readLine()));
        } catch (IOException io){
            System.out.println(io.getMessage());
        }
    }
}
