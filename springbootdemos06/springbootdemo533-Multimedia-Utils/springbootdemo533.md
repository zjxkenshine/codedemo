# 参考地址
multimedia-utils-一款java后端的图片、视频处理工具jar包
- https://gitee.com/gnliscream/multimedia-utils
- https://blog.csdn.net/m0_50684338/article/details/120894960

# 使用前提
- FFmpeg：https://ffmpeg.org/
- ImageMagick：https://imagemagick.org/
    - https://soft.3dmgame.com/down/283961.html
  
需要设置FFmpeg和ImageMagick的环境变量

# 组成方法
- 图片工具ImageMagickUtils
  - 图片裁切后修改分辨率: cropAndResize
  - 图片裁切: crop
  - 图片修改分辨率: resize
- 视频工具FFmpegUtils
  - 获取视频信息: getInfo
    - FFFormat 文件信息
    - VideoInfo 视频信息
    - AudioInfo	音频信息
  - 截取视频封面
    - createCover
  - 视频压缩
    - putCompressionTask

