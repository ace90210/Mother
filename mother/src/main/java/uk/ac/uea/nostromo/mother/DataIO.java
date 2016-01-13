/*
 * DataIO.java	v1.0.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother;

import android.content.Context;

/**
 * An organised interface designed for file access through either
 * streams, or through the {@code DataIOStrategy} mechanism.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151227
 */
public interface DataIO {
	/**
	 * Attempt to read from a file in a buffered fashion by opening a
	 * stream.
	 *
	 * @param	file	The on-disk filename of the file that should be
	 *					returned.
	 * @return	A stream representation of the file requested.
	 * @throws	java.io.IOException	In the event I/O fails.
	 * @since	v1.0.0-alpha+20151227
	 */
	java.io.InputStream readFile(String file) throws java.io.IOException;

	/**
	 * Attempt to write to a file in a buffered fashion by opening a
	 * stream.
	 *
	 * @param	file	The on-disk filename of the file that should be
	 *					returned.
	 * @return	A stream representation of the file requested.
	 * @throws	java.io.IOException	In the event I/O fails.
	 * @since	v1.0.0-alpha+20151227
	 */
	java.io.OutputStream writeFile(String file) throws java.io.IOException;
    
	/**
	 * Attempt to read an asset in a buffered fashion by opening a
	 * stream.
	 *
	 * @param	file	The on-disk filename of the file that should be
	 *					returned.
	 * @return	A stream representation of the file requested.
	 * @throws	java.io.IOException	In the event I/O fails.
	 * @since	v1.0.0-alpha+20151227
	 */
	java.io.InputStream readAsset(String file) throws java.io.IOException;

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	writer	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @param	data	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	v1.0.0-alpha+20151227
	 */
	<T> void writeDataList(DataIOStrategy<T> writer, DataObject data);

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	reader	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	v1.0.0-alpha+20151227
	 */
	<T> DataObject readDataList(DataIOStrategy<T> reader);
    
	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param prefName The name of the preference file to load
	 * @param context The application context
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	v1.0.0-alpha+20151227
	 */
	android.content.SharedPreferences getSharedPref(String prefName, Context context);
}
