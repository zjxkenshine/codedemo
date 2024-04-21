# 参考地址
Java的ResourceBundle的轻量级、支持UTF-8、支持printf（）的替代方案
- https://github.com/fge/msg-simple
- https://github.com/fge/msg-simple/wiki/Examples

# 简介
- 通过properties文件指定，对属性文件使用与ResourceBundle相同的约定，
- 如果您的基本资源文件名为messages.properties，那么messages_fr_FR.properties将提供法语消息

MsgTest：简单示例

# 组件
- MessageSource：消息源
- MessageSourceProvider：MessageSource提供程序
    - StaticMessageSourceProvider：静态绑定
    - LoadingMessageSourceProvider：加载绑定
- MessageBundle：消息绑定包
- MyMessageBundle：运行时加载MessageBundle