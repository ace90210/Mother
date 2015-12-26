/*
 * Disposable.java	v1.0.0	2015-11-29
 */

package uk.ac.uea.nostromo.mother;

/**
 * A {@code Disposable} object is an object that is able to release its
 * internal resources once it has been told it is no long required.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151204
 */
public interface Disposable {
	/**
	 * Proceed to release any internally held resources.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
	void dispose();
}
