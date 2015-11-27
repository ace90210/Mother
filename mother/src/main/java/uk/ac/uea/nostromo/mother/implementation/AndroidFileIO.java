package uk.ac.uea.nostromo.mother.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Environment;
import android.preference.PreferenceManager;

import uk.ac.uea.nostromo.mother.FileIO;

/**
 * Handles to loading of assets and general files for the game.
 */
public class AndroidFileIO implements FileIO {
    Context context;
    AssetManager assets;
    String externalStoragePath;

	/**
	 * Class Constructor
	 *
	 * @param context The current Android context.
	 */
    public AndroidFileIO(Context context) {
        this.context = context;
        this.assets = context.getAssets();
        this.externalStoragePath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator;
        
 
    
    }

	/**
	 * Get an InputStream for the specified asset file.
	 * This stream can be used to load in the specified asset.
	 * @param file The filename of the asset to be loaded.
	 * @return An InputStream to the specified file.
	 * @throws IOException
	 */
    @Override
    public InputStream readAsset(String file) throws IOException {
        return assets.open(file);
    }

	/**
	 * Get an InputStream for the specified general file stored in the external data path.
	 * This stream can be used to load in the specified file data.
	 * @param file The filename of the asset to be loaded.
	 * @return An InputStream to the specified file.
	 * @throws IOException
	 */
    @Override
    public InputStream readFile(String file) throws IOException {
        return new FileInputStream(externalStoragePath + file);
    }

	/**
	 * Get an OutputStream for the specified general file.
	 * This stream can be used to write to the specified file data.
	 *
	 * Note: Data will be stored in the external data path.
	 * @param file The filename for the data to be written.
	 * @return An OutputStream to the specified file.
	 * @throws IOException
	 */
    @Override
    public OutputStream writeFile(String file) throws IOException {
        return new FileOutputStream(externalStoragePath + file);
    }
    
	/**
	 * Get a reference to the default shared preferences object for the current context.
	 * @return A SharedPreferences object for the current contexts shared preferences.
	 */
    public SharedPreferences getSharedPref() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
