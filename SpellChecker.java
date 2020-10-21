import java.util.*;
import java.io.*;
import java.util.regex.PatternSyntaxException;

public class SpellChecker {
    
    private HashSet<String> dictionary;
    
    public SpellChecker(String file) {
        try {
            dictionary = new HashSet<String>();
            File wordFile = new File(file);
            Scanner in = new Scanner(wordFile);
        
            while(in.hasNextLine()) {
                String word = in.nextLine();
                dictionary.add(word.toLowerCase());
            }
        } catch(FileNotFoundException e) {
            System.out.println("Invalid input");
        }
    }
    
    
    public List<String> getIncorrectWords(String filename) {
        ArrayList<String> wrongWords = new ArrayList<String>();
        try {
            File inputFile = new File(filename);
            Scanner input = new Scanner(inputFile);
            while(input.hasNextLine()) {
                String line = input.nextLine();
                String[] wordList = line.split(" ");
                for(int i = 0; i < wordList.length; i++) {
                    wordList[i] = parsePunctuation(wordList[i]);
                    if(!dictionary.contains(wordList[i])) {
                        wrongWords.add(wordList[i]);
                    }
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("Invalid input");
        }
        return wrongWords;
    }
    
    
    private String parsePunctuation(String word) {
        String newWord = word.toLowerCase();
        try {
            newWord = newWord.replaceAll("\\p{Punct}",""); 
        } catch(PatternSyntaxException e) {
             System.out.println("PatternSyntaxException");
        }
        return newWord;
    }
        
        
	public Set<String> getSuggestions(String word) {
        word = parsePunctuation(word.toLowerCase());
        HashSet<String> suggest = new HashSet<>();
        if(word.compareTo("") != 0) {
            
        //add character technique
        for(int i = 97; i < 123; i++) {
            for(int j = 0; j < word.length() + 1; j++) {
                String newString = "";
                for(int k = 0; k < word.length() + 1; k++) {
                    if(k == j) {
                        newString += String.valueOf((char)i);
                    }
                    if(k < word.length()) {
                        newString += word.charAt(k);
                    }
                }
                if(dictionary.contains(newString)) {
                    suggest.add(newString);
                }
            }
        }
        
        //remove character technique
        for(int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);
            if(dictionary.contains(newWord)) {
                suggest.add(newWord);
            }
        } 
        
        //switch character technique
        for(int i = 1; i < word.length(); i++) {
            String newString = "";
            for(int k = 0; k < i - 1; k++) {
                newString += String.valueOf(word.charAt(k));
            }
            newString += String.valueOf(word.charAt(i));
            newString += String.valueOf(word.charAt(i-1));
            for(int j = i + 1; j < word.length(); j++) {
                newString += String.valueOf(word.charAt(j));
            }
            if(dictionary.contains(newString)) {
                suggest.add(newString);
            }
        }
            
        }
        return suggest;
    }
}
    
