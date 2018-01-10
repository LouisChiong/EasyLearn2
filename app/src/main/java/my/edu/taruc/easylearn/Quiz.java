package my.edu.taruc.easylearn;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Quiz extends AppCompatActivity {

    public static final String TAG = "my.edu.tarc.lab44";
    ListView listViewCourse;
    List<QuizContents> quiz, questions;
    private ProgressDialog pDialog;
    private static String GET_URL;
    RequestQueue queue;

    private String chapter, level, correctAnswers;
    private int chapters,levels;
    private int score;
    private int count=0;
    private int countIndex = 0;
    TextView textViewQuestion;
    Button buttonA, buttonB, buttonC, buttonD;

    String address = "http://chiongluis.000webhostapp.com/getQuiz.php";
    InputStream is =null;
    String line=null;
    String result =null;
    String[] dataLevel;
    String[] dataChapter;
    String[] dataQuestion;
    String[] dataA;
    String[] dataB;
    String[] dataC;
    String[] dataD;
    String[] dataCorrect;

    String[] dataLevels;
    String[] dataChapters;
    String[] dataQuestions;
    String[] dataAnswerA;
    String[] dataAnswerB;
    String[] dataAnswerC;
    String[] dataAnswerD;
    String[] dataCorrectAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        chapter = intent.getStringExtra("CHAPTER");
        level = intent.getStringExtra("LEVEL");

        chapters = Integer.parseInt(chapter);
        levels = Integer.parseInt(level);

        textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);
        buttonA = (Button)findViewById(R.id.buttonA);
        buttonB = (Button)findViewById(R.id.buttonB);
        buttonC = (Button)findViewById(R.id.buttonC);
        buttonD = (Button)findViewById(R.id.buttonD);

        textViewQuestion.setText(levels+", "+chapters);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        getQuizs();

        if(dataLevels[0]!=null){
            displayQuestions(0);
        }else{
            if (!pDialog.isShowing())
                pDialog.setMessage("No data !");
            pDialog.show();
        }

    }

    public void OnclickAnswer(View view){
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        count+=1;
        if(buttonText.equals(correctAnswers)){
            score+=1;
        }
        if(count<10){
            displayQuestions(count);
        }else{
            count=0;
            resultDialog();

        }
    }

    public void resultDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Result")
                .setMessage("You have correct "+score+" out of 10 questions!")
                .setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }).create().show();
    }

    public void displayQuestions(int position){
        if(dataLevels[position]!=null){
            textViewQuestion.setText(dataQuestions[position]);
            buttonA.setText(dataAnswerA[position]);
            buttonB.setText(dataAnswerB[position]);
            buttonC.setText(dataAnswerC[position]);
            buttonD.setText(dataAnswerD[position]);
            correctAnswers = dataCorrectAnswer[position];
        }else{
            if (!pDialog.isShowing())
                pDialog.setMessage("No data !");
            pDialog.show();
        }
    }

    public void getQuizs(){
        getData();

        for(int i=0;i<dataLevel.length;i++){
            if(dataLevel[i].toString().equals(level.toString())){
                if(dataChapter[i].toString().equals(chapter.toString())){
                    countIndex+=1;
                }

            }
        }

        dataLevels = new String[countIndex+1];
        dataChapters = new String[countIndex+1];
        dataQuestions = new String[countIndex+1];
        dataAnswerA = new String[countIndex+1];
        dataAnswerB = new String[countIndex+1];
        dataAnswerC = new String[countIndex+1];
        dataAnswerD = new String[countIndex+1];
        dataCorrectAnswer = new String[countIndex+1];

        int counting=0;
        for(int i=0;i<dataLevel.length;i++){
            if(dataLevel[i].toString().equals(level.toString())){
                if(dataChapter[i].toString().equals(chapter.toString())){
                    dataLevels[counting] = dataLevel[i];
                    dataChapters[counting] = dataChapter[i];
                    dataQuestions[counting] = dataQuestion[i];
                    dataAnswerA[counting] = dataA[i];
                    dataAnswerB[counting] = dataB[i];
                    dataAnswerC[counting] = dataC[i];
                    dataAnswerD[counting] = dataD[i];
                    dataCorrectAnswer[counting] = dataCorrect[i];
                    counting++;
                }
            }
        }
    }

    private void getData(){
        try{
            URL url = new URL(address);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line = br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            JSONArray ja =new JSONArray(result);
            JSONObject jo=null;

            dataLevel = new String[ja.length()];
            dataChapter = new String[ja.length()];
            dataQuestion = new String[ja.length()];
            dataA = new String[ja.length()];
            dataB = new String[ja.length()];
            dataC = new String[ja.length()];
            dataD = new String[ja.length()];
            dataCorrect = new String[ja.length()];

            for(int i=0;i<ja.length();i++){
                jo = ja.getJSONObject(i);
                dataLevel[i]=jo.getString("level");
                dataChapter[i]=jo.getString("chapter");
                dataQuestion[i]=jo.getString("question");
                dataA[i]=jo.getString("answerA");
                dataB[i]=jo.getString("answerB");
                dataC[i]=jo.getString("answerC");
                dataD[i]=jo.getString("answerD");
                dataCorrect[i]=jo.getString("correctAnswer");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
