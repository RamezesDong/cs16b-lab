# 提交cs61b的code



[toc]

---

直接记一下笔记吧

#### w2's Discussion

- ![image-20211024231034681](C:\Users\Ramezes Dong\AppData\Roaming\Typora\typora-user-images\image-20211024231034681.png)

  定义两个猫，赋值不同的noisy，他们改变的是Cat下的同一个noisy，也就是说noisy被后操作的所决定

- 递归和非递归的方法求整数链表的平方

  **对链表理解还不够深，这个问题很经典**

- 全局变量和 local 变量![image-20211025094345645](C:\Users\Ramezes Dong\AppData\Roaming\Typora\typora-user-images\image-20211025094345645.png)

  swaperoo(f1,f2)则f1与f2都变为f2。

  注意传递的变量是一个值还是一个地址（java没有用指针)

- ![image-20211025095842001](C:\Users\Ramezes Dong\AppData\Roaming\Typora\typora-user-images\image-20211025095842001.png)

  multiplyBy3 是去A 中各元素的值，变量名叫 x ，改变的实际上是变量 x。

#### lab2

dcatenate() and catenate() 加一句判断A是否为null ，解决 test null arguments 的问题

#### proj0

花了整整一天时间，上午在配置IntelliJ IDEA 相关的环境；下午开始写代码，测试文件一直无法单独执行，后来又查了好久。到晚上九点，终于写完代码，一运行发现行星都飞走了。**物理函数写错了**！！！忘记dx是矢量，我求了绝对值。

运行出动画，成就感满满呀！实际上这次难度并不算太大，而且老师的doc真的太详细了。感动 :joy:

![img](https://s31.aconvert.com/convert/p3r68-cdx67/k1tgi-pvjn8.gif)

