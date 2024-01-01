package libraryInterfaces;

public class HueSaturationInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "\\Libraries\\HueSaturationLibrary\\HueSaturationLib.dll";
        System.load(libraryPath);
    }

    public static native Pixel[][] applyHueSaturation(Pixel[][] image, float saturationValue, float hueValue);
}
