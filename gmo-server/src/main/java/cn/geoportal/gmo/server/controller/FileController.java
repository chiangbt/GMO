package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.common.RespBean;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: FileController
 * @Author: chiangbt@geoportal.cn
 * @Description: 文件上传模块
 * @Date: 2021/5/31 14:37
 */
@Api(tags = "2.文件模块")
@ApiSupport(order = 303)
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_");

    /**
     *
     * @param file
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */
    @ApiOperation(value = "文件上传", nickname = "将文件上传至服务器的静态文件夹中")
    @PostMapping("/upload")
    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    public RespBean uploadfile(@RequestPart MultipartFile file) throws IOException, FileNotFoundException {
        // 获取静态目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }
        // 创建static/uploads文件夹
        File upload = new File(path.getAbsolutePath(),"static/uploads/");
        if(!upload.exists()) {
            upload.mkdirs();
        }

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String format = sdf.format(new Date());
            String rndfile = format + defaultKaptcha.createText() + "_" + fileName;
            String filePath = upload + "/" + rndfile;

            File dest = new File(filePath);
            Files.copy(file.getInputStream(), dest.toPath());
            return RespBean.success("文件上传成功", "/uploads/" + dest.getName());
        }
        return RespBean.error("文件未设置或上传失败");
    }

    /**
     * 
     * @return
     * @throws FileNotFoundException
     */
    @ApiOperation(value = "静态目录", nickname = "获取服务器静态服务器文件夹的实际目录")
    @RequestMapping(value="/upload_path", method = RequestMethod.GET)
    @PreAuthorize(value = "hasRole('ADMIN')")
    public RespBean getStaticPath() throws FileNotFoundException {
        File path2 = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path2.exists()) {
            path2 = new File("");
        }
        File upload = new File(path2.getAbsolutePath(),"static/uploads/");
        if(!upload.exists()) {
            upload.mkdirs();
        }

        System.out.println("upload url:"+upload.getAbsolutePath());
        return RespBean.success("静态目录", upload.getAbsolutePath());
    }
}
