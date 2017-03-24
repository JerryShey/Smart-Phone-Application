package com.example.tung.bmicalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calc;
    EditText kg, cm;
    TextView BMI, BMItype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kg = (EditText)findViewById(R.id.edit_weight);
        cm = (EditText)findViewById(R.id.edit_height);
        calc = (Button)findViewById(R.id.btn_calc);
        BMI = (TextView)findViewById(R.id.txt_BMIvalue);
        BMItype = (TextView)findViewById(R.id.txt_BMItype);

        calc.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                if(!("".equals(cm.getText().toString()) || "".equals(kg.getText().toString()))){
                    float fh = Float.parseFloat(cm.getEditableText().toString());      // 取得 身高輸入值
                    float fw = Float.parseFloat(kg.getEditableText().toString());     // 取得 體重輸入值
                    float fresult;                                     // BMI值 計算結果
                    fh = fh/100; // 計算BMI
                    fh = fh*fh;  // 計算BMI

                    java.text.DecimalFormat df = new java.text.DecimalFormat(".00"); //格式化數字， 限制小數第二位
                    fresult = fw/fh;                                // 計算BMI
                    BMI.setText(df.format(fw/fh) +"");           // 顯示BMI計算結果

                    // 診斷結果 顯示
                    BMItype.setTextColor(0xffffff);
                    if (fresult<18.5)
                        BMItype.setText("體重過輕");
                    else if (18.5 <= fresult && fresult< 24)
                        BMItype.setText("正常範圍");
                    else if(24 <=fresult){
                        BMItype.setTextColor(0xff0000);
                        if (24 <=fresult && fresult < 27)
                            BMItype.setText("過    重");
                        else if (27 <=fresult && fresult < 30)
                            BMItype.setText("輕度肥胖");
                        else if (30 <= fresult && fresult < 35)
                            BMItype.setText("中度肥胖");
                        else if (fresult >= 35)
                            BMItype.setText("重度肥胖");
                    }
                }
            }
        });
    }
}
