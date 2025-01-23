import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String word) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
	    // your code goes here
        String [] vowels = {"a", "e", "i", "o", "u"};
  for(int i = 0; i < word.length(); i++){
    for(int n = 0; n < 5; n++){
    if(word.substring(i, i+1).equals(vowels[n])){
      return (i);
    }
    }
  }
  return (-1);
    }

    public String pigLatin(String str) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
        // more code should go here
	  if(str.substring(0,2).equals("qu")){
  return(str.substring(2) + "quay");
}else if(findFirstVowel(str) == -1){
  return(str + "ay"); 
}else if(findFirstVowel(str) == 0){
 return(str + "way");
}else{
  return(str.substring(findFirstVowel(str)) + str.substring(0, findFirstVowel(str)) + "ay");
}
    }
}//end PigLatin class
