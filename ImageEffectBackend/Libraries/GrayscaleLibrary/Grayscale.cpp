#include <vector>
#include "Grayscale.h"
#include "../Pixel.h"

using namespace std;

void applyGrayscale(vector<vector<Pixel>> &pixels){
    for(auto &row:pixels){
        for(auto &pixel:row){
            //Y=0.299⋅R+0.587⋅G+0.114⋅B
            double gray = min(0.299*pixel.r + 0.587*pixel.g + 0.114*pixel.b, 255.0);
            pixel.r = gray;
            pixel.g = gray;
            pixel.b = gray;
        }
    }
}