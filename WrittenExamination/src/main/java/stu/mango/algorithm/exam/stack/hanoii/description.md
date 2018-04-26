##描述
汉诺塔(限制：在经典汉诺塔的基础上，不能从最左侧直接移动到最右侧，也不能只从最右侧移动到最左侧)


### 递归解决方案
移动流程可分为两大类：

- 左/右 <--> 中
- 左 <--> 右

1. 若仅剩下最上层（仅余一个）需要移动，如下考虑：<br/>
左/右 <--> 中: from -> mid<br>
左 <--> 右: from -> mid; mid -> to
2. 若还剩下N层需要移动，分情况如下：<br>
左/右 <--> 中：<br>
&emsp;&emsp;from(N-1) -> other; from(N) -> to; other(N-1) -> to<br>
左 <--> 右:<br>
&emsp;&emsp;from(N-1) -> to; from(N) -> mid; to(N-1) -> from; mid(N) -> to; from(N-1) -> to<br>