#include <vector>
#include "Invert.h"
#include "../Pixel.h"

using namespace std;

void InvertPicture(vector<vector<Pixel>>& pixels) { //amount should be between 0 and 100
    for (auto& row : pixels) {
        for (auto& pixel : row) {
            pixel.r = (255-pixel.r);    //invert the pixel
            pixel.g = (255-pixel.g);
            pixel.b = (255-pixel.b);
        }
    }
}
