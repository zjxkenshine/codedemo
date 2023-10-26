# 参考地址
gitee
- https://gitee.com/boat824109722/visual-qr-code

# 创建方法参数说明
1. content 二维码内容、网址，必需
2. bgPath 背景图片路径，必需
3. outPath 二维码输出路径，必需
4. Level 二维码容错等级，必需,可选："L"、"M"、"Q"、"H"
    - L水平 7%的字码可被修正
    - M水平 15%的字码可被修正
    - Q水平 25%的字码可被修正
    - H水平 30%的字码可被修正
5. DF 二维码颜色，必需
    - startX 二维码X轴起点，非必须，默认为图片的左上角
    - startY 二维码Y轴起点，非必须，默认为图片的左上角
    - QRCodeWidth 二维码的宽度，非必须，默认为背景图最小边
    - 二维码的起始X/Y加上QRCodeWidth<=图片的宽/高
6. isDeformation 是否把背景图变成方形，非必须，默认为false不改变图片形状
7. fillPositionDetectionShapeModel 二维码四个大码眼的形状，目前只支持方形和圆方形可选：
    - POSITION_DETECTION_SHAPE_MODEL_RECTANGLE
    - POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE
8. fillShapeModel 二维码点的形状，目前只支持方形和圆形可选：
    - FILL_SHAPE_MODEL_RECTANGLE
    - FILL_SHAPE_MODEL_CIRCLE

