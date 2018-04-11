##问题描述
使用一个（仅）栈对一个存储整型数据的栈进行排序，
使其能够自顶到底降序排列。（可以申请其他变量，但不能使用其他数据结构）

##分析
待排序栈声明为stack，辅助栈声明为help

将stack中数据弹出（声明为cur），与help的栈顶元素进行比较，
令help中数据自顶直下按升序排列。（这样带排序完成，只需要出栈操作即可）
- `help.isEmpty() || cur <= help.peek()`，cur直接压入help中
-  `cur > help.peek()`，则将help中数据逐一出栈压入stack中（同时将help的栈顶元素与cur比较），
直到遇到大于cur的位置，压入即可。