package com.android.saarthak.lifecycledemo;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel=ViewModelProviders.of(this,new MainActivityViewModelFactory(5)).get(MainActivityViewModel.class);
        textView=findViewById(R.id.tvCount);
        textView.setText("Count is: "+mainActivityViewModel.getCount());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivityViewModel.IncreaseCount();
            }
        });
        LiveData<Integer> liveData=mainActivityViewModel.getCount();
        liveData.observe(MainActivity.this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(("Count is: "+integer));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //lifecycle methods

}
