package groovy

/**
 * 简易加法
 * @param a 数字a
 * @param b 数字b
 * @return 和
 */
def add(int a, int b) {
    return a + b
}

/**
 * map转化为String
 * @param paramMap 参数map
 * @return 字符串
 */
def mapToString(Map<String, String> paramMap) {
    StringBuilder stringBuilder = new StringBuilder();
    paramMap.forEach({ key, value ->
        stringBuilder.append("key:" + key + ";value:" + value)
    })
    return stringBuilder.toString()
}