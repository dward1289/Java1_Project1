/*
 * Project:	Project1
 * 
 * Package:	com.DevonaWard.project1
 * 
 * @author Devona Ward
 * 
 * Date: Aug 8, 2013
 * 
 * 
 * This application is about my love for sneakers,
 * and possibly owning a large collection of sneakers
 * some day.
 */
package com.DevonaWard.project1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	LinearLayout linearLayout;
	LinearLayout.LayoutParams layoutParams;
	
	String question = "How many pairs of sneakers do you own?";
	String starTxt;
	int coolNum = 100;
	int starNum;
	boolean correct = true;
	EditText editTxt;
	TextView results;
	TextView coolVw;
	
	/* The StringBuilder helped me to display my for-loop results
	 * in multiple strings. I researched and found StringBuilder
	 * at: http://stackoverflow.com/questions/11130609/android-for-loop*/
	StringBuilder coolBuy = new StringBuilder(); 
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        layoutParams = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        
        /* The TextView asks the question, and the user will type the
         * answer in the EditText area. The user will select the "Ok" button,
         * and a response will appear.
        */
        TextView txtVw = new TextView(this);
        txtVw.setText(question);
        linearLayout.addView(txtVw);
        
        editTxt = new EditText(this);
        editTxt.setHint(getString(R.string.instruct));
        
        Button btn = new Button(this);
        btn.setText("Ok");
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				results.setText("That's cool!");
			}
		});
        
        /* The condition is comparing the int of coolNum to 50 and will display text
         * in response.
         */
        if(coolNum >= 50){
        	coolVw = new TextView(this);
        	coolVw.setText("I wish I had " + coolNum + " pairs of sneakers.");
        }
        
        /* The for loop multiplies int x by 5, and displays text with the updated
         * number of x until it reaches 20.
         */
        for(int x = 5; x <= 20; x = x*2){
        	coolBuy.append("Maybe I will buy " + x + " more pairs of sneakers. \n");
        }
        
        /* Add function has been called.*/
        add(3,2);
        
        /* The bool answers if I will say true or false in the statement.*/
        TextView truthVw = new TextView(this);
        truthVw.setText("Ask me if LeBrons are my favorite shoes, and I will say that is "+ correct + "!");
        
        /* This TextView holds the text that is called from the add function.*/
        TextView starVw = new TextView(this);
        starVw.setText(starTxt);
        
        /* This TextView holds the text from the for-loop.*/
        TextView buyVw = new TextView(this);
        buyVw.setText(coolBuy);
        
        /*The objects created are added to the LinearLayout to be displayed
         * when the application is Ran/Debugged.*/
        linearLayout.addView(editTxt);
        linearLayout.addView(btn);
        
        linearLayout.addView(buyVw);
        linearLayout.addView(truthVw);
        linearLayout.addView(coolVw);
        linearLayout.addView(starVw);
        
        results = new TextView(this);
        results.setLayoutParams(layoutParams);
        linearLayout.addView(results);
        
        setContentView(linearLayout);
        
        
        
    }
    /* The function will add two integers together, and save
     * the sum to a string. The string will display in starVw 
     * once function is called. */
    public void add(int a, int b)
    { 
     starNum=(a+b);
     
     starTxt="A great shoe collection deserves " + starNum + " stars.";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
