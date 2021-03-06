## 问题描述

实现一种狗猫队列的结构，要求如下:
- 用户可以调用add方法将cat类或dog类的实例放入队列中
- 用户可以调用 pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
- 用户可以调用 pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
- 用户可以调用 pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出;
- 用户可以调用 isEmpty方法，检查队列中是否还有dog或cat的实例
- 用户可以调用 isDogEmpty方法，检查队列中是否有dog类的实例
- 用户可以调用 isCatEmpty方法，检查队列中是否有cat类的实例

## 理解
- 可以存放cat/dog的队列，则应该以其父类为泛型建立队列
- pollAll 按push的顺序弹出pet元素（无视类型，正常弹出操作）
- pollCat/pollDag 既然存在对Cat、Dog的单独操作，采用双队列结构会降低难度（包括时间复杂度）
即推翻第一条分析。要完成第二条要求，应记录pet的存放顺序（为每一条记录保存一个索引，类似于数组下标）
在poll操作时用于比较顺序。
