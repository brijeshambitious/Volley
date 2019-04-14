package e.hg.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements Response.Listener<String>,Response.ErrorListener,View.OnClickListener {

     Button btn;
    TextView txt;
     String url;
     StringRequest request;

     RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        txt=(TextView) findViewById(R.id.textView);
        btn.setOnClickListener(this);



    }



    @Override
    public void onErrorResponse(VolleyError error) {
        txt.setText(error.getMessage());

    }

    @Override
    public void onResponse(String response) {
        txt.setText(response);

    }

    @Override
    public void onClick(View v) {
        queue= Volley.newRequestQueue(getApplicationContext());
        url="https://www.w3schools.com/xml/note.xml";
        request=new StringRequest(url,this,this);
        queue.add(request);
    }
}
