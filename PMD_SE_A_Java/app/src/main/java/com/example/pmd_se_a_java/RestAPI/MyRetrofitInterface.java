package com.example.pmd_se_a_java.RestAPI;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MyRetrofitInterface {
    @GET("posts")
    Call<List<myRestAPIModel>> getList();

    @GET("comments?postId=1")
    Call<List<MyCommentsModel>> getCommentList();

    @GET("posts{id}/comments")
    Call<List<MyCommentsModel>> getCommentList(@Path("id") int id);

    @GET("comments")
    Call<List<MyCommentsModel>>  getMyCommentsQuery(@Query("postId") int id,
                                                    @Query("_sort") String sort,
                                                    @Query("_order") String order);

    @GET("comments")
    Call<List<MyCommentsModel>> getMyCommentsByArgument(@QueryMap Map<String, String> Argument);

    @POST("posts")
    Call<myRestAPIModel> createPost(@Body myRestAPIModel post);
}
