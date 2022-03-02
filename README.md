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
        implementation 'com.github.ITDinasour:Basic-WithViewBinding:0.1.3'
 	}
```  

ProGuard
--------
用到了反射来创建相关基类的ViewBinding，需要将编译生成的ViewBinding类移除混淆

```pro 
#viewbinding要移除混淆，否则反射时无法创建对象
-keep class  包名.databinding.* {*;}
```
