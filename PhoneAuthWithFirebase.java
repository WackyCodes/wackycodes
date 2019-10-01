// ------------ WackyCodes... --------------

// Add the dependency for the Firebase Authentication Android library to your module (app-level) Gradle file (usually app/build.gradle):

//  implementation 'com.google.firebase:firebase-auth:19.0.0'

// If you haven't already set your app's SHA-1 hash in the Firebase console, do so. See Authenticating Your Client for information about finding your app's SHA-1 hash.


// _______________________________________________________

String sendCode_str;

// wCallBacks is a variable which is define either onCreate() method or onViewCreate() method...

//   --------------- wCallBacks variable --------------

        final PhoneAuthProvider.OnVerificationStateChangedCallbacks wCallBacks =
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent( s, forceResendingToken );
        				// sendCode_str is code which send on given mobile number...
                        sendCode_str = s;
                        Toast.makeText( getActivity(), "OTP Code sent On your Mobile Number...", Toast.LENGTH_SHORT ).show();
                        wVerifyCodeBtn.setVisibility( View.VISIBLE );
                    }

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                        Toast.makeText( getActivity(), "Verification Complete Successfully + 1", Toast.LENGTH_SHORT ).show();

                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {

                        Toast.makeText( getActivity(), "OTP can't Send... Error: "+ e, Toast.LENGTH_SHORT ).show();
                    }

                };
//   --------------- wCallBacks variable -------------

// _______________________________________________________
// wSendCodeBtn is button on which user click after Enter their mobile number...
		wSendCodeBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wUserPhone_str =  wNewUserPhone.getText().toString().trim();
                if (isValidPhone(wUserPhone_str) && isConnectInternet()){ //isConnectInternet() for check internet connection...

                    w_UserRegistration(wCallBacks);
                }
            }
        } );
// ______________________________________ Functions and Methods ___________________________________________________

 //    Verify Sign Code....
    private void verifySignInCode(){
    	// wCode is EditText where user will Enter Code which is send on given Mobile number
        String code_str = wCode.getText().toString().trim();
        // sendCode_str is code which send on given mobile number...
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential( sendCode_str, code_str );
        signInWithPhoneAuthCredential( credential );
    }

//    signInWithPhoneAuthCredential method...
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener <AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task <AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText( getActivity(),"Login Successfully", Toast.LENGTH_SHORT ).show();
                            // here You can add your code to shift user in another activity after Login
                        } else {
                            Toast.makeText( getActivity(),"Login Failed", Toast.LENGTH_SHORT ).show();

                        }
                    }
                });
    }

//  w_UserRegistration method...
    // wCallBacks is a variable which is define either onCreate() method or onViewCreate() method...
    private void w_UserRegistration(PhoneAuthProvider.OnVerificationStateChangedCallbacks wCallBacks) {

    	// wNewUserPhone is EditText where user will give their phone number for receive the code
        String wUserPhone_str =  wNewUserPhone.getText().toString().trim();

//        ---------------------
        PhoneAuthProvider.getInstance().verifyPhoneNumber( "+91" + wUserPhone_str,60, TimeUnit.SECONDS,
                getActivity(), wCallBacks );
        Toast.makeText( getActivity(), "Verification send successfully", Toast.LENGTH_SHORT ).show();
    }

// _________________________________________________________________________________________
