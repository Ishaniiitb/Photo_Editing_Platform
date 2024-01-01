#include <vector>
#include "GaussianBlur.h"
#include "../Pixel.h"
#include <cmath>
using namespace std;

void blurpicture(vector<vector<Pixel>>& image, float amount) {
    int kernelSize = (int)(amount/20);

    int width = image[0].size();
    int height = image.size();
    vector<float> kernel1D;
    for (int i = -kernelSize / 2; i <= kernelSize / 2; ++i) {
        float value = exp(-(i * i) / (2 * pow(kernelSize / 2.0, 2))) / (sqrt(2 * M_PI) * (kernelSize / 2.0));
        kernel1D.push_back(value);
    }

    // Normalize the kernel
    float sum = 0;
    for (float value : kernel1D) {
        sum += value;
    }
    for (float& value : kernel1D) {
        value /= sum;
    }

    // Apply the 1D kernel vertically and then horizontally
    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
            Pixel blurredPixel;
            blurredPixel.r = blurredPixel.b = blurredPixel.g = 0;

            for (int i = -kernelSize / 2; i <= kernelSize / 2; ++i) {
                int offsetX =  max(0,  min(x + i, width - 1));
                int offsetY =  max(0,  min(y + i, height - 1));

                blurredPixel.r += kernel1D[i + kernelSize / 2] * image[offsetY][x].r;
                blurredPixel.g += kernel1D[i + kernelSize / 2] * image[offsetY][x].g;
                blurredPixel.b += kernel1D[i + kernelSize / 2] * image[offsetY][x].b;
            }

            image[y][x] = blurredPixel;
        }
    }

    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
            Pixel blurredPixel;
            blurredPixel.r = blurredPixel.b = blurredPixel.g = 0;

            for (int i = -kernelSize / 2; i <= kernelSize / 2; ++i) {
                int offsetY =  max(0,  min(y + i, height - 1));
                int offsetX =  max(0,  min(x + i, width - 1));

                blurredPixel.r += kernel1D[i + kernelSize / 2] * image[y][offsetX].r;
                blurredPixel.g += kernel1D[i + kernelSize / 2] * image[y][offsetX].g;
                blurredPixel.b += kernel1D[i + kernelSize / 2] * image[y][offsetX].b;
            }

            image[y][x] = blurredPixel;
        }
    }
}