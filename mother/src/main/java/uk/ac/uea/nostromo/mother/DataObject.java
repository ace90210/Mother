/*
 * DataObject.java	v1.0.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother;

/**
 * A representation of a <em>blob</em> of data that is found in a larger
 * structure of a file.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
 */
public class DataObject {
	/**
	 * A list of all of the children of this piece of data.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	private java.util.List<DataObject> children;

	/**
	 * The actual data stored in this encapsulation.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	private Object data;

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	data	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void setData(Object data) {
		throw new UnsupportedOperationException("The method `DataObject.setData(Object)` is yet to be implemented.");
	}

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	child	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void addChild(DataObject child) {
		throw new UnsupportedOperationException("The method `DataObject.addChild(DataObject)` is yet to be implemented.");
	}

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	child	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void removeChild(DataObject child) {
		throw new UnsupportedOperationException("The method `DataObject.removeChild(DataObject)` is yet to be implemented.");
	}

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public java.util.List<DataObject> getChildren() {
		throw new UnsupportedOperationException("The method `DataObject.getChildren()` is yet to be implemented.");
	}

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public Boolean hasNext() {
		throw new UnsupportedOperationException("The method `DataObject.hasNext()` is yet to be implemented.");
	}

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public Object nextData() {
		throw new UnsupportedOperationException("The method `DataObject.nextData()` is yet to be implemented.");
	}

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void resetIterator() {
		throw new UnsupportedOperationException("The method `DataObject.resetIterator()` is yet to be implemented.");
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
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public DataObject search(String term, java.util.Comparator comparator) {
		throw new UnsupportedOperationException("The method `DataObject.search(String, java.util.Comparator)` is yet to be implemented.");
	}
}
