package com.example.shailendra.quickshop;

import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {

    Button wMultiSelectBtn;
    TextView wTextView;
    String[] wMultiselectString;
    boolean[] checkItems;
    ArrayList<Integer> wUserItem = new ArrayList <>(  );


    ViewFlipper wViewFlipper;
    int[] wPromote_img = {
            R.drawable.pp,
            R.drawable.pnr,
            R.drawable.pp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        //-----------------------------

        wMultiSelectBtn = findViewById( R.id.wMultiSelectBtn );
        wTextView = findViewById( R.id.wMultiSelectText );

        wMultiselectString = getResources().getStringArray( R.array.sub_selected );

        checkItems = new boolean[wMultiselectString.length];

        wMultiSelectBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder wBuilder= new AlertDialog.Builder( Activity1.this );
                wBuilder.setTitle( "Selct Any 5 Subjects..." );
                wBuilder.setMultiChoiceItems( wMultiselectString, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked){
                            if ( !wUserItem.contains( which )){
                                wUserItem.add( which );
                            }
                        }else {
                            if (wUserItem.contains( which )){
                                wUserItem.remove( which );
                            }
                        }

                    }
                } );
                wBuilder.setPositiveButton( "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String items = " ";
                        for (int i = 0; i<wUserItem.size();i++){
                            items = items +  wMultiselectString[wUserItem.get( i )];
                        }
                        wTextView.setText( items+"\n" );
                    }
                } );

                wBuilder.setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                } );

                wBuilder.setNeutralButton( "Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i =0; i< checkItems.length; i++){
                            checkItems[i] =false;
                            wUserItem.clear();
                            wTextView.setText( "" );
                        }
                    }
                } );

                AlertDialog wDialog = wBuilder.create();
                wDialog.show();
            }
        } );


        //-----------------------------

       
    }

   
}
