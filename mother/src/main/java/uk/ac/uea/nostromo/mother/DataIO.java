/*
 * DataIO.java	v1.0.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother;

/**
 * An organised interface designed for file access through either
 * streams, or through the {@code DataIOStrategy} mechanism.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
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
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
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
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
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
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	java.io.InputStream readAsset(String file) throws java.io.IOException;

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	writer	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @param	data	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	<T> void writeDataList(DataIOStrategy<T> writer, DataObject data);

	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @param	reader	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	<T> DataObject readDataList(DataIOStrategy<T> reader);
    
	/**
	 * !_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 *
	 * @return	!_TODO__ [Alex Melbourne] : Write this piece of documentation.
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	android.content.SharedPreferences getSharedPref();
}
