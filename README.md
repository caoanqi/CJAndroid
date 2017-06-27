# CJAndroid
 

一个 快速开发android应用的框架。

##简介

本框架采用了rxjava+retrofit+mvvm的这样一个开发模式，中间还采用了lambda表达式，android的一些新组件和技术的使用。
计划添加一些常用的第三方库。项目里会集成一些常用的工具类和自定义view控件。不会有太多高深的东西在里面添加，只使用一些常用的技术知识点填充进来，尽量保证项目和代码的简洁，这样也方便关注的朋友可以很快的了解框架和使用。

##项目目录结构

app：主要  是应用ui层 （activity，adapters，widget，fragment，common，viewmodel）

dlLibrary：数据应用层（services，impl，model）

myLibrary：自己的项目库（常用的项目工具类和自定义view方便拓展）

thirdLibrary：第三方的类库（引用的第三方库）

具体的项目目录可以看项目，自己可以根据自己的一个情况进行整合。这只是本人根据自身情况设想的一个项目结构模式
这样的一个分层设计，主要是借鉴网站和后台上开发的一个模式。方便复用和拓展，也方便修改逻辑上也看着更清晰。

