package com.zhm.file.Controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpHandler;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 * @author lzmtx
 * @date 2019/4/20 - 17:36
 */
@Controller
public class FileUploadController {
    /**
     * 执行文件上传
     */
    @RequestMapping("/fileUpload")
    public String handleFormUpload(@RequestParam("name") String name, @RequestParam("uploadfile")List<MultipartFile> uploadfile, HttpServletRequest request) {
        //判断所上传文件是否存在
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            System.out.println("接收文件列表：" + uploadfile);
            //循环输出上传的文件
            for (MultipartFile file : uploadfile) {
                //获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                //设置上传文件的保存地址目录
                String dirPath = request.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                //如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                //使用UUID重新命名上传的文件名称（上传人_uuid_原始文件名称）
                String newFilename = name + "-" + UUID.randomUUID() + "_" + originalFilename;
                try {
                    //使用MultipartFile接口的方法完成文件上传到指定的位置
                    file.transferTo(new File(dirPath + newFilename));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //跳转到成功页面
                return "uploadfileSuccess";
            }
        } else {
            return "error";
        }
        return "";
    }

    /**
     * 执行文件下载
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,String filename) throws Exception {
        //指定要下载的文件所在路径
        String path = request.getServletContext().getRealPath("/upload/");
        //创建该文件对象
        File file = new File(path + File.separator + filename);
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        //通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", filename);
        //定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        System.out.println("文件下载，传输成功");
        //使用string mvc框架的responseEntity对象封装返回下载的数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
}
