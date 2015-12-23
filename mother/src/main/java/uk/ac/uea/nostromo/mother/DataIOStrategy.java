/*
 * DataIOStrategy.java	v1.0.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother;

/**
 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
 */
public class DataIOStrategy<T> {
	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	private String location;

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	objects	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void writeData(DataObject objects) {
		throw new UnsupportedOperationException("The method `DataIOStrategy.writeData(DataObject)` is yet to be implemented.");
	}

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public DataObject readData() {
		throw new UnsupportedOperationException("The method `DataIOStrategy.readData()` is yet to be implemented.");
	}

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	location	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void setLocation(String location) {
		throw new UnsupportedOperationException("The method `DataIOStrategy.setLocation(String)` is yet to be implemented.");
	}
}
