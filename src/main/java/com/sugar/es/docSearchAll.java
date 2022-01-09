package com.sugar.es;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class docSearchAll {
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

//        // 文档全量查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//
//        System.out.println("查询到：" + hits.getTotalHits());
//        System.out.println("耗时：" + response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit);
//        }

        // 文档条件查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",30)));
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//
//        System.out.println("查询到：" + hits.getTotalHits());
//        System.out.println("耗时：" + response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit);
//        }

        // 分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        // (页码-1) * size
//        builder.from(4);
//        builder.size(2);
//        request.source(builder);
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//
//        System.out.println("查询到：" + hits.getTotalHits());
//        System.out.println("耗时：" + response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.sort("age", SortOrder.DESC);
//        request.source(builder);
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//
//        System.out.println("查询到：" + hits.getTotalHits());
//        System.out.println("耗时：" + response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 字段查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        String[] excludes = {"age"};
//        String[] includes = {};
//        builder.fetchSource(includes,excludes);
//        request.source(builder);
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//
//        System.out.println("查询到：" + hits.getTotalHits());
//        System.out.println("耗时：" + response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.matchQuery("age",30));
//        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",40));
//
//        builder.query(boolQueryBuilder);
//        request.source(builder);
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//
//        System.out.println("查询到：" + hits.getTotalHits());
//        System.out.println("耗时：" + response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//        rangeQuery.gte(30);
//        rangeQuery.lte(40);
//
//        builder.query(rangeQuery);
//        request.source(builder);
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//
//        System.out.println("查询到：" + hits.getTotalHits());
//        System.out.println("耗时：" + response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


        // 模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        builder.query(QueryBuilders.fuzzyQuery("name", "肖").fuzziness(Fuzziness.ONE));
//        request.source(builder);
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//
//        System.out.println("查询到：" + hits.getTotalHits());
//        System.out.println("耗时：" + response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


        // 高亮查询
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("age", 30);

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name");

        builder.highlighter(highlightBuilder);

        builder.query(termQueryBuilder);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();

        System.out.println("查询到：" + hits.getTotalHits());
        System.out.println("耗时：" + response.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }


        client.close();

    }
}
