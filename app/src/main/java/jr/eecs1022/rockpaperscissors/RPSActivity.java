package jr.eecs1022.rockpaperscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class RPSActivity extends AppCompatActivity
{
    private static final String MODULE = "RSPActivity";

    private int curDrawable = R.drawable.splash;
    //private int curState = 0;
    private States curState = States.SPLASH;
    private enum States {SPLASH,THREE,TWO,ONE,ANSWER};
    private Random ran = new Random();
    int ranState = ran.nextInt(3);

    public void buttonPressed(View view) {

        Button but = (Button)findViewById(R.id.button);
        System.out.println("buttonPressed called");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        if(curState == States.SPLASH){
            curDrawable = R.drawable.image3;
            but.setText("Continue!");
            curState = States.THREE;

        }else if(curState == States.THREE){
            curDrawable = R.drawable.image2;
            but.setText("Continue!!");
            curState = States.TWO;

        }else if(curState == States.TWO){
            curDrawable = R.drawable.image1;
            but.setText("Continue!!!");
            curState = States.ONE;

        }else if(curState == States.ONE) {
            if (ranState == 0) {
                curDrawable = R.drawable.rock;
                //but.setText("ROCK");
            } else if (ranState == 1) {
                curDrawable = R.drawable.paper;
                //but.setText("PAPER");
            } else if (ranState == 2) {
                curDrawable = R.drawable.scissors;
                //but.setText("Scissor");
            }
            but.setText("Play Again");
            curState = States.ANSWER;
        }
        else if(curState == States.ANSWER){
            curDrawable = R.drawable.splash; // change to rules after
            but.setText("Start");
            curState = States.SPLASH;
        }
        imageView.setImageResource(curDrawable);
        System.out.println("buttonPressed done");

    }
        /*
        if(curState == 0){
            curDrawable = R.drawable.splash;
            but.setText("Start");
            curState++;
        }else if(curState == 1) {
            curDrawable = R.drawable.image3;
            but.setText("Continue!");
            curState++;
        }else if(curState == 2) {
            curDrawable = R.drawable.image2;
            but.setText("Continue!!");
            curState++;
        }else if(curState == 3){
            curDrawable = R.drawable.image1;
            but.setText("Continue!!!");
            curState++;
        }else if(curState == 4){

            if(ranState == 0){
                curDrawable = R.drawable.rock;
                //but.setText("ROCK");
            }else if(ranState == 1){
                curDrawable = R.drawable.paper;
                //but.setText("PAPER");
            }else if(ranState == 2){
                curDrawable = R.drawable.scissors;
                //but.setText("Scissor");
            }
            but.setText("Play Again");
            curState = 0;
        }

        /*
        if (curDrawable == R.drawable.splash) {
            curDrawable = R.drawable.scissors;
        }
        else{
            curDrawable = R.drawable.splash;
        }
        */





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_r, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        System.out.println("onSaveInstanceState called");
        super.onSaveInstanceState(outState);
        outState.putInt("image", curDrawable);
        outState.putSerializable("currImage", curState.name());

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        System.out.println("onRestoreInstanceState called");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.button);

        super.onRestoreInstanceState(savedInstanceState);

        curDrawable = savedInstanceState.getInt("image");
        if(savedInstanceState.get("currImage").equals(States.SPLASH.toString())){
            curState = States.SPLASH;
            imageView.setImageResource(curDrawable);
            textView.setText("Start");

        }else if(savedInstanceState.get("currImage").equals(States.THREE.toString())){
            curState = States.THREE;
            imageView.setImageResource(curDrawable);
            textView.setText("Continue!");

        }else if(savedInstanceState.get("currImage").equals(States.TWO.toString())){
            curState = States.TWO;
            imageView.setImageResource(curDrawable);
            textView.setText("Continue!!");

        }else if(savedInstanceState.get("currImage").equals(States.ONE.toString())){
            curState = States.ONE;
            imageView.setImageResource(curDrawable);
            textView.setText("Continue!!!");

        }else if(savedInstanceState.get("currImage").equals(States.ANSWER.toString())){
            curState = States.ANSWER;
            imageView.setImageResource(curDrawable);
            textView.setText("Play Again");

        }

    }
/*
   @Override
     protected void onRestoreInstanceState(Bundle savedInstanceState)
{
    System.out.println("onRestoreInstanceState called");
    ImageView imageView = (ImageView) findViewById(R.id.imageView);
    TextView textView = (TextView) findViewById(R.id.button);

    super.onRestoreInstanceState(savedInstanceState);


    curDrawable = savedInstanceState.getInt("image");
    curState = savedInstanceState.getInt("currImage");

    // update the display using curDrawable here …
    System.out.println(" " + curState);
    //Button but = (Button)findViewById(R.id.button);
    if(curState == 0){
        //curDrawable = R.drawable.splash;
        System.out.println("*** splash");
        textView.setText("Start");
        curDrawable = R.drawable.splash;
        imageView.setImageResource(curDrawable);
        curState = 0;
        //curState++;
    }else if(curState == 1) {
       // curDrawable = R.drawable.image3;
        curDrawable = R.drawable.image3;
        textView.setText("Continue!");
        imageView.setImageResource(curDrawable);
        System.out.println("*** image3");
       // curState = 1;
        //curState++;
    }else if(curState == 2) {
        curDrawable = R.drawable.image2;
        textView.setText("Continue!!");
        System.out.println("*** image2");
        imageView.setImageResource(curDrawable);
        curState = 2;
        //curState++;
    }else if(curState == 3){
        curDrawable = R.drawable.image1;
        textView.setText("Continue!!!");
        System.out.println("*** image1");
        imageView.setImageResource(curDrawable);
        curState = 3;
        //curState++;
    }else if(curState == 4){
            //int ranState = ran.nextInt(3);
        /*
        if(ranState == 0){
            curDrawable = R.drawable.rock;
            //imageView.setImageResource(curDrawable);
            textView.setText("ROCK");
        }else if(ranState == 1){
            curDrawable = R.drawable.paper;
            //imageView.setImageResource(curDrawable);
            textView.setText("PAPER");
        }else if(ranState == 2){
            curDrawable = R.drawable.scissors;
            //imageView.setImageResource(curDrawable);
            textView.setText("Scissor");
        }

        curState = 4;
        textView.setText("Play Again");
        imageView.setImageResource(curDrawable);
    }



}
*/



}
