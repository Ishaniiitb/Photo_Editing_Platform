#include <vector>
#include "Sharpen.h"
#include "../Pixel.h"
using namespace std;

void sharpenpicture(vector<vector<Pixel>> &pixels,double slider){
    vector<vector<double>> kernel={{0,-1,0},{-1,-5,-1},{0,-1,0}};
    Pixel defaultpixel;
    defaultpixel.r=0;
    defaultpixel.g=0;
    defaultpixel.b=0;

    vector<vector<Pixel>> cpy;
    for(int i=0; i<3; i++){
        vector<Pixel> temp;
        for(int j=0; j<3; j++){
            temp.push_back(defaultpixel);
        }
        cpy.push_back(temp);
    }

    int numRows=pixels.size();
    int numCols=pixels[0].size();
    for(int i=0;i<numRows;i++){
        for(int j=0;j<numCols;j++){
            if(i-1==-1) cpy[0][0]=cpy[0][1]=cpy[0][2]=defaultpixel;
            else {
                cpy[0][1]=pixels[i-1][j];
                if(j-1==-1) cpy[0][0]=defaultpixel;
                else cpy[0][0]=pixels[i-1][j-1];
                if(j+1==numCols) cpy[0][2]=defaultpixel;
                else cpy[0][2]=pixels[i-1][j+1];
            }
            if(i+1==numRows) cpy[2][0]=cpy[2][1]=cpy[2][2]=defaultpixel;
            else {
                cpy[2][1]=pixels[i+1][j];
                if(j-1==-1) cpy[2][0]=defaultpixel;
                else cpy[2][0]=pixels[i+1][j-1];
                if(j+1==numCols) cpy[2][2]=defaultpixel;
                else cpy[2][2]=pixels[i+1][j+1];
            }
            cpy[1][1]=pixels[i][j];
            if(j-1==-1) cpy[1][0]=defaultpixel;
            else cpy[1][0]=pixels[i][j-1];
            if(j+1==numCols) cpy[1][2]=defaultpixel;
            else cpy[1][2]=pixels[i][j+1];

            if(slider==0){
                pixels[i][j].r=min(255,kernel[0][0]*cpy[0][0].r+kernel[0][1]*cpy[0][1].r+kernel[0][2]*cpy[0][2].r+kernel[1][0]*cpy[1][0].r+kernel[1][1]*cpy[1][1].r+kernel[1][2]*cpy[1][2].r+kernel[2][0]*cpy[2][0].r+kernel[2][1]*cpy[2][1].r+kernel[2][2]*cpy[2][2].r);
                pixels[i][j].b=min(255,kernel[0][0]*cpy[0][0].b+kernel[0][1]*cpy[0][1].b+kernel[0][2]*cpy[0][2].b+kernel[1][0]*cpy[1][0].b+kernel[1][1]*cpy[1][1].b+kernel[1][2]*cpy[1][2].b+kernel[2][0]*cpy[2][0].b+kernel[2][1]*cpy[2][1].b+kernel[2][2]*cpy[2][2].b);
                pixels[i][j].g=min(255,kernel[0][0]*cpy[0][0].g+kernel[0][1]*cpy[0][1].g+kernel[0][2]*cpy[0][2].g+kernel[1][0]*cpy[1][0].g+kernel[1][1]*cpy[1][1].g+kernel[1][2]*cpy[1][2].g+kernel[2][0]*cpy[2][0].g+kernel[2][1]*cpy[2][1].g+kernel[2][2]*cpy[2][2].g);
            }
            else{
                pixels[i][j].r=min(255,(kernel[0][0]*cpy[0][0].r+kernel[0][1]*cpy[0][1].r+kernel[0][2]*cpy[0][2].r+kernel[1][0]*cpy[1][0].r+kernel[1][1]*cpy[1][1].r+kernel[1][2]*cpy[1][2].r+kernel[2][0]*cpy[2][0].r+kernel[2][1]*cpy[2][1].r+kernel[2][2]*cpy[2][2].r)*(slider/2));
                pixels[i][j].b=min(255,(kernel[0][0]*cpy[0][0].b+kernel[0][1]*cpy[0][1].b+kernel[0][2]*cpy[0][2].b+kernel[1][0]*cpy[1][0].b+kernel[1][1]*cpy[1][1].b+kernel[1][2]*cpy[1][2].b+kernel[2][0]*cpy[2][0].b+kernel[2][1]*cpy[2][1].b+kernel[2][2]*cpy[2][2].b)*(slider/2));
                pixels[i][j].g=min(255,(kernel[0][0]*cpy[0][0].g+kernel[0][1]*cpy[0][1].g+kernel[0][2]*cpy[0][2].g+kernel[1][0]*cpy[1][0].g+kernel[1][1]*cpy[1][1].g+kernel[1][2]*cpy[1][2].g+kernel[2][0]*cpy[2][0].g+kernel[2][1]*cpy[2][1].g+kernel[2][2]*cpy[2][2].g)*(slider/2));
            }

        }
    }
}