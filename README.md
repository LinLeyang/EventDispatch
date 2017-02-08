# EventDispatch
事件分发机制OnTouch,OnTouchEvent,OnClick调用关系处理。

该工程使用了butterknife控件进行View绑定

工程目的是为了方便理解 OnTouch OnTouchEvent OnClick的调用关系

OnTouch 》 OnTouchEvent 》OnClick

拦截的标识就是返回值是否为true（true表示拦截）

前者拦截 后者就不会调用

Tips：OnTouchEvent必须要调用super方法才能调用到OnClick
