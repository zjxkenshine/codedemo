package com.kenshine.filestorage.controller;

import com.kenshine.filestorage.service.FileDetailService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.file.HttpServletRequestFileWrapper;
import org.dromara.x.file.storage.core.file.MultipartFormDataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname FileController
 * @Description 文件上传操作
 * @Date 2023-12-09 11:20
 * @modified By：
 * @version: 1.0$
 */
@Slf4j
@RestController
public class FileUploadController {
    @Resource
    private FileStorageService fileStorageService;

    @Resource
    private FileDetailService fileDetailService;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public FileInfo upload(MultipartFile file) {
        FileInfo fileInfo = fileStorageService.of(file).upload();
        // 保存fileDetail
        fileDetailService.save(fileInfo);
        return fileInfo;
    }

    /**
     * 上传文件，成功返回文件 url
     */
    @PostMapping("/upload2")
    public String upload2(MultipartFile file) {
        FileInfo fileInfo = fileStorageService.of(file)
                //保存到相对路径下，为了方便管理，不需要可以不写
                //minio桶中的日期文件夹可以在这里设置
                .setPath("upload/")
                //关联对象id，为了方便管理，不需要可以不写
                .setObjectId("0")
                //关联对象类型，为了方便管理，不需要可以不写
                .setObjectType("0")
                //保存一些属性，可以在切面、保存上传记录、自定义存储平台等地方获取使用，不需要可以不写
                .putAttr("role","admin")
                .upload();  //将文件上传到对应地方
        return fileInfo == null ? "上传失败！" : fileInfo.getUrl();
    }

    /**
     * 上传图片，成功返回文件信息
     * 图片处理使用的是 https://github.com/coobird/thumbnailator
     */
    @PostMapping("/upload-image")
    public FileInfo uploadImage(MultipartFile file) {
        return fileStorageService.of(file)
                //将图片大小调整到 1000*1000
                .image(img -> img.size(1000,1000))
                //再生成一张 200*200 的缩略图
                .thumbnail(th -> th.size(200,200))
                .upload();
    }

    /**
     * 上传文件到指定存储平台，成功返回文件信息
     */
    @PostMapping("/upload-platform")
    public FileInfo uploadPlatform(MultipartFile file) {
        return fileStorageService.of(file)
                //使用指定的存储平台
                .setPlatform("aliyun-oss-1")
                .upload();
    }

    /**
     * 直接读取 HttpServletRequest 中的文件进行上传，成功返回文件信息
     * 使用这种方式有些注意事项，请查看文档 基础功能-上传 章节
     */
    @PostMapping("/upload-request")
    public FileInfo uploadPlatform(HttpServletRequest request) {
        return fileStorageService.of(request).upload();
    }


    /**
     * 这里演示了其它参数的获取方式
     */
    @PostMapping("/upload-request2")
    public FileInfo uploadRequest2(HttpServletRequest request) {
        HttpServletRequestFileWrapper wrapper = (HttpServletRequestFileWrapper) fileStorageService.wrapper(request);

        //获取指定参数，注意无法获取文件类型的参数
        String aaa = wrapper.getParameter("aaa");
        log.info("aaa：{}",aaa);

        //获取全部参数，注意无法获取文件类型的参数
        MultipartFormDataReader.MultipartFormData formData = wrapper.getMultipartFormData();
        Map<String, String[]> parameterMap = formData.getParameterMap();
        log.info("parameterMap：{}",parameterMap);

        //请求头还是通过 request 获取
        String auth = request.getHeader("Authorization");

        return fileStorageService.of(wrapper).upload();
    }

    /**
     * 注意这里是错误的用法，在方法上定义参数来接收请求中的参数，这样会导致输入流被提前读取
     */
    @PostMapping("/upload-request3")
    public FileInfo uploadRequest3(HttpServletRequest request,String aaa) {
        //包括但不限于下面这几种通过 request 获取参数的方式也是不行的，同样会导致输入流被提前读取
        String bbb = request.getParameter("bbb");
        Map<String, String[]> parameterMap = request.getParameterMap();

        //总之就是任何会导致输入流被提前读取的行为都是不可以的
        return fileStorageService.of(request).upload();
    }

    // 其他操作
    public FileInfo otherOperator(){
        //手动构造文件信息，可用于其它操作
        FileInfo fileInfo = new FileInfo()
                .setPlatform("huawei-obs-1")
                .setBasePath("test/")
                .setPath("aa/")
                .setFilename("image.png")
                .setThFilename("image.png.min.jpg");

        //文件是否存在
        boolean exists = fileStorageService.exists(fileInfo);
        //下载
        byte[] bytes = fileStorageService.download(fileInfo).bytes();
        //删除
        fileStorageService.delete(fileInfo);


        //直接从数据库中获取 FileInfo 对象，更加方便执行其它操作
        FileInfo fileInfo1 = fileStorageService.getFileInfoByUrl("https://abc.def.com/test/aa/image.png");

        //文件是否存在
        boolean exists1 = fileStorageService.exists("https://abc.def.com/test/aa/image.png");
        //下载
        byte[] bytes1 = fileStorageService.download("https://abc.def.com/test/aa/image.png").bytes();
        //删除
        fileStorageService.delete("https://abc.def.com/test/aa/image.png");
        return fileInfo;
    }

}
