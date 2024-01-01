package libraryInterfaces;

public class GrayscaleInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "\\Libraries\\GrayscaleLibrary\\GrayscaleLib.dll";
        System.load(libraryPath);
    }

    public static native Pixel[][] applyGrayscale(Pixel[][] image);
}
