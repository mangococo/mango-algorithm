## 题目描述

> 实现一个特殊的栈（除了栈的基本操作外，还可返回栈最小值。可使用现有的栈结构）


## 要求
> - pop、push、getMin 操作的时间复杂度都为O(1) 

最初设想是设定一个最小值的指针，每次 push 时更新其指向（或不更新），getMin 即可做到时间复杂度为O(1)。但后来想明白了，这样的设计，
是无法保留记录的（就是说，当栈中最小值已被弹出，又无新的元素入栈时，此时的最小值元素指针已经无效（野指针））。

使用双堆栈可以很好的实现题目要求。