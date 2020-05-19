import java.io.IOException;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//DictEx is the child of DictBody
public class DictEx extends DictBody {
	
	//declaring variables for the example arrays - these will give example sentences for every word
	private String[]  engArr = new String[200], espArr = new String[200];
	private int i=0, j=0;
	
	public DictEx(String w) throws IOException {
		//passing the parameter to the parent constructor
		super(w);
		
		//fills the example arrays
		fillEngArr();
		fillEspArr();
		//prints the output
		printOut();
	}
	
	//fills the English examples array
	public void fillEngArr() {
		String exEng = "div > .FyTYrC-y > div > span:nth-of-type(1)";
		//iterates through every element for the parameter "exEng" and stores them in an array
		for(Element e: super.selector(exEng)) {
			String temp = e.text();
			engArr[i] = temp;
			i++;
		}
	}
	
	//fills the Spanish examples array
	public void fillEspArr() {
		String exEsp = "div:nth-of-type(1) > div > .FyTYrC-y > div > ._3Qchy0y7";
		//iterates through every element for the parameter "exEsp" and stores them in an array
		for(Element ex : super.selector(exEsp)) {
			String temp = ex.ownText();
			espArr[j] = temp;
			j++;
		}
	}
	
	//prints out the words with/without and gender and with example sentences for both languages
	@Override
	public void printOut() {
		int y = 0;
		//iterates through the translated words of the parent class
		for(int x=0;x<super.wordArr.length;x++) {
			y++;
			//exits the loops if there are no more words to display
			if(wordArr[x]==null) {
				break;
			}
			else {
				/* gender array currently returns null due to html code change at the site
				//if the word has gender (so it is a Spanish word) it displays its gender
				if(genderArr[x]!=null) {
					System.out.print(y + ". " + wordArr[x] + " " + genderArr[x]);
					System.out.println();
					System.out.println(engArr[x] + " - " + espArr[x]);
					System.out.println();
				//if there is no gender then it will not display it	
				} else {
					System.out.print(y + ". " + wordArr[x]);
					System.out.println();
					System.out.println(engArr[x] + " - " + espArr[x]);
					System.out.println();
				}*/
				// examples from both langueages does not work due to html change at the site
				System.out.print(y + ". " + wordArr[x]);
				System.out.println();
			}
		}
	}	
}
