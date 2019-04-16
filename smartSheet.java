import java.util.HashMap;
import java.lang.Character;


/*
Created by: Kevin Rodriguez
Date: Jan 05, 2019

Implementation:
- The implementation I went with for this problem is by using a HashMap as my data structure. By using a HashMap the efficiency of inserting
and accessing increases making it O(1) in the best scenario and O(log n) in the worst scenario since it degrades into a tree when handling
collisions.

The way that I arranged the task of this entire problem is by two methods. One method which is called minifiedCode and a function
that adds the values into the output String. Below I explained a little about each method created. I also added comments throughout my
implementation to better understand my code.

--------------------------------------------------- minifiedCode Method --------------------------------------------------------------------

Variables:
- StringBuilder : word, output (I used a StringBuilder for building each word and building the output String)
- int : indexCounter (keeps count of the index of each word)

Usage
I read every value of each index of the input. If the value is
a letter, I append it to the StringBuilder. As soon as I read something that is not a letter, I know the word has been constructed and I've
encountered with a non-identifier. I then check if the word is in my HashMap, if its not I add it to my HashMap as well to the output String.
If it already exists, I grab the index of the word and append "$<with appropriate Index>" to the stringBuilder for the output. I then append
the non-identifier to the output String.

--------------------------------------------------- appendValue Method ----------------------------------------------------------------------

- Method that takes in a HashMap, StringBuilder output, indexCounter, word

- checks if the desired word is in the HashMap. If it doesn't exist it adds it to the HashMap with its appropriate index. It also
 appends the word to the output String. If it already it grabs the index of the word and appends "$<with appropriate Index>".
 */


public class smartSheet {

    public static String minifiedCode (String input){
        HashMap<String,Integer> hm = new HashMap();
        int indexCounter = 0;
        StringBuilder output = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i=0; i < input.length(); i++){

            if (Character.isLetter(input.charAt(i))){

                word.append(input.charAt(i)); //adding letter to the word
                if (i == input.length()-1){ //taking care of case when a word is the last word of a string. Will call appendValue method.
                    appendValue(hm, output, indexCounter, word.toString());
                }

            }

            else{ 
                if (word.length() != 0) { //making sure the word is greater than zero in order to keep indexCounter correct
                    appendValue(hm, output, indexCounter, word.toString());
                    indexCounter++;
                }

                output.append(input.charAt(i)); //adds all non-identifiers
                word = new StringBuilder(); //updating word to empty/new StringBuilder
            }



        }

        return output.toString();
    }


    public static void appendValue(HashMap hm, StringBuilder output, int indexCounter, String word){

        if (!hm.containsKey(word)){
            hm.put(word,indexCounter); //adds word and index counter to hashmap when it doesnt exist.
            output.append(word); //appens the word to the output String
        }
        else{ //word already exists in HashMap
            output.append("$");
            output.append(hm.get(word)); //appends the indexValue of the word.
        }

    }

    public static void main(String args[]){

        System.out.print(minifiedCode("you say yes, I say no you say stop and I say go go go"));

    }









}
