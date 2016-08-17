/* application uses images and launcher icon that have been copied from the internet.
*/
package com.example.akanksha.prime_app;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num,x=0;
    TextView t1;

    private static final String ABC = "preferences";
    public static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView);
        if (savedInstanceState != null) {
            CharSequence savedText = savedInstanceState.getString("prime");
            t1.setText(savedText);
            count=savedInstanceState.getInt("Count");
            if(x==1) {
                //restore prefernces after pausing or stopping app
                SharedPreferences settings = getSharedPreferences(ABC, 0);
                int num1 = settings.getInt("number", num);
                t1.setText(Integer.toString(num1));
            }

        }
        else
        {
            random();}


    }


    public void random()
    {
        Random r=new Random();
        num=r.nextInt((1000-2)+1)+2;
        t1.setText(Integer.toString(num));
    }

    public void onButtonClick1(View v)
    {
        int i,flag=0;
        for(i=2;i<num;i++)
        {
            if(num%i==0)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
            Toast.makeText(MainActivity.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
        else{
            count++;
            Toast.makeText(MainActivity.this,"Correct Answer",Toast.LENGTH_SHORT).show();}
        random();

    }

    public void onButtonClick2(View v)
    {
        int i,flag=0;
        for(i=2;i<num;i++)
        {
            if(num%i==0)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
        {   count++;
            Toast.makeText(MainActivity.this,"Correct Answer",Toast.LENGTH_SHORT).show();}
        else
            Toast.makeText(MainActivity.this,"Wrong Answer",Toast.LENGTH_SHORT).show();

        random();

    }

    public void onButtonClick3(View v)
    {
        random();
    }

    public void onButtonClick4(View v)
    {
        Toast.makeText(MainActivity.this,Integer.toString(count),Toast.LENGTH_SHORT).show();
    }
    public void onButtonClick5(View v)
    {
        count=0;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putCharSequence("prime",t1.getText().toString()); /*saving state before rotation */
        savedInstanceState.putInt("Count",count);
    }



    public void onBackPressed() //storing data if back button is pressed
    {
        super.onBackPressed();
        x=1;
        //storing preferences on pausing
        SharedPreferences settings = getSharedPreferences(ABC,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("number",num);
        editor.commit(); //commit the changes

    }

}//class ends
