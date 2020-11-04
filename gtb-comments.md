### 完成度：
* 没有单独的 查询 groups 的 API
* 返回的数据类型都没有封装，全都是数组套数组

### 测试：
* 没有测试

### 知识点：

__Details:__
- \- URL 不符合 REST 规范
- \- 可以使用 @ResponseStatus 简化代码

### 工程实践：

__Details:__
- \- 实现全都写在了 controller 里，很不好！
- \- 使用原始 collection 来存储数据，建议抽象出来 Repository
- \- 没有提取出 Student 的概念！
- \- 没有提取出 Group 的概念！
- \- 实现过于复杂，不可读。
- \- 这里 URL 是复数更好

### 综合：


