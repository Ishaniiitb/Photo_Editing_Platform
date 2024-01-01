package libraryInterfaces;

public class RotationInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "\\Libraries\\RotationLibrary\\RotationLib.dll";
        System.load(libraryPath);
    }

    public static native Pixel[][] applyRotation(Pixel[][] image, int value);
}
