/*
 * LocationManager.java	v1.2.0	2015-12-24
 */

package uk.ac.uea.nostromo.mother;

import android.util.Log;

/**
 * Manage a mapping of {@code Location} objects alongside a
 * <i>user-friendly</i> name that can be used to retrieve it.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.2.0
 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
 */
public class LocationManager implements android.location.LocationListener {
	/**
	 * Constant runtime representation of the class name that is used
	 * when logging information.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 * @see		android.util.Log
	 */
	private static final String TAG = "LocationManager";

	/**
	 * Private reference to our device's location manager so we can
	 * access our current location.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	private android.location.LocationManager locationManager;

	/**
	 * The last known location that we received from the system. We
	 * don't poll the system when location is requested.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 * @see		#onLocationChanged(android.location.Location)
	 */
	Location lastKnownLocation;

	/**
	 * Private data structure used to store the relationship between
	 * location names, and the actual locations themselves.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	private java.util.Map<String, Location> map;

	/**
	 * Basic constructor designed to provide an empty list of locations,
	 * and gain access to our systems location services.
	 *
	 * @throws	NullPointerException	In the event {@code Context.getSystemService(Context.LOCATION_SERVICE)}
	 *									fails to provide a non
	 *									{@code null} reference to the
	 *									location manager.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public LocationManager(android.content.Context context)
			throws NullPointerException {
		NullPointerException nullManager;

		map = new java.util.HashMap<String, Location>();

		locationManager = (android.location.LocationManager)
				context.getSystemService(
						android.content.Context.LOCATION_SERVICE);
		if (locationManager != null) {
			locationManager.requestLocationUpdates(
					android.location.LocationManager.GPS_PROVIDER, 0, 0, this);

			Log.v(TAG, "We've successfully requested location updates from " +
					"the system.");
		} else {
			nullManager = new NullPointerException(
					"The call `Context.getSystemService(Context.LOCATION_SERVICE)` returned `null`.");
			Log.e(TAG, "Our attempts at gaining a reference to the location " +
					"system service have failed.", nullManager);

			throw nullManager;
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	location	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 * @see		#lastKnownLocation
	 */
	@Override
	public void onLocationChanged(android.location.Location location) {
		lastKnownLocation = new Location(
				location.getLatitude(), location.getLongitude());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	provider	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	public void onProviderDisabled(String provider) {
		if (provider == android.location.LocationManager.GPS_PROVIDER) {
			Log.d(TAG, "The user has disabled the service provide we're " +
					"using for GPS location data.");
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	provider	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	public void onProviderEnabled(String provider) {
		if (provider == android.location.LocationManager.GPS_PROVIDER) {
			Log.v(TAG, "We've got access to the system's GPS provider again.");
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	provider	{@inheritDoc}
	 * @param	status		{@inheritDoc}
	 * @param	extras		{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	public void onStatusChanged(String provider, int status, android.os.Bundle extras) {
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
	 * Get the current -- or at worst, the most recent -- location of the
	 * device.
	 *
	 * @return	A {@code Location} object containing the current
	 *			location.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	public Location getCurrentLocation() {
		return lastKnownLocation;
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
