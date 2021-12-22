package com.example.dzrip;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating);
    }

    public void onCreateButtonClick(View view) {
        TextView name_text = findViewById(R.id.name_text);
        String name = name_text.getText().toString();

        TextView descript_text = findViewById(R.id.descript_text);
        String descript = descript_text.getText().toString();

        TextView year_text = findViewById(R.id.year_text);
        String year_str = year_text.getText().toString();
        int year = 0;
        if (!year_str.equals(""))
            year = Integer.parseInt(year_str);

        Post newPost = new Post(name, descript, year);
        NetworkService.getInstance()
                .getJSONApi()
                .createPost(newPost)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Intent intent = new Intent(CreatingActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        t.printStackTrace(); //Что-то пошло не так…
                    }
                });
    }
}
