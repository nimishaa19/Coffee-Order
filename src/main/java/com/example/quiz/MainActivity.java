package com.example.quiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int num=0;
    /**

     This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int total=num*5;
        CheckBox cream=(CheckBox) findViewById(R.id.checkBox);
        CheckBox chocolate=(CheckBox) findViewById(R.id.checkBox2);
        EditText name_field=(EditText) findViewById(R.id.name);
        EditText mail_field=(EditText) findViewById(R.id.mail);

        String name=name_field.getText().toString();
        String mail=mail_field.getText().toString();
        boolean hasCream=cream.isChecked();
        boolean hasChocolate=chocolate.isChecked();

        if(hasChocolate){
            total=total+2;
        }
        if(hasCream){
            total=total+1;
        }



        String priceMessage= "Name: "+name+"\nTotal: $"+ total + "\nWhipped Cream?: "+hasCream +"\nChocolate?: "+hasChocolate+"\nThank You!";
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ mail});
        email.putExtra(Intent.EXTRA_SUBJECT,"Coffee for "+name);
        email.putExtra(Intent.EXTRA_TEXT,priceMessage);

//need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(email);


    }
    public void increment(View view){

        num=num+1;

        display(num);

    }

   public void decrement(View view){

        num=num-1;
        if(num>=0){
            display(num);}
        else{
            num=0;
            display(num);

        }

    }


    /**

     This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */

    /**
     * This method displays the given text on the screen.
     */



}