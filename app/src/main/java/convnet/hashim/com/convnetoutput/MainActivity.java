package convnet.hashim.com.convnetoutput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    int height=0,width=0,depth=0;
    int size=0,number=0,stride=1,pad=0;


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
        if(view.getId()==R.id.calculateBtn){
            getValues();
            int h = returnHeight(height,size,stride,pad);
            int w = returnWidth(width,size,stride,pad);
            int d = returnDepth(number);
            String output = " ( "+h+" , "+w+" , "+d+" ) ";
            Toast.makeText(this,output,Toast.LENGTH_LONG).show();

        }

    }

    public int returnHeight(int height,int f,int s,int p){
        int pad = 2*p;
        int total = ((height+pad-f)/s)+1;
        return total;
    }

    public int returnWidth(int width, int f,int s,int p){
        int pad = 2*p;
        int total = ((width+pad-f)/s)+1;
        return total;
    }

    public int returnDepth(int numOfFilter){

        return numOfFilter;
    }

    public void getValues(){
        //input layer
        String h = heightText.getText().toString();
        if(!h.isEmpty()){
            height = Integer.parseInt(h);
        }else{
            heightText.setText("0");
            height = 0;
        }

        String w = widthText.getText().toString();

        if(!w.isEmpty()) {
            width = Integer.parseInt(w);
        }else{
            widthText.setText("0");
            width = 0;
        }

        String d = depthText.getText().toString();

        if(!d.isEmpty()) {
            depth = Integer.parseInt(d);
        }else{
            depthText.setText("0");
            depth = 0;
        }

        // convolutional layers

        String si = sizeFText.getText().toString();

        if(!si.isEmpty()) {
            size = Integer.parseInt(si);
        }else{
            sizeFText.setText("0");
            size = 0;
        }

        String f = noFText.getText().toString();

        if(!f.isEmpty()) {
            number = Integer.parseInt(f);
        }else{
            noFText.setText("0");
            number = 0;
        }

        String st = strideText.getText().toString();

        if(!st.isEmpty()) {
            stride = Integer.parseInt(st);
        }else{
            strideText.setText("1");
            stride = 1;
        }

        String p = paddingText.getText().toString();

        if(!p.isEmpty()) {
            pad = Integer.parseInt(p);
        }else{
            paddingText.setText("0");
            pad = 0;
        }


    }


}
