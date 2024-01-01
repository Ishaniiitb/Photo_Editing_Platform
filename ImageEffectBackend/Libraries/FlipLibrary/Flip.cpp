#include <vector>
#include <algorithm>
#include "../Pixel.h"
#include "Flip.h"

using namespace std;
// Function to flip the vector of vector of pixels horizontally and/or vertically depending on parameters
void flipImage(vector<vector<Pixel>>& pixels, int flipHorizontal, int flipVertical) {
    if (flipHorizontal) {
        for (auto& row : pixels) {
            reverse(row.begin(), row.end());
        }
    }
    if (flipVertical) {
        reverse(pixels.begin(), pixels.end());
    }
}
