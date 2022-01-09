package com.sugar.es;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.Index;

public class docInsertBatch {
    private final static String host = "es-1eq9og57.public.tencentelasticsearch.com";
    private final static int port = 9200;
    private final static String scheme  = "https";

    private final static String UserName = "elastic";
    private final static String PassWord = "XNXxnx520@";

    public static void main(String[] args) throws Exception{
        // 认证
        BasicCredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(UserName,PassWord));

        // 创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(host,port,scheme)
                ).setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                    @Override
                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
                        httpAsyncClientBuilder.disableAuthCaching();
                        return httpAsyncClientBuilder.setDefaultCredentialsProvider(provider);
                    }
                })
        );

        // 文档批量插入
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","李四","age",30,"sex","男"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","王五","age",30,"sex","女"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","大飞","age",40,"sex","男"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON,"name","爽儿","age",40,"sex","女"));
        request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON,"name","念哥","age",50,"sex","男"));
        request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON,"name","肖哥","age",50,"sex","男"));



        BulkResponse response = client.bulk(request,RequestOptions.DEFAULT);
        System.out.println("插入时间：" + response.getTook());
        System.out.println("插入结果：" + response.getItems());

        client.close();

    }
}
