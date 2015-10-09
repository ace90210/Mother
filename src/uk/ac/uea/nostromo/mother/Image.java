package uk.ac.uea.nostromo.mother;

import uk.ac.uea.nostromo.mother.Graphics.ImageFormat;

public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}
