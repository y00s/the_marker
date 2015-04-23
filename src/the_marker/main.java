package the_marker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.TextExtractor;


public class main {

	/**
	 *First function requested
	 *take a html-format string and return just the non-html tags text
	 *using plain jericho library
	 *
	 * Yosef
	 */
	public static String plain_text(String html_text){
		Source source = new Source(html_text);
		return source.getTextExtractor().setIncludeAttributes(true).toString();

	}

	/**
	 *Second function requested
	 *take a html-format string index and offset
	 *return a Marker class which is extracted 
	 *from the modifyed TextExtractor from jericho lib
	 *
	 * Yosef
	 */
	public static Marker highlight(String html,int index,int length){

		Source source = new Source(html);
		Segment segment = new Segment(source, 0, source.length());
		TextExtractor te = new TextExtractor(segment);
		Marker result = te.getMarker(index,length);
		result.elimnateSpaces();
		return result;
	}

	public static void main(String[] args) {

		try {


			//take the file path, open the file and poor it into a string
			System.out.println("Please enter the HTML file path: ");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			String filePath = new String(buffer.readLine());
			String html  = new String(Files.readAllBytes(Paths.get(filePath)));

			//show the html and plain text
			String plain = plain_text(html); 
			System.out.println("HTML string: "+html);
			System.out.println("plain text string: "+plain);

			//take the index and offset from user
			System.out.println("please enter the start index: ");
			buffer = new BufferedReader(new InputStreamReader(System.in));
			int index = Integer.parseInt(buffer.readLine());
			System.out.println("please enter the offset: ");
			int offset = Integer.parseInt(buffer.readLine());

			//invoke the marker extractor function
			Marker marker =highlight(html, index, offset);

			//print the result
			String plainHighlighted = plain.substring(index,offset);
			System.out.println("plain text highlight: "+plainHighlighted);
			System.out.println("HTML text highlight: "+marker.toString());

		} catch (Exception e) {
			
			e.printStackTrace();
		}



	}


}
