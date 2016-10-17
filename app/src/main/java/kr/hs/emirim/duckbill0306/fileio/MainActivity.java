package kr.hs.emirim.duckbill0306.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

     Button butOut,butIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut=(Button)findViewById(R.id.but_output);
        butIn=(Button)findViewById(R.id.but_input);

        butOut.setOnClickListener(new View.OnClickListener() { // (상속 받는 클래스나. 인터 페이스) <- 익명 클래스로 만듦! (재사용이 없을 때!)
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out=openFileOutput("1017duckbill.txt", Context.MODE_WORLD_WRITEABLE);
                    String massage="미림정보과학고 학생들이 제일 예쁘다.";
                    out.write(massage.getBytes());
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });//핸들러 클래스 . 이벤트 연결!

        butIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in=openFileInput("1017duckbill.txt");
                    byte[] readMassage=new byte[200];
                    in.read(readMassage);
                    Toast.makeText(getApplicationContext(),new String(readMassage),Toast.LENGTH_LONG).show();
                    in.close();
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(),"파일이 존재하지 않는다!",Toast.LENGTH_SHORT).show(); //저장전에 읽어 오기 버튼을 눌렸을 때!
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
