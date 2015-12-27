/*
 * LocationManager.java	v1.0.0	2015-12-02
 */

package uk.ac.uea.nostromo.mother;

/**
 * Manage a mapping of {@code Location} objects alongside a
 * <i>user-friendly</i> name that can be used to retrieve it.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
 */
public class LocationManager {
	/**
	 * Get the location that is referred to by a given name.
	 *
	 * @param	label	The name of the {@code Location} object desired.
	 * @return	The location, if one exists, matching the presented
	 *			name.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public Location getLocation(String label) {
		throw new UnsupportedOperationException("The method `LocationManager.getLocation(String)` is yet to be implemented.");
	}

	/**
	 * Get the current -- or at best, the most recent -- location of the
	 * device.
	 *
	 * @return	A {@code Location} object containing the current
	 *			location.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public Location getCurrentLocation() {
		throw new UnsupportedOperationException("The method `LocationManager.getCurrentLocation()` is yet to be implemented.");
	}

	/**
	 * Insert a name into the manager without assigning an actual
	 * location.
	 *
	 * <p>This method is only capable of allocating space for a new
	 * location. To set the location follow up with a call to
	 * {@link #setLocation(String, Location) setLocation(String, Location)}</p>
	 *
	 * @param	label	The name that should be assigned to a new
	 *					pairing.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @see		#setLocation(String, Location)
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void addLocation(String label) {
		throw new UnsupportedOperationException("The method `LocationManager.addLocation(String)` is yet to be implemented.");
	}

	/**
	 * Remove a location from the manager via its assigned name.
	 *
	 * @param	label 	The name of the location that should be removed
	 *					internally.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void removeLocation(String label) {
		throw new UnsupportedOperationException("The method `LocationManager.removeLocation(String)` is yet to be implemented.");
	}

	/**
	 * Use the label-location pairing system to set the location of an already defined location label.
	 *
	 * <p>This method <b>does not</b> create new entries in the map. To
	 * create entries use the
	 * {@link #addLocation(String) addLocation(String)} method.</p>
	 *
	 * @param	label		The label of the location that is to be set.
	 * @param	location	The new location.
	 * @throws	UnsupportedOperationException	In all cases. This
	 *			method is yet to be implemented.
	 * @see		#addLocation(String)
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void setLocation(String label, Location location) {
		throw new UnsupportedOperationException("The method `LocationManager.setLocation(String, Location)` is yet to be implemented.");
	}
}
