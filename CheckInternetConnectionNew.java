// -------------- WackyCodes--------------------

// Create A New Class For Checking Internet Connection...
// Class Neme = IJ_CheckInternetConnection

public class IJ_CheckInternetConnection {


    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo;
        netinfo = cm.getActiveNetworkInfo();
        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo( ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true; else return false;
        } else
            return false;
    }
    public AlertDialog.Builder buildDialog(Context c) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection !");
        builder.setMessage("Check Your Internet Connection.\nYou need to have Mobile Data or wifi...");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });

        return builder;
    }

    public boolean checkInternet(Context context){
        if(!isConnected(context)){
            buildDialog(context).show();
            return true;
        }
        else
            return false;

    }
}

// ----- Add below code in any activity or fragments and call-------

// Create a function isConnectInternet() first...
    private boolean isConnectInternet() {
        IJ_CheckInternetConnection checkInternetCON = new IJ_CheckInternetConnection();
        if ( checkInternetCON.checkInternet( getActivity())){
            return false;
        }
        else
        return true;
    }
    
//  ----- OR -----
    CheckInternetCON checkInternetCON = new CheckInternetCON();
        if(!checkInternetCON.checkInternet( RegistrationActivity.this )){
            // You can write your code here...
        }


// Call isConnectInternet() for check internet connection.

    if (isConnectInternet()) {
        // write your code here... 
    }

// Thank You..! WackyCodes...