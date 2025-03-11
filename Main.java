package tutorial2;

import java.util.Scanner; 

public class CharacterAnalysis { 
    
    public static void checkVowelOrConsonant(char ch) { 
        ch = Character.toLowerCase(ch); 
        
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
        { 
            System.out.println(ch + " is a vowel."); 
        } else 
        
        { 
            System.out.println(ch + " is a consonant."); 
        } 

    } 

    public static void main(String[] args)
    { 
        Scanner sc = new Scanner(System.in); 

        System.out.print("Enter a character: "); 

        char inputChar = sc.next().charAt(0); 

        checkVowelOrConsonant(inputChar); 

        sc.close(); 
    

} 