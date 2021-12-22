package com.example.dzrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailedActivity extends AppCompatActivity {

    public int lang_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        lang_id = Integer.parseInt((String)getIntent().getExtras().get("lang_id"));

        //Инициализация компонентов активити
        TextView title=findViewById(R.id.title2);
        TextView descript=findViewById(R.id.descr);
        TextView year=findViewById(R.id.year);

        //Получение объекта Bundle и проверка получения.
        Bundle bundle =getIntent().getExtras();
        if (bundle!=null)
        {
            //Заполнение компонентов активити из Bundle.
            title.setText(bundle.getString("language_name"));
            descript.setText(bundle.getString("descript"));
            year.setText(bundle.getString("creation_year"));
        }
    }

    public void onDeleteButtonClick(View view)
    {
        NetworkService.getInstance()
                .getJSONApi()
                .deletePost(lang_id)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Intent intent = new Intent(DetailedActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace(); //Что-то пошло не так…
                    }
                });
    }

    public void onSaveButtonClick(View view)
    {
        TextView name_text = findViewById(R.id.title2);
        String name = name_text.getText().toString();

        TextView descript_text = findViewById(R.id.descr);
        String descript = descript_text.getText().toString();

        TextView year_text = findViewById(R.id.year);
        int year = Integer.parseInt(year_text.getText().toString());

        Post editedPost = new Post(name, descript, year);
        NetworkService.getInstance()
                .getJSONApi()
                .updatePost(lang_id, editedPost)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Intent intent = new Intent(DetailedActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        t.printStackTrace(); //Что-то пошло не так…
                    }
                });
    }
}