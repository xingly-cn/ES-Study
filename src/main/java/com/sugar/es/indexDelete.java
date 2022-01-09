package com.sugar.es;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class indexDelete {
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

        // 删除索引
        DeleteIndexRequest request = new DeleteIndexRequest("role2");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);

        System.out.println("删除状态：" + response.isAcknowledged() );



        client.close();

    }
}
