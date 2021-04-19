package com.example.a108590049_hw7_45;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.LinkedList;

public class froyo extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ImageView image;
    LinkedList<String> froyo = new LinkedList<String>( Arrays.asList(
            "Ingredient:",
            "4 cups frozen fruit",
            "1/2 cup plain Greek yogurt",
            "2 teaspoons vanilla extract",
            "3 Tablespoons honey",

            "Procedure:",
            "Step 1.",
            "In the bowl of a food processor, combine the frozen fruit, Greek yogurt, vanilla extract and honey. Process the mixture until it is creamy, about 5 minutes. (See Kelly's Notes.)",
            "Step 2.",
            "Serve the frozen yogurt immediately or transfer it to an airtight container and freeze it until ready to serve.",
            "KELLY’S NOTES:",
            "1.",
            "The type and size of frozen fruit will determine how long it has to be blended. Sliced frozen bananas may only require 2 to 3 minutes of blending, while larger frozen strawberries or diced mango may require up to 5 minutes.",
            "2.",
            "You can use full-fat Greek yogurt or any percentage of fat, however the more fat, the creamier the frozen yogurt will be.",
            "3.",
            "This Greek frozen yogurt will last up to 1 month when stored properly in an airtight container in the freezer."
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.recyclerview );
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, froyo);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        image = findViewById( R.id.imageView);
        image.setImageResource( R.drawable.froyo_circle );
    }
}