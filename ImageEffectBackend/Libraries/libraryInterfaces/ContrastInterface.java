package libraryInterfaces;

public class ContrastInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "\\Libraries\\ContrastLibrary\\ContrastLib.dll";
        System.load(libraryPath);
    }

    public static native Pixel[][] applyContrast(Pixel[][] image, float amount);
}
