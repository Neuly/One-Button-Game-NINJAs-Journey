package obng.model.datastructures;

/**
 * A method that contains a String text representation and 
 * 
 * @author Neuly
 */
public class Text {

	private String line;
	
	private int size;
	
	/** sets the text and its size */
	public Text (String _line, int _size) {
		this.line = _line;
		this.size = _size;
	}
	
	/** A Constructor to actually clone a given Text structure */
	public Text(Text local_text_copy) {
		this.line = local_text_copy.show_Text();
		this.size = local_text_copy.size_of_Text();
	}

	/** returns the text of the line */
	public String show_Text () {
		return line;
	}
	
	/** returns the text of the line */
	public int size_of_Text () {
		return size;
	}
}
