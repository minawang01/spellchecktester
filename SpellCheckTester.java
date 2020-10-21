import java.util.*;
public class SpellCheckTester {
    
    public static void main(String[] args) {
        
        SpellChecker m = new SpellChecker("words.txt");
        List<String> n = m.getIncorrectWords("test.txt");
        for(int i = 0; i < n.size(); i++) {
            System.out.println(n.get(i));
            System.out.println("---------------possible options---------------");
            Object[] p = m.getSuggestions(n.get(i)).toArray();
            for(int j = 0; j < p.length; j++) {
                System.out.println((String)p[j]);
            } 
        }
        
        Object[] x = m.getSuggestions("pp").toArray();
        for(int i = 0; i < x.length; i++) {
            System.out.println((String)x[i]);
        }
    }
}