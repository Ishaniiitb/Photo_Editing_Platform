#include <bits/stdc++.h>
#include<cmath>
#include "../Pixel.h"

using namespace std;

// Contrast
void contrast(vector<vector<Pixel>> &pixels, float amount) {
    float factor = 259*(255+(amount-50))/255*(259-(amount-50));
    for(auto &row : pixels){
        for(auto &pixel : row){
            pixel.r = trunc(factor*(pixel.r-128)+128);
            pixel.g = trunc(factor*(pixel.b-128)+128);
            pixel.b = trunc(factor*(pixel.g-128)+128);
        }
    }

}