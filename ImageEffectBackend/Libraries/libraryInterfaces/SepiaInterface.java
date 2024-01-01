package libraryInterfaces;

public class SepiaInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "\\Libraries\\SepiaLibrary\\SepiaLib.dll";
        System.load(libraryPath);
    }

    public static native Pixel[][] applySepia(Pixel[][] image);
}
