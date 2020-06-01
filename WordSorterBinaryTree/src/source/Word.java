package source;

public class Word<T> {
	
	String word;

	public Word(String word) {
		this.word = word;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public boolean startsWithVowel() {
		char letter = word.charAt(0);
		if(letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i' || letter == 'I' ||
				letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U') {
			return true;
		}
		return false;
	}
	public boolean startsWithNonVowel() {
		char letter = word.charAt(0);
		if(!(letter == 'a' && letter == 'A' && letter == 'e' && letter == 'E' && letter == 'i' && letter == 'I' &&
				letter == 'o' && letter == 'O' && letter == 'u' && letter == 'U') && !notWord()) {
			return true;
		}
		return false;
	}
	public boolean notWord() {
		char letter = word.charAt(0);
		if(!(letter == 'a' && letter == 'b' && letter == 'c' && letter == 'd' && letter == 'e' && letter == 'f' && 
				letter == 'g' && letter == 'h' && letter == 'i' && letter == 'j' && letter == 'k' && letter == 'l' && 
				letter == 'm' && letter == 'n' && letter == 'o' && letter == 'p' && letter == 'q' && letter == 'r' && 
				letter == 's' && letter == 't' && letter == 'u' && letter == 'v' && letter == 'w' && letter == 'x' && 
				letter == 'y' && letter == 'z' && letter == 'A' && letter == 'B' && letter == 'C' && letter == 'D' && 
				letter == 'E' && letter == 'F' && letter == 'G' && letter == 'H' && letter == 'I' && letter == 'J' && 
				letter == 'K' && letter == 'L' && letter == 'M' && letter == 'N' && letter == 'O' && letter == 'P' && 
				letter == 'Q' && letter == 'R' && letter == 'S' && letter == 'T' && letter == 'U' && letter == 'V' && 
				letter == 'W' && letter == 'X' && letter == 'Y' && letter == 'Z')) {
			return true;
		}
		return false;
	}
	public int wordLength() {
		return word.length();
	}
}
