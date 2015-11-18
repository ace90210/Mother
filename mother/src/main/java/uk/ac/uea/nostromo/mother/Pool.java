package uk.ac.uea.nostromo.mother;

import java.util.ArrayList;
import java.util.List;

/**
 * Techniques for creating and managing a memory pool of resources.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @param	<T>	The type of object to be created, and stored in the
 *				pool.
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 * @see		Pool.PoolObjectFactory
 */
public class Pool<T> {
	/**
	 * Factory abstraction
	 *
	 * @author	Unascribed
	 * @version	v1.0.0
	 * @param	<T>	The type of object to be created, and stored in the
	 *				pool.
	 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
	 */
    public interface PoolObjectFactory<T> {
		T createObject();
    }

	/**
	 * A list of objects that allocated but consider free for use.
	 */
    private final List<T> freeObjects;
	/**
	 * A factor used to allocate new objects.
	 */
    private final PoolObjectFactory<T> factory;
	/**
	 * The maximum number of allocated objects.
	 */
    private final int maxSize;

	/**
	 * Construct a new memory pool.
	 *
	 * @param	factory	The factory that should be used to construct
	 *			new objects.
	 * @param	maxSize	The maximum number of objects that should be
	 *					allocated.
	 */
    public Pool(PoolObjectFactory<T> factory, int maxSize) {
        this.factory = factory;
        this.maxSize = maxSize;
        this.freeObjects = new ArrayList<T>(maxSize);
    }

	/**
	 * Construct a new object.
	 *
	 * @return	A new object.
	 */
    public T newObject() {
        T object = null;

        if (freeObjects.size() == 0)
            object = factory.createObject();
        else
            object = freeObjects.remove(freeObjects.size() - 1);

        return object;
    }

	/**
	 * Free a given object.
	 *
	 * @param	object	The object that is to be freed.
	 */
    public void free(T object) {
        if (freeObjects.size() < maxSize)
            freeObjects.add(object);
    }
}
