package com.example.ts_yfzx_cqe.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.FruitAdapter;
import com.example.util.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple",
            "Staweberry","Cherry","Mango"};
    private int[] image ={R.drawable.apple,R.drawable.banana,R.drawable.orange,
            R.drawable.watermelon,R.drawable.pear,R.drawable.grape,
            R.drawable.pineapple,R.drawable.staweberry,R.drawable.cherry,R.drawable.mango};

    private ListView listView;
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);

        initFruit();//初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        initEvent();
    }

    private void initFruit() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j< data.length; j++){
                Fruit fruit = new Fruit(data[j],image[j]);
                fruitList.add(fruit);
            }
        }
    }

    private void initEvent(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,"当前点击的是："+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
