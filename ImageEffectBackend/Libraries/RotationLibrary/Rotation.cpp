#include <vector>
#include "Rotation.h"
#include "../Pixel.h"

using namespace std;


void rotate(vector<vector<Pixel>> &pixels, int val){  //i can take values 0 1 2 3, that corresponds to 0 90 180 270 =
    Pixel def;
    def.r = 0;
    def.g = 0;
    def.b = 0;
    while(val--){
       int n = pixels.size();
       int m = pixels[0].size();
       vector<vector<Pixel>> temp(m, vector<Pixel>(n, def));
       for(int i=0; i<n; ++i){
            for(int j=0; j<m; j++){
                temp[j][n-1-i] = pixels[i][j];
            }
       }
       pixels = temp;
    }
}

