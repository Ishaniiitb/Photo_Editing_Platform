#include <vector>
#include "Invert.h"
#include "../Pixel.h"

using namespace std;

void InvertPicture(vector<vector<Pixel>>& pixels) {
    for (auto& row : pixels) {
        for (auto& pixel : row) {
            pixel.r = (255-pixel.r);
            pixel.g = (255-pixel.g);
            pixel.b = (255-pixel.b);
        }
    }
}
