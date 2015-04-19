package the_marker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.TextExtractor;


public class main {

	public static String plain_text(String html_text){
		Source source = new Source(html_text);
		return source.getTextExtractor().setIncludeAttributes(true).toString();
			
	}
	
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


	System.out.println("Please enter the HTML file path: ");
	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	String filePath = new String(buffer.readLine());
	String html  = new String(Files.readAllBytes(Paths.get(filePath)));
	
	String plain = plain_text(html); 
	System.out.println("HTML string: "+html);
	System.out.println("plain text string: "+plain);
	System.out.println("please enter the start index: ");
	buffer = new BufferedReader(new InputStreamReader(System.in));
	
	int index = Integer.parseInt(buffer.readLine());
	System.out.println("please enter the offset: ");
	int offset = Integer.parseInt(buffer.readLine());

	
	Marker marker =highlight(html, index, offset);
	String plainHighlighted = plain.substring(index,offset);
	System.out.println("plain text highlight: "+plainHighlighted);
	System.out.println(marker.toString());
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



	}


}
