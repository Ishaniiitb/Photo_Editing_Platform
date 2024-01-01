package libraryInterfaces;

public class SharpenInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "\\Libraries\\SharpenLibrary\\SharpenLib.dll";
        System.load(libraryPath);
    }

    public static native Pixel[][] applySharpen(Pixel[][] image, float amount);
}
