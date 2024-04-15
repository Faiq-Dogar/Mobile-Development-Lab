package com.example.pmd_se_a_java.RestAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pmd_se_a_java.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kotlin.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAPIMainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyRetrofitInterface myRetrofitInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_apimain);
        recyclerView = findViewById(R.id.myretrofitrecyclerview);

        myRetrofitInterface = MyRetrofit.getRetrofit().create(MyRetrofitInterface.class);
        /*GetMyRetrofit();*/
        /*GetMyComments();*/
        /*GetMyCommentBy()*/
        CreatePost();
    }
    private void CreatePost(){
        myRestAPIModel model = new myRestAPIModel(10, 2, "Title", "Body");
        myRetrofitInterface.createPost(model);
        Call<myRestAPIModel> myPost = myRetrofitInterface.createPost(model);
        myPost.enqueue(new Callback<myRestAPIModel>() {
            @Override
            public void onResponse(Call<myRestAPIModel> call, Response<myRestAPIModel> response) {
                if(response.isSuccessful())
                {
                    Log.d("TAG", " " + response.body().getUserId() + " /n " + response.body().getTitle()+ " /n " + response.body().getBody());
                }
            }

            @Override
            public void onFailure(Call<myRestAPIModel> call, Throwable t) {

            }
        });
    }

        /*private void GetMyComments()
        {
            Call<List<MyCommentsModel>> list  =myRetrofitInterface.getCommentList();
            Call<List<MyCommentsModel>> list  =myRetrofitInterface.getMyCommentsQuery(4);
            list.enqueue(new Callback<List<MyCommentsModel>>() {


                @Override
                public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                    if(response.isSuccessful()){
                        for(MyCommentsModel comments: response.body()){
                            Log.d("TAG","ID"+comments.getId()
                                    +"PostID "+ comments.getPostId()
                                    +"User " + comments.getName()
                                    +"Email "+comments.getEmail());
                        }

                        Toast.makeText(RestAPIMainActivity.this, "Data Retrieved", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(RestAPIMainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

                }




            });
        }*/
    /*private void GetMyCommentBy(){
        Map<String, String> Arguments =  new HashMap<>();
        Arguments.put("postId", "3");
        Arguments.put("_sort", "id");
        Arguments.put("_order", "desc");
        Call<List<MyCommentsModel>> list  =myRetrofitInterface.getMyCommentsQuery(5, "id", "desc");
        list.enqueue(new Callback<List<MyCommentsModel>>() {


            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.isSuccessful()){
                    for(MyCommentsModel comments: response.body()){
                        Log.d("TAG","ID"+comments.getId()
                                +"PostID "+ comments.getPostId()
                                +"User " + comments.getName()
                                +"Email "+comments.getEmail());
                    }

                    Toast.makeText(RestAPIMainActivity.this, "Data Retrieved", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RestAPIMainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }

    });}*/

       /* private void GetMyRetrofit(){
            Call<List<myRestAPIModel>> list  =myRetrofitInterface.getList();
            list.enqueue(new Callback<List<myRestAPIModel>>() {
            @Override
            public void onResponse(Call<List<myRestAPIModel>> call, Response<List<myRestAPIModel>> response) {
                if(response.body().size() > 0){
                    List<myRestAPIModel> list = response.body();
                    MyRestAdapter adapter = new MyRestAdapter(list, RestAPIMainActivity.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RestAPIMainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);


                    Toast.makeText(RestAPIMainActivity.this, "Data Retrieved", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RestAPIMainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<myRestAPIModel>> call, Throwable t) {
                Toast.makeText(RestAPIMainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}