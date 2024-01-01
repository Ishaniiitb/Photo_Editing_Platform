package libraryInterfaces;

public class DominantColourInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "\\Libraries\\DominantColourLibrary\\DominantColourLib.dll";
        System.load(libraryPath);
    }

    public static native Pixel[][] applyDominantColour(Pixel[][] image);
}
