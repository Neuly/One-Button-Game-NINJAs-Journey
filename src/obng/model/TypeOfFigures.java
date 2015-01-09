package obng.model;

import java.util.HashMap;
/**
 * 
 * A Hash Map representing the type of actors. Returning Figures as Values.
 * 
 * Basic idea is the need for constant time access during this proeject
 * 
 * @author Neuly
 *
 * @param <Type_of_actor>
 * @param <Figure>
 */
public class TypeOfFigures<Type_of_actor, Figure> extends
		HashMap<Type_of_actor, Figure> {
	
	/** Constructor for the agency */
	public TypeOfFigures() {
		super();
	}

}
