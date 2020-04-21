import java.io.IOException;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//DictBody implements Gender to show the gender of Spanish words
public class DictBody implements Gender {
	
	//declaring variables
	//url will be the url of the dictionary
	private String url;
	private int i=0,j=0;
	//document refers to an HTML document in Jsoup
	private Document page;
	//string and gender array store the translated words and genders
	protected String[] wordArr = new String[200];
	protected String[] genderArr = new String[200];
	
	public DictBody(String word) throws IOException {
		//the urel is set to the parameter concatenated with the url
		this.url="https://www.spanishdict.com/translate/"+word;
		//Jsoup connects and gets the HTML document with the given url
		page = Jsoup.connect(url).get();
		
		//calling the array filling methods
		fillWordArr();
		fillGenderArr();	
	}
	
	//selector methods declares an Element that searches for the given parameter at the page
	public Elements selector(String s) {
		Elements element = this.page.select(s);
		return element;
	}
	
	//fills the word array
	public void fillWordArr() {
		String word = "a.C2TP2MvR";
		//iterates through every element for the parameter "word" and stores them in an array
		for(Element w: this.selector(word)) {
			String temp = w.text();
			wordArr[i] = temp;
			i++;
		}
	}
	
	//fills the gender array
	@Override
	public void fillGenderArr() {
		String gender="a._37-8_B5E";
		//iterates through every element for the parameter "gender" and stores them in an array
		for(Element g : this.selector(gender)) {
			String temp = g.text().toLowerCase();
			genderArr[j] = temp;
			j++;
		}
	}
	
	//empty method that should be overriden by the child class
	public void printOut() {
	}
}
