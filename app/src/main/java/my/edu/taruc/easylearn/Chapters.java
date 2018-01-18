package my.edu.taruc.easylearn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Chapters extends AppCompatActivity {

    private static int currentHighScore;
    private String selection;
    private String level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        Intent intent = getIntent();
        selection = intent.getStringExtra("SELECTION");
        level = intent.getStringExtra("LEVEL");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,Levels.class);
        intent.putExtra("SELECTION", selection);
        startActivity(intent);
        finish();
    }
    public  void onClickChapter(View view){
        Button b = (Button)view;
        String buttontext = b.getText().toString();
        String chapter;
        if(buttontext.equals("Chapter 1")){
            chapter="1";
        }else if(buttontext.equals("Chapter 2")){
            chapter="2";
        }else if(buttontext.equals("Chapter 3")){
            chapter="3";
        }else if(buttontext.equals("Chapter 4")){
            chapter="4";
        }else if(buttontext.equals("Chapter 5")){
            chapter="5";
        }else if(buttontext.equals("Chapter 6")){
            chapter="6";
        }else{
            chapter=null;
        }

        if (!isConnected()) {
            errorMessageDialog();
        }else {
            if(selection.equals("quiz")){
                Intent intent = new Intent(this, Quiz.class);
                intent.putExtra("CHAPTER", chapter);
                intent.putExtra("LEVEL", level);
                intent.putExtra("SELECTION",selection);
                startActivity(intent);
            }
            if(selection.equals("learning")){
                Intent intent = new Intent(this, Learning.class);
                intent.putExtra("CHAPTER", chapter);
                intent.putExtra("LEVEL", level);
                intent.putExtra("SELECTION",selection);
                startActivity(intent);
            }
        }
    }

    public void errorMessageDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("You are not accessing to the network!")
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                }).create().show();
    }

    private boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();

    }

}
