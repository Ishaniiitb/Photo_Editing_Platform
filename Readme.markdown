# Programming-2 Project - Image Effects

## A web application to edit images using the following tech stack -

-   `Java`

-   `C++`

-   `HTML/CSS`

-  `Angular`

## Overview

This editor can apply the following effects on an uploaded image -

-   `Brightness`

-   `Contrast`

-   `Flip`

-   `Rotation`

-   `Gaussian Blur`

-   `Grayscale`

-  ` Hue Saturation`

-   `Invert colours`

-   `Sepia`

-   `Sharpen`



It also implements a logging system in which you can see the changes
made to your image.
##

## How to start it

*1*.  Open the **P2_Proj_2023** folder on the terminal or on Intellij.

*2*.  Head over to the **ImageEffectFrontEnd** folder through the
    > terminal.

    -   Type the command *"npm install"* to install all the node
        > packages needed to run angular and the front end.

    -   After the installation, type *"ng serve"* on the terminal, which
        > starts the front end.

*3*.  Now go to the **ImageEffectBackEnd** folder in the terminal.

    -   Type *"make"* on the terminal to run the MakeFile. This compiles
        > all the C++ files, generates the interface (between Java and
        > C++) header files and dumps the executable files into a *.dll*
        > (for Windows) or a *.so* (for Linux) file.

    -   Under **src\\main\\java\\com.iiitb.imageEffectApplication**,
        > execute the Java class named "ImageEffectApplication". This
        > starts the SpringBoot Application.

> The website will be up and working now.

Features

*1*.  `Brightness`

> This feature makes the image dimmer or brighter based on the slider
> value specified.
>
> ![](ReadmeImages/media/image12.png)

*2*.  `Contrast`

This adjusts the contrast of the image based on the slider value
specified.

![](ReadmeImages/media/image5.png)

*3*. ` Flip`

This flips the image either vertically or horizontally.

![](ReadmeImages/media/image1.png)

*4*.  `Rotation`

This rotates the image in 4 different angles.

![](ReadmeImages/media/image10.png)

*5*.  `Gaussian Blur`

> This makes the image blurry based on the slider value specified.
>
> ![](ReadmeImages/media/image11.png)

*6*.  `Grayscale`

> This changes the RGB values of the pixels of the image to the
> corresponding grayscale.
>
> ![](ReadmeImages/media/image6.png)

*7*.  `Hue Saturation`

> This adjusts the hue and saturation of the image based on the slider
> value specified.
>
> ![](ReadmeImages/media/image7.png)

*8*.  `Invert colours`

> This inverts RGB values of the pixels of the image.
>
> ![](ReadmeImages/media/image2.png)

*9*.  `Sepia`

> This adds manipulates the light to add warmth to the image.
>
> ![](ReadmeImages/media/image4.png)
>

*10*. `Sharpen`

> This sharpens the image.
>
> ![](ReadmeImages/media/image13.jpeg)
*11*. `Logging Service`

> The logging service has multiple features to see the changes made to
> an image. You can filter by feature and filter by time. The
> screenshots of their usage are attached below.
>
> Here are the Logs:
>
> ![](ReadmeImages/media/image3.png)
>
> Here are the logs in the given time stamp in the range (filter by
> time):
>
> ![](ReadmeImages/media/image9.png)
>
> Here are the logs that has the effect Gaussian blur and time stamp in
> the range(filter by effect name):
>
> ![](ReadmeImages/media/image8.png)

`Contributions`

*1*.  **Logging service and Java setup**

    -   Ishan Jha (IMT2022562)

    -   Ayush Gupta (IMT2022546)

*2*.  **C++ Files**

    -   Ayush Gupta (IMT2022546)

    -   R Harshavardhan (IMT2022515)

    -   Nathan Mathew Verghese (IMT2022022)

*3*.  **Effect Implementation**

    -   Dhruv Kothari (IMT2022114)

    -   Nathan Mathew Verghese (IMT2022022)

    -   Ishan Jha (IMT2022562)

*4*.  **Photoservice**

    -   Dhruv Kothari (IMT2022114)

    -   Ishan Jha (IMT2022562)

*5*.  **ReadMe documentation**

    -   R Harshavardhan (IMT2022515)
