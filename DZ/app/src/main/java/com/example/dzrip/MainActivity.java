package com.example.dzrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    LinearLayout linMain;
    ArrayList<Bundle> bundles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundles = new ArrayList<>();
        linMain = findViewById(R.id.linear_main);

        NetworkService.getInstance()
            .getJSONApi()
            .getAllPosts()
            .enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                    List<Post> postList = response.body();
                    for (int i = 0; i < postList.size(); i++) {
                        addCardView(postList.get(i), i);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                    t.printStackTrace(); //Что-то пошло не так…
                }
            });
    }

    public void addCardView(Post post, int i) {

    //Преобразование лаяута шаблона в элемент типа View
        final View view = getLayoutInflater().inflate(R.layout.item_view, null);

    //Создание Layout Params для настройки отступов от границ экрана.
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(24, 0, 24, 24);

    // Инициализация элементов шаблона
        TextView title = view.findViewById(R.id.title);
        TextView descr = view.findViewById(R.id.descr);
        TextView year = view.findViewById(R.id.textView2);

    //Заполнение элементов шаблона из объекта post
        title.setText(post.getLanguage_name());
        //descr.setText(post.getDescript());
        //year.setText(post.getCreation_year() + "");
        view.setLayoutParams(params);
    //Создание Bundle объекта для передачи данных на другую страницу и добавление этого объекта в List
        Bundle bundle = new Bundle();
        bundle.putString("language_name", post.getLanguage_name());
        bundle.putString("descript", post.getDescript());
        bundle.putString("creation_year", post.getCreation_year() + "");
        bundles.add(bundle);

    // Установка тега с номером по списку этого шаблонного элемента
        view.setTag(i + "");

    //Добавление слушателя нажатий
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtras(bundles.get(Integer.parseInt(view.getTag().toString())));
                intent.putExtra("lang_id", Integer.toString(post.getId_language()));
                startActivity(intent);
            }
        });

    // Добавление заполненного шаблонного элемента в LinearLayout на главном экране.
        linMain.addView(view);
    }

    public void onAddButtonClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, CreatingActivity.class);
        startActivity(intent);
    }
}
