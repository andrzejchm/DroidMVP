# DroidMVP
[![Release](https://jitpack.io/v/andrzejchm/DroidMVP.svg)](https://jitpack.io/#andrzejchm/DroidMVP)[![CircleCI](https://circleci.com/gh/andrzejchm/DroidMVP/tree/develop.svg?style=svg)](https://circleci.com/gh/andrzejchm/DroidMVP/tree/develop)

##About
DroidMVP is a small Android library to help you incorporate the [**MVP pattern**](http://antonioleiva.com/mvp-android/) along with [**Passive View**](http://martinfowler.com/eaaDev/PassiveScreen.html) and [**Presentation Model**](http://martinfowler.com/eaaDev/PresentationModel.html) (yes, those can be combined together :) ) within your Android project.

##Explanation 

**Pasive View**

> A screen and components with all application specific behavior extracted into a controller so that the widgets have their state controlled entirely by controller. - **Martin Fowler** 

--
**Presentation Model**

> Represent the state and behavior of the presentation independently of the GUI controls used in the interface - **Martin Fowler**

--

#####Model and Presenter
In our case a controller will be our presenter, which stores the view state within the Presentation Model. All the state manipulation happens within the Model class itself, but it is the Presenter who initiates those modifications.

#####View
Our passive view is the activity or fragment, which will be treated as a widgets' (like TextView, ImageView etc.) container with the ability to present different states driven by the presenter. All user interaction should be routed to the presenter.

##Setup

Add it in your root `build.gradle` at the end of repositories:
  ```groovy  
  allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
  }
  ```
  

Add the dependency to your app's `build.gradle`
```groovy  
  dependencies {
    compile 'com.github.andrzejchm:droidMVP:0.1.0'
  }
```

##Composition over inheritance
If by any chance you cannot extend from `DroidMVPActivity` or `DroidMVPFragment` you can always use the `DroidMVPViewDelegate`. Just make sure to bind it with your activity's or fragment's lifecycle the same way the `DroidMVPFragment` or `DroidMVPActivity` does it.

##Dependency Injection
This library makes it easy to use it with dependency injection frameworks like [Dagger](http://google.github.io/dagger/). To see how it could be done, check out the [**Sample project**](/sample), specifically the `BaseFragment` or `BaseActivity`

##Sample Project
A small android app which uses Dependency Injection along with **DroidMVP** can be found 
[**here**](/sample)

