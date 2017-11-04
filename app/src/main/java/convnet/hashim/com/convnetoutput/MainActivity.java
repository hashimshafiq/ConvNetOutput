package convnet.hashim.com.convnetoutput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button calcbtn = null;
    Button resetbtn = null;
    EditText heightText = null;
    EditText widthText = null;
    EditText depthText = null;
    EditText sizeFText = null;
    EditText noFText = null;
    EditText strideText = null;
    EditText paddingText = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // input layers
        heightText = (EditText) findViewById(R.id.heightText);
        widthText = (EditText) findViewById(R.id.widthText);
        depthText = (EditText) findViewById(R.id.depthText);

        //filter layer
        sizeFText = (EditText) findViewById(R.id.filterText);
        noFText = (EditText) findViewById(R.id.numberOfFilterText);
        strideText = (EditText)findViewById(R.id.stridesText);
        paddingText = (EditText) findViewById(R.id.paddingText);

        // buttons
        calcbtn = (Button) findViewById(R.id.calculateBtn);
        calcbtn.setOnClickListener(this);
        resetbtn = (Button) findViewById(R.id.resetBtn);
        resetbtn.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

    }
}
