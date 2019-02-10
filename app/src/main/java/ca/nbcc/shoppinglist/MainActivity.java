package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;

    private ShoppingList shoppingList = new ShoppingList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            LinearLayout ll = findViewById(R.id.item_layout);
            ll.removeAllViews();
            List<ShoppingList.Item> newList = shoppingList.getList();
            for(ShoppingList.Item item : newList){
                TextView tv = new TextView(this);
                tv.setText(item.name + " " + item.count.toString());
                tv.setText(savedInstanceState
                        .getString("reply_text"));
                ll.addView(tv);
            }
        }

    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        //launch second activity
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                shoppingList.addItem(item);
                showList();
            }
        }
    }

    private void showList(){
        LinearLayout ll = findViewById(R.id.item_layout);
        ll.removeAllViews();
        List<ShoppingList.Item> newList = shoppingList.getList();
        for(ShoppingList.Item item : newList){
            TextView tv = new TextView(this);
            tv.setText(item.name + " " + item.count.toString());
            tv.setTextSize( 30 );
            ll.addView(tv);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LinearLayout ll = findViewById(R.id.item_layout);
        ll.removeAllViews();
        List<ShoppingList.Item> newList = shoppingList.getList();
        for(ShoppingList.Item item : newList){
            TextView tv = new TextView(this);
            tv.setText(item.name + " " + item.count.toString());
            outState.putString("reply_text",
                    tv.getText().toString());
            ll.addView(tv);
        }

        }

}