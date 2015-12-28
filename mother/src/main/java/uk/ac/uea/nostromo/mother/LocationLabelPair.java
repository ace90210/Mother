/*
 * LocationLabelPair.java	v1.0.0	2015-12-02
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
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151227
 */
public class LocationLabelPair {
	/**
	 * Modify the internal <i>human-readable</i> name for this location.
	 *
	 * @param	label	The new name for this location.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	v1.0.0-alpha+20151227
	 */
	public void setLabel(String label) {
		throw new UnsupportedOperationException("The method `LocationLabelPair.setLabel(String)` is yet to be implemented.");
	}

	/**
	 * Change the stored location for this pairing.
	 *
	 * @param	location	The new GPS location for this pairing.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	v1.0.0-alpha+20151227
	 */
	public void setLocation(Location location) {
		throw new UnsupportedOperationException("The method `LocationLabelPair.setLocation(Location)` is yet to be implemented.");
	}

	/**
	 * Returns the value representing the longitude of this location.
	 *
	 * @return	The label portion of this pairing.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	v1.0.0-alpha+20151227
	 */
	public String getLabel() {
		throw new UnsupportedOperationException("The method `LocationLabelPair.getLabel()` is yet to be implemented.");
	}

	/**
	 * Returns the value representing the longitude of this location.
	 *
	 * @return	The location portion of this pairing.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	v1.0.0-alpha+20151227
	 */
	public Location getLocation() {
		throw new UnsupportedOperationException("The method `LocationLabelPair.getLocation()` is yet to be implemented.");
	}
}
