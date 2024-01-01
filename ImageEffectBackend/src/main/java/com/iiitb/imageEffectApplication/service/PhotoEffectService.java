package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.effectImplementation.*;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;
import libraryInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            hueAmount /= 2;
            saturationAmount /= 2;
            System.out.println("Hue: " + hueAmount);
            System.out.println("Saturation: " + saturationAmount);
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            HueSaturationEffect hueSaturationEffect = new HueSaturationEffect();
            hueSaturationEffect.setParameterValues(hueAmount, saturationAmount);
            Pixel[][] modifiedImage = hueSaturationEffect.apply(inputImage, imageName, loggingService);
            loggingService = hueSaturationEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            amount /= 2;
            System.out.println("Amount: " + amount);
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage;
            BrightnessEffect brightnessEffect = new BrightnessEffect();
            brightnessEffect.setParameterValue(amount);
            modifiedImage = brightnessEffect.apply(inputImage, imageName, loggingService);
            loggingService = brightnessEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            amount /= 2;
            System.out.println("Amount: " + amount);
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage;
            ContrastEffect contrastEffect = new ContrastEffect();
            contrastEffect.setParameterValue(amount);
            modifiedImage = contrastEffect.apply(inputImage, imageName, loggingService);
            loggingService = contrastEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            System.out.println("Horizontal: " + horizontalFlipValue);
            System.out.println("Vertical: " + verticalFlipValue);
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            FlipEffect flipEffect = new FlipEffect();
            flipEffect.setParameterValues(horizontalFlipValue, verticalFlipValue);
            Pixel[][] modifiedImage = flipEffect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image
            loggingService = flipEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            System.out.println("Radius: " + radius);
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            GaussianBlurEffect gaussianBlurEffect = new GaussianBlurEffect();
            gaussianBlurEffect.setParameterValue(radius);
            Pixel[][] modifiedImage = gaussianBlurEffect.apply(inputImage, imageName, loggingService);
            loggingService = gaussianBlurEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage;
            GrayScaleEffect grayScaleEffect = new GrayScaleEffect();
            modifiedImage = grayScaleEffect.apply(inputImage, imageName, loggingService);
            loggingService = grayScaleEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage;
            InvertEffect invertEffect = new InvertEffect();
            modifiedImage = invertEffect.apply(inputImage, imageName, loggingService);
            loggingService = invertEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            System.out.println("Rotation: " + value);
            System.out.println("Inside Rotation");
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            RotationEffect rotationEffect = new RotationEffect();
            rotationEffect.setParameterValue(value);
            Pixel[][] modifiedImage = rotationEffect.apply(inputImage, imageName, loggingService);
            loggingService =rotationEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage;
            SepiaEffect sepiaEffect = new SepiaEffect();
            modifiedImage = sepiaEffect.apply(inputImage, imageName, loggingService);
            loggingService = sepiaEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            System.out.println("Amount: " + amount);
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            SharpenEffect sharpenEffect = new SharpenEffect();
            sharpenEffect.setParameterValue(amount);
            Pixel[][] modifiedImage = sharpenEffect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image
            loggingService = sharpenEffect.getLoggingService();
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
