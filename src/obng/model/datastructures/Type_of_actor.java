package obng.model.datastructures;

/**
 * Acutally only a wrapped String currently - maybe I will extend it. However I
 * need to do this here, cause according to object calisthetics I need to wrap
 * every basic datatype - even Strings
 * 
 * @edit I am adding a placeholder in form of an int, actually I am planing to
 * use it in a hash map. But lets see whats coming up
 * 
 * @author Neuly
 */
public class Type_of_actor {

	private String type;

	private int number_placeholder;

	/** Constructor for the type_of_actor */
	public Type_of_actor(String _type, int _p) {
		this.type = _type;
		this.number_placeholder = _p;
	}

	/** returns the type */
	public String which() {
		return type;
	}

	/** uses thenumber_placeholder as hash_return */
	@Override
	public int hashCode() {
		return number_placeholder;
	}

	/** uses thenumber_placeholder as outcoming result */
	@Override
	public boolean equals(Object e) {
		if (!(e instanceof Type_of_actor))
			return false;
		return (((Type_of_actor) e).number_placeholder == number_placeholder);
	}
}
