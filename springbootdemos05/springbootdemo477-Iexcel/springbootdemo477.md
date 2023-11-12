# 参考地址
iexcel
- https://github.com/houbb/iexcel

# 简介
- ExcelUtil：工具类
- IExcelWriter：写入接口，可指定是否包含表头
    - HSSFExcelWriter：`ExcelUtil.get03ExcelWriter()`，2003 版本的 excel
    - XSSFExcelWriter：`ExcelUtil.get07ExcelWriter()`，2007 版本的 excel
    - SXSSFExcelWriter：`ExcelUtil.getBigExcelWriter()`
- IExcelReader：读取接口，可指定是否读取表头
    - ExcelReader：	`ExcelUtil.getExcelReader()`
    - Sax03ExcelReader：大文件的 2003 excel 读取实现
    - Sax07ExcelReader：大文件的 2007 excel 读取实现
- `@ExcelField`：
    - mapKey：仅用于生成的入参为 map 时,会将 map.key 对应的值映射到 bean 上
    - headName：excel 表头字段名称
    - writeRequire：是否写入
    - readRequire：是否读取
- ExcelBs：引导类