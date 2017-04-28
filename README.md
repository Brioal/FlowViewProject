
### 效果演示:
![](https://github.com/Brioal/FlowViewProject/blob/master/art/device-2017-04-28-133151.png)
## 使用方法
### 1.在项目的build.gradle文件做如下修改
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### 2.在app的build.gradle内作如下修改
```
dependencies {
      ...
	    compile 'com.github.Brioal:FlowViewProject:1.0'
      ...
}
```
## 提供的自定义方法
方法名 | 作用 | xml属性
---- | ---- | -----
`setColorCircle(int colorCircle)` | 设置圆心的颜色 | `colorCircle`
`setColorDone(int colorDone)` | 设置已完成的颜色 |`colorDone`
`setColorUnReach(int colorUnReach)` | 设置未完成的颜色 | `colorUnDo`
`setFlowCount(int flowCount)` | 设置流程总数 | `allIndexCount`
`setCurrentFlow(int currentFlow)` | 设置当前的流程 | `currentIndex`

## 使用方法示例
### xml布局
### 注:此组件必须设置确定的高度
```
<com.brioal.flowview.FlowView
        android:id="@+id/main_flowView"
        android:layout_width="match_parent"
        android:layout_height="30dp"
        app:currentIndex="3"
        app:allIndexCount="5"
        />
```

## 完毕
