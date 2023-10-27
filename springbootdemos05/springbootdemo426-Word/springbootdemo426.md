# 参考地址
https://github.com/ysc/word

# 自定义词库方式
- 指定方式一，编程指定（高优先级）：
	`WordConfTools.set("dic.path", "classpath:dic.txt，d:/custom_dic");`
	`DictionaryFactory.reload();//更改词典路径之后，重新加载词典`
- 指定方式二，Java虚拟机启动参数（中优先级）：
	`java -Ddic.path=classpath:dic.txt，d:/custom_dic`
- 指定方式三，配置文件指定（低优先级）：使用类路径下的文件word.local.conf来指定配置信息
	`dic.path=classpath:dic.txt，d:/custom_dic`
	
# 目录
- test01：基本使用
- test02：文件
- test03：自定义操作
- test04：指定算法
- test05：词性标注
- test06：再切分
- test07：同义标注
- test08：反义标注
- test09：拼音标注


