package petruscarvalho.combustivel;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    private EditText alcoolPrice;
    private EditText gasPrice;
    private Button verifyButton;
    private TextView finalResult;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.alcoolPrice = (EditText) findViewById(R.id.alcoolPriceID);
        this.gasPrice = (EditText) findViewById(R.id.gasPriceID);
        this.verifyButton = (Button) findViewById(R.id.verifyButtonID);
        this.finalResult = (TextView) findViewById(R.id.result);



        this.verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                String alcoolPriceText = alcoolPrice.getText().toString();
                String gasPriceText = gasPrice.getText().toString();

                if (alcoolPriceText.isEmpty() || gasPriceText.isEmpty()) {
                    finalResult.setText("Digite os valores de Alcool/Gasolina.");
                    return;
                }

                Double alcool = Double.parseDouble(alcoolPriceText);
                Double gas = Double.parseDouble(gasPriceText);

                Double resultAlcoolGas = alcool / gas;

                if (resultAlcoolGas >= 0.7) {
                    finalResult.setText("É melhor usar Gasolina.");

                } else {
                    finalResult.setText("É melhor usar Álcool.");

                }

                alcoolPrice.setText("");
                alcoolPrice.requestFocus();
                gasPrice.setText("");
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://petruscarvalho.combustivel/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://petruscarvalho.combustivel/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
