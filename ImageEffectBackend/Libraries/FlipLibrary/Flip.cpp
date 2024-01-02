#include <vector>
#include <algorithm>
#include "../Pixel.h"
#include "Flip.h"

using namespace std;
// Function to flip the vector of vector of pixels horizontally and/or vertically depending on parameters
void flipImage(vector<vector<Pixel>>& pixels, int flipHorizontal, int flipVertical) {   //flipHorizontal and flipVertical should be either 0 or 1
    if (flipHorizontal) {
        for (auto& row : pixels) {
            reverse(row.begin(), row.end());    //reverse the pixels in each row
        }
    }
    if (flipVertical) {
        reverse(pixels.begin(), pixels.end());  //reverse the rows
    }
}
