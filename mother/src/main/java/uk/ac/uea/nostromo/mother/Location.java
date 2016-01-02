/*
 * Location.java	v1.0.0	2015-12-02
 */

package uk.ac.uea.nostromo.mother;

/**
 * Store information about a GPS location in a transferable format.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151227
 */
public class Location {
	/**
	 * Returns the value representing the longitude of this location.
	 *
	 * @return	A {@code Double} object representing the longitude of
	 *			this location in <b>degrees</b>.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	v1.0.0-alpha+20151227
	 */
	public Double getLongitude() {
		throw new UnsupportedOperationException("The method `Location.getLongitude()` is yet to be implemented.");
	}

	/**
	 * Returns the value representing the latitude of this location.
	 *
	 * @return	A {@code Double} object representing the longitude of
	 *			this location in <b>degrees</b>.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	v1.0.0-alpha+20151227
	 */
	public Double getLatitude() {
		throw new UnsupportedOperationException("The method `Location.getLatitude()` is yet to be implemented.");
	}
}
