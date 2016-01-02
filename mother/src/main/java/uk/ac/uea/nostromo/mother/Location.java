/*
 * Location.java	v1.1.0	2015-12-23
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
	 * The latitude, of this latitude-longitude pairing.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	private Double latitude;

	/**
	 * The longitude, of this latitude-longitude pairing.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	private Double longitude;

	/**
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public Location(Double lat, Double lng) {
		latitude = lat;
		longitude = lng;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	public String toString() {
		return "(" + latitude + ", " + longitude + ")";
	}

	/**
	 * Returns the value representing the longitude of this location.
	 *
	 * @return	A {@code Double} object representing the longitude of
	 *			this location in <strong>degrees</strong>.
	 * @since	v1.0.0-alpha+20151227
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * Returns the value representing the latitude of this location.
	 *
	 * @return	A {@code Double} object representing the longitude of
	 *			this location in <b>degrees</b>.
	 * @since	v1.0.0-alpha+20151227
	 */
	public Double getLatitude() {
		return latitude;
	}
}
