package com.example.bhuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView homebtn, reqaccepted;
    int donate, receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        homebtn = findViewById(R.id.homebtn);
        reqaccepted = findViewById(R.id.req_accepted);

        Intent i = getIntent();
        donate = i.getIntExtra("donate", 0);
        receive = i.getIntExtra("receive", 0);

        if(donate == 1 && receive == 0)
        {
            homebtn.setImageResource(R.drawable.homepageoutline);
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction t = m.beginTransaction();
            Fragment Home = new home();
            t.replace(R.id.fragment, Home);
            t.commit();
        }
        else if (donate == 0 && receive == 1)
        {
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction t = m.beginTransaction();
            Fragment receiver = new recieverhome();
            t.replace(R.id.fragment, receiver);
            t.addToBackStack(null);
            t.commit();

        }

//        homebtn = findViewById(R.id.homebtn);
//
//        homebtn.setImageResource(R.drawable.homepageoutline);
//        FragmentManager m = getSupportFragmentManager();
//        FragmentTransaction t = m.beginTransaction();
//        Fragment Home = new home();
//        t.replace(R.id.fragment, Home);
//        t.commit();

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homebtn.setImageResource(R.drawable.colorhome);
                reqaccepted.setImageResource(R.drawable.approvedoutline);
                FragmentManager m = getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Fragment Home = new home();
                t.replace(R.id.fragment, Home);
                t.addToBackStack(null);
                t.commit();
            }
        });


        reqaccepted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homebtn.setImageResource(R.drawable.homepageoutline);
                reqaccepted.setImageResource(R.drawable.approvedcolour);
//                FragmentManager m = getSupportFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                Fragment requestaccepted = new RequestAccepted();
//                t.replace(R.id.fragment,requestaccepted);
//                t.addToBackStack(null);
//                t.commit();
            }
        });
    }
}