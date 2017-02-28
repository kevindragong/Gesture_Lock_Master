 
 
这几个月都是在做招财进宝项目，招财进宝是盛大网络旗下，盛付通支付服务有限公司最新推出的，一款高收益低风险的理财APP，有兴趣的可以下载玩玩，收益不错哦！！！

招财进宝下载地址：http://8.shengpay.com/ 

前段时间因产品需求，做了一个手势密码，跟支付宝的手势密码类似，这里跟大家分享交流一下我实现的方式吧。

特此写了这个demo来分享一下绘制手势密码的实现（主要是设置手势密码、校验手势密码），大致效果图如下：

![mahua](http://img.blog.csdn.net/20141103170646291?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd3VsaWFuZ2h1YW4=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

![mahua](http://img.blog.csdn.net/20141103170742077?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd3VsaWFuZ2h1YW4=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

![mahua](http://img.blog.csdn.net/20141103170914881?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd3VsaWFuZ2h1YW4=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

![mahua](http://img.blog.csdn.net/20141103172534078?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd3VsaWFuZ2h1YW4=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

##基本结构

UI：LockIndicator和GestureContentView，
    这两个自定义View负责了手势的呈现和绘制，都是继承自ViewGroup，添加9个ImageView来表示图标, 在onLayout（）方法中设置它们的位置；

    GestureDrawline，负责手势滑动的路径绘制，点与点，以及中间经过点的画线逻辑，都是在这里面搞定。

数据：GesturePoint定义九个点的位置和对应编码，手势路径保存的序列，就是这9个点的排列组合。

手势校验：存储用户设置的手势密码，对应的数字序列，用户解锁页面的绘制数字序列比对。



##实现思路

1. 正上方的提示区域，用一个类(LockIndicator.Java)来实现，自定义view来绘制9个提示图标；
2. 手势密码绘制区域，用一个类(GestureContentView.java)来实现，它继承自ViewGroup里面, 添加9个ImageView来表示图标, 在onLayout（）方法中设置它们的位置；
3. 手势路径绘制， 用一个类(GestureDrawline.java)来实现，复写onTouchEvent()方法，在这个方法里面监听TouchEvent事件: ACTION_DOWN、ACTION_MOVE、ACTION_UP事件，来绘制手势连接不同点之间的路径；
4. 9个点的对象，用一个类(GesturePoint.java)来实现，保存它的位置、状态、背景图片等相关信息；
5. 手势密码的获取，判断手指当前的位置，根据滑动路径经过的点，按顺序保存绘制的点的顺序(这里的点顺序从上到下分别是：1,2,3,4,5,6,7,8,9)，不能有重复的点。



##代码实现步骤：
1.要用一个类来表示这9个点中的第一个点。里面保留有当前点的上下左右的各个位置等属性
2.自定义GroupView，用来装9个点，9个点的显示是通过ImageView。复写onLayout这个方法，让点按需求排列
3.定义一个可以画线的View，复写onTouchEvent方法，在这个方法里面进行画直线的操作
4.判断用户手指当前的位置，取出当前的位置去与那9个点中的每个点的位置进行比较，如果用户点的位置在某一个点之内，那么当那个点置换背景图片。



##有问题反馈
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件(mrwujay@163.com)
* blog: http://blog.csdn.net/wulianghuan

