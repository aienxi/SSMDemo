package com.xinyu.controller;

import com.xinyu.model.UserInfo;
import org.springframework.web.client.RestTemplate;

public class BaseLearn {

        public static void main(String[] args){
                RestTemplate restTemplate = new RestTemplate();
                UserInfo userInfo = restTemplate.getForObject("http://localhost:8082/user/select?userId=1", UserInfo.class);

                System.out.println(userInfo);

        }

}
