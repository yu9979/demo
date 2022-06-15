package com.example.demo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-05-27 17:26
 **/
@Configuration
public class ElasticSearchConfig {
    // 注册 rest高级客户端
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("49.232.201.135", 9200, "http")
                )
        );
        return client;
    }
}
