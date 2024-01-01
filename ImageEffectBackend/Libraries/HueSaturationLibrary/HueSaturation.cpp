#include "HueSaturation.h"
#include "../Pixel.h"
#include <vector>
#include <cmath>
using namespace std;


void applyHueSaturation(vector< vector<Pixel> > &imageVector, float saturationValue, float hueValue) {

    vector<vector<float>> matrix = {
        {0.3, 0.59, 0.11},
        {0.3, 0.59, 0.11},
        {0.3, 0.59, 0.11}
    };
    int n = imageVector.size();
    int m = imageVector[0].size();
    // Loop through each pixel in the image vector
    for (int i = 0; i < imageVector.size(); ++i) {
        for (int j = 0; j < imageVector[i].size(); ++j) {
            float r = 0, g = 0, b = 0;

            // Apply convolution to calculate new RGB values
            for (int ll = -1; ll <= 1; ++ll) {
                for (int nn = -1; nn <= 1; ++nn) {
                    int x = i + ll;
                    int y = j + nn;

                    // Check boundary conditions
                    if (x >= 0 && x < imageVector.size() && y >= 0 && y < imageVector[i].size()) {
                        r += imageVector[x][y].r * matrix[ll + 1][nn + 1];
                        g += imageVector[x][y].g * matrix[ll + 1][nn + 1];
                        b += imageVector[x][y].b * matrix[ll + 1][nn + 1];
                    }
                }
            }

            // Hue adjustment
            float h = atan2(b - g, sqrt((r - g) * (r - g) + (b - g) * (r - b))) * (180.0 / M_PI) + hueValue;

            // Saturation adjustment
            float s = sqrt((r - g) * (r - g) + (b - g) * (r - b) + (b - g) * (b - g));
            imageVector[i][j].r = s * cos(h) + g;
            imageVector[i][j].g = s * cos(h) + g;
            imageVector[i][j].b = s * cos(h) + b;
        }
    }
}


