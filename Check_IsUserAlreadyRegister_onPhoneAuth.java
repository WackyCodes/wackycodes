// --------------  WackyCodes....----------------

// Check Whether user has already registered or not...--------------
// ------------- before register the user on Firebase call this method --------------
    private void isUserAlreadySignUp(String phone){
        firebaseAuth = FirebaseAuth.getInstance();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("authUser");
        // after getting reference of child, checked orderbykey so we get if phone is key we can get ref in dataSnapshot...
        databaseReference.child( "userPhone" ).orderByKey().equalTo( phone ).addListenerForSingleValueEvent( new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    showToast("This number is already Registered ..!!");
                    // w_alertDialog( "This number is already Registered ..!!" ); 
                    //  userDefine method for showing alert message
                   // wSignUpProgressBar.setVisibility( View.GONE );
                }
                else
                {
                    // if mobile is not registered you can go ahead...
                    // You can write your further code here or call relative methods...
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                showToast("Error :" + databaseError);
                // wSignUpProgressBar.setVisibility( View.GONE );
            }
        } );
    }

    private  void  showToast(String s){
        Toast.makeText( getActivity(), s , Toast.LENGTH_SHORT ).show();
    }

    // For Registering user on the database --------------------------
    private  void registerUserOnDatabase( String userPhone){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("authUser").child("userPhone");
        userRef.child( userPhone ).setValue( userPhone );
        showToast( "Verification and Login Successfully..!!" );
    }

    // ------------------------------------------------------------------
// Thank You..!!
// Stay With WackyCodes...
