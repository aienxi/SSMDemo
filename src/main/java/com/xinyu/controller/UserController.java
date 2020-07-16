package com.xinyu.controller;

import com.alibaba.fastjson.JSON;
import com.xinyu.common.ResponseInfo;
import com.xinyu.model.UserInfo;
import com.xinyu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;


@Controller
@RequestMapping(value = "/user",produces = "application/json;charset=utf-8")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/select")
    @ResponseBody
    public String selectUser(@RequestParam(defaultValue = "0")int userId) throws Exception {

        System.out.println("userId = " + userId);

        UserInfo userInfo = userInfoService.selectUserInfoByUserID(userId);

        ResponseInfo responseInfo = new ResponseInfo();

        if (userInfo != null){
            responseInfo.setCode(1);
            responseInfo.setData(userInfo);
        }else {
            responseInfo.setCode(2);
            responseInfo.setMsg("未获取到用户信息");

        }

        return JSON.toJSONString(responseInfo);
    }
    @RequestMapping("updateImagByBase64")
    @ResponseBody
    public String updateImagByBase64(@RequestParam(defaultValue = "0") int userId ,String base64Img){

        base64Img = base64Img.replace("data:image/jpeg;base64,","");

        System.out.println(base64Img);

        boolean bres = base64ChangeImage(base64Img,"/Users/wenqiang/img/imtemImg"+System.currentTimeMillis()+".png");
        int code = 0;
        if (bres){
            code = 1;
        }
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(code);
        responseInfo.setMsg("");
        return JSON.toJSONString(responseInfo);
    }
    /**
     * BASE转图片
     * @param baseStr  base64字符串
     * @param imagePath 生成的图片
     * @return
     */
    public boolean base64ChangeImage(String baseStr,String imagePath){
        if (baseStr == null){
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(baseStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imagePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            System.out.println("base64ChangeImage:" + e);
            return false;
        }
    }
}
