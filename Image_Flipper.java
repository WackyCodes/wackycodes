//----------------------------- Wacky Android File ----------------------------


//****************************************************************************

//------------------- Image Flipper -----------------------------

//for XML = ViewFlipper

//.java file...


wViewFlipper = findViewById( R.id.wViewFlipperImg );
        for(int i=0;i<wPromote_img.length;i++){
            flip_Image(wPromote_img[i]);
        }

 public void flip_Image(int i){
        ImageView view = new ImageView( this );
        view.setBackgroundResource( i );
        wViewFlipper.addView( view );
        wViewFlipper.setFlipInterval( 2000 );
        wViewFlipper.setAutoStart( true );

        wViewFlipper.setInAnimation( this,android.R.anim.slide_in_left );
        wViewFlipper.setOutAnimation( this,android.R.anim.slide_out_right );

    }

//****************************************************************************