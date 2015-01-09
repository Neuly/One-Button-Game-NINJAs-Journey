package obng.model;

import obng.datastructures.*;

/**
 * An agency that "rents" actors. The basic idea is, that if an object gets 
 * requested, represented by the type_of_actor class, it should clone such an
 * object and give it a unique number - so it can get identified. 
 * 
 * In this case, actors are only enemies or stones - no caretaking about back-
 * ground or anything else
 * 
 * @author Neuly
 */
public class Agency {
	
	/** The Hash Map representing kind of actors */	
	private TypeOfFigures<Type_of_actor, Figure> types;
	
	/** The Constructor for the Agency */ 
	public Agency()
	

}
