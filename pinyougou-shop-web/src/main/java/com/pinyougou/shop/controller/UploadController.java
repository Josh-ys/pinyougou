package com.pinyougou.shop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pinyougou.utils.FastDFSClient;

import entity.Result;

/**
 * 文件上传
 * 
 * @author Reasonless
 *
 */
@RestController
public class UploadController {

	@Value("${FILE_SERVER_URL}")
	private String FILE_SERVER_URL;

	@RequestMapping("/upload")
	public Result upload(MultipartFile file) {
		if (file == null || file.isEmpty()) {
			return new Result(false, "请选择上传文件！！");
		}
		// 获取上传文件扩展名
		String filename = file.getOriginalFilename();
		String extName = filename.substring(filename.lastIndexOf(".") + 1);
		try {
			// 创建一个 FastDFS 的客户端
			FastDFSClient client = new FastDFSClient("classpath:config/fdfs_client.conf");
			// 执行上传处理
			String uploadFile = client.uploadFile(file.getBytes(), extName);
			// 拼接返回的 url 和 ip 地址，拼装成完整的 url
			String path = FILE_SERVER_URL + uploadFile;
			return new Result(true, path);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "上传文件失败");
		}
	}
}
