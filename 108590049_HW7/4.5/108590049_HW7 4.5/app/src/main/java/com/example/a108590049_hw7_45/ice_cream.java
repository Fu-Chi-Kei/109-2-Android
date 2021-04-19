package com.example.a108590049_hw7_45;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.LinkedList;

public class ice_cream extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ImageView image;
    LinkedList<String> ice_cream = new LinkedList<String>( Arrays.asList(
            "Ingredient:",
            "1 3/4 cups heavy cream",
            "1 1/4 cup whole milk",
            "3/4 cup sugar",
            "1/3 teaspoon fine sea salt",
            "1 tablespoon vanilla extract or",
            "1 vanilla bean split in half lengthwise or",
            "Optional: 2 cups of add-ins – soft brownies, cookies, and blondies work great",
            " ",
            "Procedure:",
            "Step 1.",
            "Pour 1 cup of the cream into a saucepan and add the sugar, salt. Scrape the seeds of the vanilla bean into the pot and then add the vanilla pod to the pot. Warm the mixture over medium heat, just until the sugar dissolves. Remove from the heat and add the remaining cream, milk, and vanilla extract (if using extract). Stir to combine and chill in the refrigerator.",
            "Step 2.",
            "When ready to churn, remove the vanilla pod, whisk mixture again and pour into ice cream maker. Churn according to the manufacturer’s instructions. Transfer the finished ice cream to an airtight container and place in the freezer until ready to serve. Enjoy!",
            "Notes:",
            "Feel free to skip the simmer step and simply whisk everything together, then pour directly into the ice cream maker. The ice cream is absolutely delicious this way, as well as when simmered and chilled first."
    ));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, ice_cream);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        image = findViewById( R.id.imageView);
        image.setImageResource( R.drawable.icecream_circle );
    }
}