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

    public void onClickLevel(View view){
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        String level="";
        switch(buttonText){
            case "Form 1":
                level="1";
                break;
            case "Form 2":
                level="2";
                break;
            case "Form 3":
                level="3";
                break;
            case "Form 4":
                level="4";
                break;
            case "From 5":
                level="5";
                break;
        }

        Intent intent = new Intent(this, Chapters.class);
        intent.putExtra("LEVEL", level);
        intent.putExtra("SELECTION", selection);
        startActivity(intent);
    }

}
