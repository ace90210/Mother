package uk.ac.uea.nostromo.mother;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.SharedPreferences;

/**
 * File stream management system.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151204
 * @deprecated	{@code FileIO} lacks file access feature for streaming
 *				complex structures found in certain file formats. For
 *				file access see	{@code DataIO}.
 */
@Deprecated
public interface FileIO {
	/**
	 * Attempt to read from a file in a buffered fashion by opening a
	 * stream.
	 *
	 * @param	file	The on-disk filename of the file that should be
	 *					returned.
	 * @return	A stream representation of the file requested.
	 * @throws	java.io.IOException	In the event I/O fails.
	 * @since	v1.0.0-alpha+20151204
	 * @deprecated	See {@link DataIO#readFile(String)}.
	 */
	@Deprecated
	InputStream readFile(String file) throws IOException;

	/**
	 * Attempt to write to a file in a buffered fashion by opening a
	 * stream.
	 *
	 * @param	file	The on-disk filename of the file that should be
	 *					returned.
	 * @return	A stream representation of the file requested.
	 * @throws	java.io.IOException	In the event I/O fails.
	 * @since	v1.0.0-alpha+20151204
	 * @deprecated	See {@link DataIO#writeFile(String)}.
	 */
	@Deprecated
	OutputStream writeFile(String file) throws IOException;
    
	/**
	 * Attempt to read an asset in a buffered fashion by opening a
	 * stream.
	 *
	 * @param	file	The on-disk filename of the file that should be
	 *					returned.
	 * @return	A stream representation of the file requested.
	 * @throws	java.io.IOException	In the event I/O fails.
	 * @since	v1.0.0-alpha+20151204
	 * @deprecated	See {@link DataIO#readAsset(String)}.
	 */
	@Deprecated
	InputStream readAsset(String file) throws IOException;
    
	/**
	 * Gain access to the shared preferences of the user.
	 *
	 * @return	An access to the {@code SharedPreferences} object.
	 * @since	v1.0.0-alpha+20151204
	 * @deprecated	See {@link DataIO#getSharedPref()}.
	 */
	@Deprecated
	SharedPreferences getSharedPref();
}
