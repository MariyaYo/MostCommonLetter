
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;

public class MostCommonLetter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter some text:");
		String text = sc.nextLine();
		System.out.println();
		sc.close();
		text = text.toLowerCase();
		TreeMap<Character, Integer> sortedLetters = new TreeMap<>();
		int count = 0;
		for(int i = 0; i < text.length(); i++){
			if(text.charAt(i)>= 97 && text.charAt(i)<=122){
				count++;
				if(!sortedLetters.containsKey(text.charAt(i))){
					sortedLetters.put(text.charAt(i), 1);
				}else{
					sortedLetters.put(text.charAt(i), sortedLetters.get(text.charAt(i)).intValue()+1);
				}
			}
		}
		ArrayList<Character> list = new ArrayList<>();
		//i'm arranging them from least common to most common ..
		for(int i = 0; i <text.length(); i++){
			for(Entry<Character, Integer> a : sortedLetters.entrySet()){
				if(a.getValue() == i){
					list.add(a.getKey());
				}
			}
		}
		
		System.out.println("Most common letters:");
		System.out.println();
		for(int i = list.size()-1; i>=0 ;i--){
			if(sortedLetters.get(list.get(i)).intValue()/10 == 0){
				//because if it's a 1 digit number it won't be aligned, so i have to separate them with one more space to look better
				System.out.print(list.get(i) + ":  " + sortedLetters.get(list.get(i)).intValue() + " ");
			}else{
				System.out.print(list.get(i) + ": " + sortedLetters.get(list.get(i)).intValue() + " ");
			}
				int howManyHashtags = ((100/count)*sortedLetters.get(list.get(i)).intValue());
				for(int j = 0; j< howManyHashtags; j++){
					System.out.print("#");
				}
				System.out.println();
		}
	}
}
