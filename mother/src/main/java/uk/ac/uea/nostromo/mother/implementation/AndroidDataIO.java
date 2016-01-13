/*
 * AndroidDataIO.java	v1.0.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother.implementation;

import android.content.Context;
import android.content.SharedPreferences;

import uk.ac.uea.nostromo.mother.*;

/**
 * {@inheritDoc}
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151227
 */
public class AndroidDataIO implements uk.ac.uea.nostromo.mother.DataIO {
	SharedPreferences preferences;


	/**
	 * {@inheritDoc}
	 *
	 * @since	v1.0.0-alpha+20151227
	 */
	@Override
	public java.io.InputStream readFile(String file) throws java.io.IOException {
		throw new UnsupportedOperationException("The method `AndroidDataIO.readFile(String)` is yet to be implemented.");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	v1.0.0-alpha+20151227
	 */
	@Override
	public java.io.OutputStream writeFile(String file) throws java.io.IOException {
		throw new UnsupportedOperationException("The method `AndroidDataIO.writeFile(String)` is yet to be implemented.");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	v1.0.0-alpha+20151227
	 */
	@Override
	public java.io.InputStream readAsset(String file) throws java.io.IOException {
		throw new UnsupportedOperationException("The method `AndroidDataIO.readAsset(String)` is yet to be implemented.");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	v1.0.0-alpha+20151227
	 */
	@Override
	public <T> void writeDataList(DataIOStrategy<T> writer, DataObject data) {
		throw new UnsupportedOperationException("The method `AndroidDataIO.writeDataList(DataIOStrategy<T>, DataObject)` is yet to be implemented.");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	v1.0.0-alpha+20151227
	 */
	@Override
	public <T> DataObject readDataList(DataIOStrategy<T> reader) {
		return reader.readData();
	}
    
	/**
	 * {@inheritDoc}
	 *
	 * @since	v1.0.0-alpha+20151227
	 */
	@Override
	public android.content.SharedPreferences getSharedPref(String prefName, Context context) {
		if(preferences == null)
			preferences = context.getSharedPreferences(prefName, 0);

		return preferences;
	}
}
