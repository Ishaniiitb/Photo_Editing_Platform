#include <bits/stdc++.h>
#include<cmath>
#include "Contrast.h"
#include "../Pixel.h"

using namespace std;

// Contrast
void contrast(vector<vector<Pixel>> &pixels, float amount) {
        amount = amount - 50;
        float factor = (amount + 100.0f) / 100.0f;
        for (auto &row : pixels) {
            for (auto &pixel : row) {

                pixel.r = static_cast<int>((pixel.r - 128) * factor + 128);
                pixel.g = static_cast<int>((pixel.g - 128) * factor + 128);
                pixel.b = static_cast<int>((pixel.b - 128) * factor + 128);

                pixel.r = min(255, max(0, pixel.r));
                pixel.g = min(255, max(0, pixel.g));
                pixel.b = min(255, max(0, pixel.b));
            }
        }
    }
