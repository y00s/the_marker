package the_marker;


/**
 *Marker class
 *represent markd text in a string 
 *contain the full string, the beginning of the marked part and offset
 *
 * Yosef
 */
public class Marker {

	// global variables
	int index;
	int offset;
	String string;

	//the maib function - print the marked text
	public String toString() {
		return "Marker [markd=" + string.substring(index, offset) + ", full String=" + string
				+ "]";
	}

	// Feature function that eliminate the double or more spaces
	public void elimnateSpaces() {
		string = string.replaceAll("\u00a0"," ");
		
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i)==' ' && string.charAt(i+1)==' ') {
				string = string.substring(0, i)+string.substring(i+2,string.length());
				if (index>i) {
					index--;
				}
				if (offset>i) {
					offset--;
				}
			}

		}
	}

	//ctor
	public Marker(int index, int offset, String string) {
		super();
		this.index = index;
		this.offset = offset;
		this.string = string;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}

}
