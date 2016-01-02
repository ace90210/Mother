/*
 * DataIOStrategy.java	v1.0.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother;

/**
 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since    v1.0.0-alpha+20151227
 */
public abstract class DataIOStrategy<T> {
	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
     * @since    v1.0.0-alpha+20151227
     */
	protected String location;

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	objects	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since    v1.0.0-alpha+20151227
	 */
	public abstract void writeData(DataObject objects);

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since    v1.0.0-alpha+20151227
	 */
	public abstract DataObject readData();

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	location	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *											method is yet to be implemented.
	 * @since	v1.0.0-alpha+20151227
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
