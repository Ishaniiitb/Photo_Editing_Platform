#include <vector>
#include "Brightness.h"
#include "../Pixel.h"

using namespace std;

void brightenPicture(vector<vector<Pixel>>& pixels, int amount) { //amount should be between 0 and 100
    for (auto& row : pixels) {
        for (auto& pixel : row) {
            if(amount>=50){
                pixel.r = pixel.r + ((255-pixel.r)/50)*(amount-50);
                pixel.g = pixel.g + ((255-pixel.g)/50)*(amount-50);
                pixel.b = pixel.b + ((255-pixel.b)/50)*(amount-50);
            }
            else{
                pixel.r = pixel.r + ((pixel.r)/50)*(amount-50);
                pixel.g = pixel.g + ((pixel.g)/50)*(amount-50);
                pixel.b = pixel.b + ((pixel.b)/50)*(amount-50);
            }
        }
    }
}
