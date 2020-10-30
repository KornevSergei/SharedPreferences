package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


//сохраняем данные пока приложение неудалено в форме ключ значение, простые переменные
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //создаем таблицу, ключ значение и выбираем мод который доступен только в нашем приложении
        SharedPreferences sharedPreferences = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);

        //даём возможность редактировать
        SharedPreferences.Editor editor =  sharedPreferences.edit();
//        //выбираем вариант добавления стринг по ключу и значению
//        editor.putString("newHelloText", "Hello Shared Preferences!");
//        //удаляем новые сохраненные данные
//        editor.remove("newHelloText");
        //удаляем всё полностью
        editor.clear();
        //сохраняем новые данные
        editor.apply();


        //вязываем с разметкой
        TextView textView = findViewById(R.id.textView);
        //устанавливаем данные через обьект и устанавливаем значение по умолчанию если будет нул
        textView.setText(sharedPreferences.getString("newHelloText","Default text"));
    }
}