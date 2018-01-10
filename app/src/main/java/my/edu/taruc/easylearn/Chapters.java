package my.edu.taruc.easylearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Chapters extends AppCompatActivity {

    private String selection;
    private String level;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        Intent intent = getIntent();
        selection = intent.getStringExtra("SELECTION");
        level = intent.getStringExtra("LEVEL");

        textView = (TextView)findViewById(R.id.textView);
        textView.setText(selection.toString()+", "+level);
    }

    public void onClickChapter1(View view){
        String chapter = "1";
        if(selection.equals("quiz")){
            Intent intent = new Intent(this, Quiz.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
        if(selection.equals("learning")){
            Intent intent = new Intent(this, Learning.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
    }
    public void onClickChapter2(View view){
        String chapter = "2";
        if(selection.equals("quiz")){
            Intent intent = new Intent(this, Quiz.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
        if(selection.equals("learning")){
            Intent intent = new Intent(this, Learning.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
    }
    public void onClickChapter3(View view){
        String chapter = "3";
        if(selection.equals("quiz")){
            Intent intent = new Intent(this, Quiz.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
        if(selection.equals("learning")){
            Intent intent = new Intent(this, Learning.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
    }
    public void onClickChapter4(View view){
        String chapter = "4";
        if(selection.equals("quiz")){
            Intent intent = new Intent(this, Quiz.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
        if(selection.equals("learning")){
            Intent intent = new Intent(this, Learning.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
    }
    public void onClickChapter5(View view){
        String chapter = "5";
        if(selection.equals("quiz")){
            Intent intent = new Intent(this, Quiz.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
        if(selection.equals("learning")){
            Intent intent = new Intent(this, Learning.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
    }
    public void onClickChapter6(View view){
        String chapter = "6";
        if(selection.equals("quiz")){
            Intent intent = new Intent(this, Quiz.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
        if(selection.equals("learning")){
            Intent intent = new Intent(this, Learning.class);
            intent.putExtra("CHAPTER", chapter);
            intent.putExtra("LEVEL", level);
            startActivity(intent);
        }
    }

}
