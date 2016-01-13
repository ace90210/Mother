package uk.ac.uea.nostromo.mother.implementation;

import android.location.Location;
import android.os.Handler;

import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.model.LatLng;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MockLocationSource implements LocationSource {

    private static final LatLng CENTER = new LatLng(52.622033, 1.242426);

    private static final long UPDATE_PERIOD = TimeUnit.SECONDS.toMillis(2);

    private final Handler handler = new Handler();
    private LatLng lastCoordinate = CENTER;
    private OnLocationChangedListener listener;

    private void scheduleNewFix() {
        handler.postDelayed(updateLocationRunnable, UPDATE_PERIOD);
    }

    private final Runnable updateLocationRunnable = new Runnable() {

        @Override
        public void run() {
            Location currentLocation = generateLocation();
            listener.onLocationChanged(currentLocation);
            scheduleNewFix();
        }
    };

    public Location generateLocation() {

        Location location = new Location(getClass().getSimpleName());
        location.setLatitude(lastCoordinate.latitude);
        location.setLongitude(lastCoordinate.longitude);

        lastCoordinate = new LatLng(location.getLatitude(), location.getLongitude());

        return location;
    }

    @Override
    public void activate(LocationSource.OnLocationChangedListener locationChangedListener) {
        listener = locationChangedListener;
        scheduleNewFix();
    }

    @Override
    public void deactivate() {
        handler.removeCallbacks(updateLocationRunnable);
    }

}