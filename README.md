# Animated Background Library for Jetpack Compose

## Overview

Welcome to the **Animated Background Library for Jetpack Compose**! This open-source library is designed to help Android developers seamlessly integrate beautiful and dynamic background animations into their applications.

With Jetpack Compose gaining popularity for modern UI development, this library aims to provide an efficient and customizable solution for animated backgrounds without compromising performance. Whether you want to add subtle motion effects, gradient shifts, or interactive particle animations, this library makes it simple and easy to use.

## Features

- **Easy integration with Jetpack Compose.**
- **A variety of built-in animations.**
- **High-performance rendering optimized for Android devices.**
- **Customizable animation speed, colors, and patterns.**
- **Open-source and community-driven development.**

## Installation

### Step 1: Configure `settings.gradle.kts`

Add the following configuration in your `settings.gradle.kts` file:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

### Step 2: Add Dependency in `build.gradle.kts` (Module: app)

Include the following dependency in your `build.gradle.kts` file:

```kotlin
implementation("com.github.m-vishal-10:BackgroundLibrary:b1a0a00700")
```

Additionally, ensure the following configurations inside the `android { ... }` block for proper compatibility:

```kotlin
android {
    ...
    compileSdk = 35
    defaultConfig {
        ...
        minSdk = 29
        targetSdk = 35
        ...
    }
    ...
}
```

## Usage

Basic usage of gradient backgrouund :

```kotlin
Box(modifier = Modifier
    .background(BackgroundGradients.Fire)
    .fillMaxSize()){
    ...
    }
```
**BackgroundGradients** can be used as an object to call different predefined gradient themes such as **Fire**, **Forest**, **Ocean**, etc.



![image](https://github.com/user-attachments/assets/8dc5059c-545e-46c6-a8ba-23c322aba389)

Basic usage of other backgrouund :

```kotlin
Box(modifier = Modifier
    .fillMaxSize()) {
            WavyBackground()   // you can access different backgrounds by calling composables here
}
```
![Wa](https://github.com/user-attachments/assets/fcbe3fe0-f9f5-468b-a84f-aa3974dc417e)
![Wa (1)](https://github.com/user-attachments/assets/55074ac3-27e7-4cca-9b29-770d7d5b9d84)
![Wa (2)](https://github.com/user-attachments/assets/814d38c7-4b06-4e81-99d5-ca31cc7fe677)




**Animated Background**
This snippet showcases animated and interactive text elements using GradientText, PopOnHoverText, and AnimatedText within a Column() layout for dynamic UI effects.

``` kotlin
Column(){
            GradientText("BottomBar() ", GradientPreset.DeepSea, animationSpeed = 1)
            PopOnHoverText("PopOnHoverText() ")
            AnimatedText("AnimatedText() ")
}
```

![giphy](https://github.com/user-attachments/assets/cd4a9c00-416f-4585-a7ff-10018b2172c8)

**Bottom Bar**
The BottomBar() composable provides a simple, reusable bottom navigation bar for Jetpack Compose apps.
```kotlin
Scaffold(
    bottomBar = { BottomBar() }
  ){ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            //your content here
        }
  }
```

<p >
  <img src="https://github.com/user-attachments/assets/1b54107e-8325-4d12-8fe6-f767a73546e4" alt="Model1" width="200" style="margin-right: 20px;"/>
  <img src="https://github.com/user-attachments/assets/d3404fdf-a42d-475e-bd07-e8cb45287680" alt="Model2" width="200" style="margin-right: 20px;"/>
 
</p>



```kotlin
AnimatedBackground(
    modifier = Modifier.fillMaxSize(),
    animationType = AnimationType.GRADIENT,
    colors = listOf(Color.Blue, Color.Cyan),
    speed = 1.5f
)
```
**Loading Screen**

![giphy (1)](https://github.com/user-attachments/assets/3b9fd721-02ec-46c8-bdbb-dbdb181e65e5)

## 
# Contributing to Background Library  

We welcome contributions to improve this library! Follow these steps to contribute:  

## 1. Fork the Repository  
Click the **Fork** button at the top-right corner of this repository to create your own copy.  

## 2. Clone Your Fork  
Clone your forked repository to your local machine using:  
```sh
git clone https://github.com/your-username/BackgroundLibrary.git
```
## 3. Create a New Branch
Switch to a new branch for your feature or fix:
```sh
git checkout -b feature-name

```
## 4. Make Your Changes
Modify the code and test your changes before committing.

## 5. Commit and Push
Stage and commit your changes:
```sh
git add .
git commit -m "Add feature: brief description"
git push origin feature-name
```
## 6. Open a Pull Request
-Go to the Pull Requests section of this repository.

-Click New Pull Request and select your branch.

-Provide a clear description of the changes and submit the request.

## 7. Review and Merge
Your contribution will be reviewed, and once approved, it will be merged into the main branch!

Thank you for contributing! 

## License  

This project is licensed under the **Apache License 2.0**.  
You are free to use, modify, and distribute this library under the terms of the license.  

For more details, see the full [Apache License 2.0](LICENSE) or visit:  
[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)  
