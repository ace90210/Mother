/*
 * LocationManager.java	v1.1.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother;

import android.util.Log;

/**
 * Manage a mapping of {@code Location} objects alongside a
 * <i>user-friendly</i> name that can be used to retrieve it.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.1.0
 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
 */
public class LocationManager {
	/**
	 * Constant runtime representation of the class name that is used
	 * when logging information.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 * @see		android.util.Log
	 */
	private static final String TAG = "LocationManager";

	/**
	 * Private data structure used to store the relationship between
	 * location names, and the actual locations themselves.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	private java.util.Map<String, Location> map;

	/**
	 * Simple constructor.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public LocationManager() {
		map = new java.util.HashMap<String, Location>();
	}

	/**
	 * Get the location that is referred to by a given name.
	 *
	 * @param	label	The name of the {@code Location} object desired.
	 * @return	The location, if one exists, matching the presented
	 *			name.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public Location getLocation(String label) {
		Location location;

		location = map.get(label);
		if (location == null) {
			Log.w(TAG, "getLocation(String) is returning a location that is " +
					"`null`. This isn't operating procedure!");
		}

		return location;
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
	 * @see		#setLocation(String, Location)
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void addLocation(String label) {
		Location location;

		Log.i(TAG, "Attempting to add the location name \'" + label + "\' to " +
				"the location manager.");

		location = map.put(label, null);
		if (location != null) {
			Log.w(TAG, "We've overwritten a location in our manager! Our " +
					"lost location was marked at: " + location + ".");
		}
	}

	/**
	 * Remove a location from the manager via its assigned name.
	 *
	 * @param	label 	The name of the location that should be removed
	 *					internally.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void removeLocation(String label) {
		Location location;

		Log.i(TAG, "The location \'" + label + "\' is being removed from the " +
				"location manager.");

		location = map.remove(label);
		if (location != null) {
			Log.d(TAG, "We successfully removed \'" + label + "\'. Its last " +
					"location was: " + location + ".");
		} else {
			Log.d(TAG, "Our location manager never contained \'" + label
					+ "\'.");
		}
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
	 * @see		#addLocation(String)
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public void setLocation(String label, Location location) {
		Location previous;

		previous = map.put(label, location);
		if (previous != null) {
			Log.d(TAG, "The location \'" + label + "\' was updated from "
					+ previous + " to " + location + ".");
		}
	}
}
