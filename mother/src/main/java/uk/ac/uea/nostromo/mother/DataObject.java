/*
 * DataObject.java	v1.0.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation of a <em>blob</em> of data that is found in a larger
 * structure of a file.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since    v1.0.0-alpha+20151227
 */
public class DataObject<T> {

	/**
	 * The current index of the child
	 *
	 * @since    v1.0.0-alpha+20151227
	 */
	private int index = 0;

	/**
	 * A list of all of the children of this piece of data.
	 *
	 * @since    v1.0.0-alpha+20151227
	 */
	private java.util.List<DataObject> children;

	/**
	 * The actual data stored in this encapsulation.
	 *
	 * @since    v1.0.0-alpha+20151227
	 */
	private T data;

	/**
	 * Constructor
	 *
	 * @since    v1.0.0-alpha+20151227
	 */
	public DataObject() {
		children = new ArrayList<DataObject>();
	}

	/**
	 * Constructor
	 *
	 * @param	data The initial value for the data object
	 * @since    v1.0.0-alpha+20151227
	 */
	public DataObject(T data) {
		if(children == null)
			children = new ArrayList<DataObject>();

		this.children = children;
		this.data = data;
	}

	/**
	 * Constructor
	 *
	 * @param	children Any list of child {DataObjects} to initialise this objects children with
	 * @param	data The initial value for the data object
	 * @since    v1.0.0-alpha+20151227
	 */
	public DataObject(List<DataObject> children, T data) {
		if(children == null)
			children = new ArrayList<DataObject>();

		this.children = children;
		this.data = data;
	}

	/**
	 * Sets the value of the current data in this DataObject
	 *
	 * @param	data	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since    v1.0.0-alpha+20151227
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Adds new data to the current data in this {DataObject}. This will be added as a child object if this object already contains data.
	 *
	 * @param	data	!_TODO__ [Barry Wright] : Write this piece of documentation.
	 * @since    v1.0.0-alpha+20151227
	 */
	public void addData(T data){
		if(this.data == null)
			setData(data);
		else {
			addChild(new DataObject<T>(data));
		}
	}

	/**
	 * Add a child {DataObject} this is {DataObject}
	 *
	 * @param	child	The Child Data Object top be added
	 * @since    v1.0.0-alpha+20151227
	 */
	public void addChild(DataObject child) {
		children.add(child);
	}

	/**
	 * Remove a child from this objects children
	 *
	 * @param	child	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since    v1.0.0-alpha+20151227
	 */
	public void removeChild(DataObject child) {
		children.remove(child);
		if(index >= children.size())
			index = children.size() - 1;
	}

	/**
	 * Returns a list of all the child {DataObjects}
	 *
	 * @return	A list of all the child {DataObjects}
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since    v1.0.0-alpha+20151227
	 */
	public java.util.List<DataObject> getChildren() {
		return children;
	}

	/**
	 * Returns true if the {DataObject} has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
	 *
	 * @return	true if the {DataObject} has more elements
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since    v1.0.0-alpha+20151227
	 */
	public Boolean hasNext() {
		return index + 1 < children.size();
	}

	/**
	 * Returns the next element
	 *
	 * @return	the next element
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since    v1.0.0-alpha+20151227
	 */
	public DataObject nextData() {
		index++;

		if(index >= children.size())
			index = children.size() - 1;
		return children.get(index);
	}

	/**
	 * Resets the iteration back to its first element.
	 *
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since    v1.0.0-alpha+20151227
	 */
	public void resetIterator() {
		index = 0;
	}

	/**
	 * Search through this {@code DataObject} in an attempt to find a
	 * term that matches {@code term}.
	 *
	 * @param	term		The pattern to be used in finding matches in
	 *						this {@code DataObject}.
	 * @param	comparator	The comparison function to use when
	 *						comparing items.
	 * @return	A {@code DataObject} containing the matched term an its
	 *			child data.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since	v1.0.0-alpha+20151227
	 */
	public DataObject search(String term, java.util.Comparator comparator) {
		throw new UnsupportedOperationException("The method `DataObject.search(String, java.util.Comparator)` is yet to be implemented.");
	}
}
