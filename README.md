# Basic-WithoutBind
 通过ViewBinding进行视图绑定的基础服务构建
 
 
 Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:
```kotlin 
 	allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
``` 
 Step 2. Add the dependency
 ```kotlin 
    android{
        buildFeatures {
            viewBinding = true
        }
    }
 	dependencies { 
        目前还没有发布
 	}
```  
