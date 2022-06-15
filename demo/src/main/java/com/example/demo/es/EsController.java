package com.example.demo.es;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.CarRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-05-27 17:17
 **/
@Api(tags = "ES服务")
@RestController
@RequestMapping("/es")
@Slf4j
public class EsController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    @ApiOperation(value = "创建索引")
    @GetMapping(value = "/createindex")
    public void createindex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("liuyou_index");
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());// 查看是否创建成功
        System.out.println(response);// 查看返回对象
        restHighLevelClient.close();
    }

    @ApiOperation(value = "索引是否存在")
    @GetMapping(value = "/checkindex")
    public void checkIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("liuyou_index");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);// 索引是否存在
        restHighLevelClient.close();
    }

    @ApiOperation(value = "添加数据")
    @GetMapping(value = "/addate")
    public void addDate() throws IOException {
        CarRecord carRecord1 = new CarRecord("京A00001", "1", "2", new Date());
        CarRecord carRecord2 = new CarRecord("京A00002", "1", "2", new Date());
        CarRecord carRecord3 = new CarRecord("京A00003", "1", "2", new Date());
        CarRecord carRecord4 = new CarRecord("京A00004", "1", "2", new Date());
        CarRecord carRecord5 = new CarRecord("京A00005", "1", "2", new Date());
        ArrayList<CarRecord> carList = new ArrayList<>();

        carList.add(carRecord1);
        carList.add(carRecord2);
        carList.add(carRecord3);
        carList.add(carRecord4);
        carList.add(carRecord5);

        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        // 批量请求处理
        for (int i = 0; i < carList.size(); i++) {
            String s = JSON.toJSONString(carList.get(i));
            bulkRequest.add(
                    // 这里是数据信息
                    new IndexRequest("bulk")
                            .id("" + (i + 10)) // 没有设置id 会自定生成一个随机id
                            .source(JSON.toJSONString(carList.get(i)), XContentType.JSON)
            );
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.status());// ok
    }


    @ApiOperation(value = "分页查询ES数据")
    @GetMapping(value = "/queryEsPage")
    public List<CarRecord> queryEsPage() throws Exception {


        SearchRequest jd_goods = new SearchRequest("bulk");
        // 创建搜索源建造者对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 条件采用：精确查询 通过keyword查字段name
        //TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("carType", "2");
        //matchPhraseQuery 支持中文查询
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("carNo", "京A00001");
        searchSourceBuilder.query(matchPhraseQueryBuilder);
        //searchSourceBuilder.timeout(new org.elasticsearch.common.unit.TimeValue(60,TimeUnit.SECONDS));
        // 分页
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);
        // 高亮
        // ....
        // 搜索源放入搜索请求中
        jd_goods.source(searchSourceBuilder);
        // 执行查询，返回结果
        SearchResponse searchResponse = restHighLevelClient.search(jd_goods, RequestOptions.DEFAULT);

        // 解析结果
        SearchHits hits = searchResponse.getHits();
        List<CarRecord> results = new ArrayList<>();
        for (SearchHit documentFields : hits.getHits()) {
            String sourceAsString = documentFields.getSourceAsString();
            CarRecord carRecord = JSON.parseObject(sourceAsString, CarRecord.class);

            results.add(carRecord);
        }
        restHighLevelClient.close();
        // 返回查询的结果
        return results;
    }

    @ApiOperation(value = "测试查询数据")
    @GetMapping(value = "/testDate")
    public void testAddDocument() throws IOException {
        // 创建一个User对象
        CarRecord carRecord1 = new CarRecord("京A88888", "1", "2", new Date());
        // 创建请求
        IndexRequest request = new IndexRequest("bulk");
        // 制定规则 PUT /liuyou_index/_doc/1
        request.id("1000");// 设置文档ID
        request.timeout(TimeValue.timeValueMillis(1000));// request.timeout("1s")
        // 将我们的数据放入请求中
        request.source(JSON.toJSONString(carRecord1), XContentType.JSON);
        // 客户端发送请求，获取响应的结果
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.status());// 获取建立索引的状态信息 CREATED
        System.out.println(response);// 查看返回内容
    }

    @ApiOperation(value = "获取一条数据")
    @GetMapping(value = "/testOne")
    public void testOne() throws IOException {
        GetRequest request = new GetRequest("bulk", "1");
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());// 打印文档内容
        System.out.println(request);// 返回的全部内容和命令是一样的
        restHighLevelClient.close();
    }

    @ApiOperation(value = "获取111")
    @GetMapping(value = "/test111")
    public void test111() throws IOException {
        SearchRequest searchRequest = new SearchRequest("bulk");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("carType", "2"));
        //分页公式：(currentPageNo - 1) * pageSize
        int from = (1 - 1) * 5;
        sourceBuilder.from(from);
        sourceBuilder.size(5);
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        System.out.println("MMMMMMM:" + hits);
    }









    /*public static void main(String[] args) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("http://49.232.201.135",9200,"http")
                )
        );
        System.out.println(client);
    }*/
}
