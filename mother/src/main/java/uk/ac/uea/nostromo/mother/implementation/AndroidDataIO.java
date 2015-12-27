/*
 * AndroidDataIO.java	v1.0.0	2015-12-23
 */

package uk.ac.uea.nostromo.mother.implementation;

import uk.ac.uea.nostromo.mother.*;

/**
 * {@inheritDoc}
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
 */
public class AndroidDataIO implements uk.ac.uea.nostromo.mother.DataIO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.io.InputStream readFile(String file) throws java.io.IOException {
		throw new UnsupportedOperationException("The method `AndroidDataIO.readFile(String)` is yet to be implemented.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.io.OutputStream writeFile(String file) throws java.io.IOException {
		throw new UnsupportedOperationException("The method `AndroidDataIO.writeFile(String)` is yet to be implemented.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.io.InputStream readAsset(String file) throws java.io.IOException {
		throw new UnsupportedOperationException("The method `AndroidDataIO.readAsset(String)` is yet to be implemented.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> void writeDataList(DataIOStrategy<T> writer, DataObject data) {
		throw new UnsupportedOperationException("The method `AndroidDataIO.writeDataList(DataIOStrategy<T>, DataObject)` is yet to be implemented.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> DataObject readDataList(DataIOStrategy<T> reader) {
		throw new UnsupportedOperationException("The method `AndroidDataIO.readDataList(DataIOStrategy<T>)` is yet to be implemented.");
	}
    
	/**
	 * {@inheritDoc}
	 */
	@Override
	public android.content.SharedPreferences getSharedPref() {
		throw new UnsupportedOperationException("The method `AndroidDataIO.getSharedPref()` is yet to be implemented.");
	}
}
