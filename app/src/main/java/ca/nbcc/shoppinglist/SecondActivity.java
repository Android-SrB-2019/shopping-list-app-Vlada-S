package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "ca.nbcc.shoppinglist.extra.REPLY";

    private Button apples;
    private Button bananas;
    private Button oranges;
    private Button tomatoes;
    private Button onions;
    private Button potatoes;
    private Button carrots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_second );

        apples = findViewById( R.id.button_apples );
        bananas = findViewById( R.id.button_bananas );
        oranges = findViewById( R.id.button_oranges );
        tomatoes = findViewById( R.id.button_tomatoes );
        onions = findViewById( R.id.button_onions );
        potatoes = findViewById( R.id.button_potatoes );
        carrots = findViewById( R.id.button_carrots );
    }

    public void addItem(View view) {
        Button btn = (Button) view;
        String reply = btn.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra( EXTRA_REPLY, reply );
        setResult( RESULT_OK, replyIntent );
        finish();
    }
}