#include <vector>
#include "Sepia.h"
#include "../Pixel.h"

using namespace std;

void applySepia(vector<vector<Pixel>> &pixels){
    for(auto &row:pixels){
        for(auto &pixel:row){
            //Y=0.299⋅R+0.587⋅G+0.114⋅B
            pixel.r = min(0.393*pixel.r + 0.769*pixel.g + 0.189*pixel.b, 255.0);
            pixel.g = min(0.349*pixel.r + 0.686*pixel.g + 0.168*pixel.b, 255.0);
            pixel.b = min(0.272*pixel.r + 0.534*pixel.g + 0.131*pixel.b, 255.0);
        }
    }
}