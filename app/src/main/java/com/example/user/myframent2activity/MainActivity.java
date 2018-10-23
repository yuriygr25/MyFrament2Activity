package com.example.user.myframent2activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button fragment1Button, fragment2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1Button = (Button) findViewById(R.id.buttonFragment1);
        fragment2Button = (Button) findViewById(R.id.buttonFragment2);


        // get an instance of FragmentTransaction from your Activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //add a fragment
        FirstFragment firstFragment = new FirstFragment();
        fragmentTransaction.add(R.id.container,firstFragment);
        fragmentTransaction.commit();

        fragment1Button.setOnClickListener(onButtonClickListener);
        fragment2Button.setOnClickListener(onButtonClickListener);
    }

    Button.OnClickListener onButtonClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Fragment newFragment = null;


            // Create new fragment
            if (v ==fragment1Button) {
                newFragment=new FirstFragment();
            } else {
                newFragment = new SecondFragment();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();


            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    };
}