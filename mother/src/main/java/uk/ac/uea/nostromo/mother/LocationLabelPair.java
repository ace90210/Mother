/*
 * LocationLabelPair.java	v1.1.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother;

/**
 * A {@code String}-{@code Location} pairing that allows locations to be
 * stored in a map.
 *
 * <p>This is necessary because Java has no pair class. The language
 * that "has it all", has no concept of a tuple.</p>
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.1.0
 * @since	v1.0.0-alpha+20151227
 */
public class LocationLabelPair {
	/**
	 * A human readable description of the location that is stored
	 * alongside this string.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	String locationLabel;

	/**
	 * The actual coordinates of this location-label pair.
	 */
	Location coordinates;

	/**
	 * Modify the internal <em>human-readable</em> name for this
	 * location.
	 *
	 * @param	label	The new name for this location.
	 * @since	@since	v1.0.0-alpha+20151227
	 */
	public void setLabel(String label) {
		locationLabel = label;
	}

	/**
	 * Change the stored location for this pairing.
	 *
	 * @param	location	The new GPS location for this pairing.
	 * @since	@since	v1.0.0-alpha+20151227
	 */
	public void setLocation(Location location) {
		coordinates = location;
	}

	/**
	 * Returns the value representing the longitude of this location.
	 *
	 * @return	The label portion of this pairing.
	 * @since	@since	v1.0.0-alpha+20151227
	 */
	public String getLabel() {
		return locationLabel;
	}

	/**
	 * Returns the value representing the longitude of this location.
	 *
	 * @return	The location portion of this pairing.
	 * @since	@since	v1.0.0-alpha+20151227
	 */
	public Location getLocation() {
		return coordinates;
	}
}
