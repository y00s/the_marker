package the_marker;

public class Marker {
	int index;
	int offset;
	String string;
	public String toString() {
		return "Marker [markd=" + string.substring(index, offset) + ", full String=" + string
				+ "]";
	}
	public void elimnateSpaces() {
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
