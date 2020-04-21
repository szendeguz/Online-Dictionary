import java.io.IOException;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) throws IOException {
		//scanner objects first input will be the word or expression to translate
		Scanner in = new Scanner(System.in);
		System.out.println("What word would you like to translate?");
		String word = in.nextLine();
		//declaring the DictEx object
		DictEx dict = new DictEx(word);
		in.close();
	}

}
