// --------------  WackyCodes...-----------------------------
// This code for showing Alert Message in our Activity...

public class IJ_AlertMessage_Class {
    //    Method for showing alert Message with Single Button...
    public void w_SingleButtonAlertDialog(String alertMessage, String buttonText, Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder( context );
        builder.setMessage( alertMessage );
        builder.setCancelable( true );

        builder.setPositiveButton( buttonText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface wDialog, int id) {
                wDialog.cancel();
            }
        } );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //    Method for showing alert Message with Double Button...
    public void w_DoubleButtonAlertDialog(String alertMessage, String buttonText1, String buttonText2, Context context) {
        final boolean returnMSG;
        AlertDialog.Builder builder = new AlertDialog.Builder( context );
        builder.setMessage( alertMessage );
        builder.setCancelable( true );

        builder.setPositiveButton( buttonText1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface wDialog, int id) {
                wDialog.cancel();
            }
        } );

        builder.setNegativeButton( buttonText2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface wDialog, int id) {
                wDialog.cancel();
            }
        } );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

//  Call This class using Below Code from any Class or fragment...

    // get object reference of the class...
    IJ_AlertMessage_Class alertMessage_class = new IJ_AlertMessage_Class();
    // call method for Signle button alert Dialog...
    alertMessage_class.w_SingleButtonAlertDialog( msg, "OK" , getActivity());
    // call method for Double button alert Dialog...
    alertMessage_class.w_DoubleButtonAlertDialog( msg, "OK" , "cancel" getActivity());

//  Thank You ..!!
//  Stay with WackyCodes...
