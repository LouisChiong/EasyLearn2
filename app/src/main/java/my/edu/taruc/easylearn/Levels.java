package my.edu.taruc.easylearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Levels extends AppCompatActivity {


    private String selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        Intent intent = getIntent();
        selection = intent.getStringExtra("SELECTION");
    }

    public void onClickFrom1(View view){
        String level ="1";
        Intent intent = new Intent(this, Chapters.class);
        intent.putExtra("LEVEL", level);
        intent.putExtra("SELECTION", selection);
        startActivity(intent);
    }
    public void onClickFrom2(View view){
        String level ="2";
        Intent intent = new Intent(this, Chapters.class);
        intent.putExtra("LEVEL", level);
        intent.putExtra("SELECTION", selection);
        startActivity(intent);
    }
    public void onClickFrom3(View view){
        String level ="3";
        Intent intent = new Intent(this, Chapters.class);
        intent.putExtra("LEVEL", level);
        intent.putExtra("SELECTION", selection);
        startActivity(intent);
    }
    public void onClickFrom4(View view){
        String level ="4";
        Intent intent = new Intent(this, Chapters.class);
        intent.putExtra("LEVEL", level);
        intent.putExtra("SELECTION", selection);
        startActivity(intent);
    }
    public void onClickFrom5(View view){
        String level ="5";
        Intent intent = new Intent(this, Chapters.class);
        intent.putExtra("LEVEL", level);
        intent.putExtra("SELECTION", selection);
        startActivity(intent);
    }
}
