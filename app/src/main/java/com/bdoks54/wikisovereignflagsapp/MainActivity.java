package com.bdoks54.wikisovereignflagsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //국가 목록
    ArrayList<SovereignFlag> manyflags = new ArrayList<SovereignFlag>();
    //국가 목록을 뿌려줄 리스트뷰
    ListView list;
    //리스트뷰를 누르면 해당 아이템의 정보를 리스트뷰 상단에 표시한다.
    ImageView bigflag;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("국가 국기");
        //화면 내 UI객체 생성
        list = (ListView) findViewById(R.id.listView);
        bigflag = (ImageView) findViewById(R.id.bigflag);
        textView = (TextView)findViewById(R.id.textView);
        //국가 목록 만들기
        manyflags=readFlags();
        //어댑터 만들기
        ArrayAdapter<SovereignFlag> adapter = new FlagsAdapter(this,manyflags);
        //리스트뷰에 어댑터 설정
        list.setAdapter(adapter);
        //리스트뷰에서 한 아이템을 선택하면 실행
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //선택된 국가
                SovereignFlag selectedflag = manyflags.get(position);
                String message = "You clicked position " + position+ " Sovereign is " + selectedflag.getName();
                //선택된 나라의 국기를 큰 화면에 표시
                bigflag.setImageResource(selectedflag.getRid());
                //선택된 나라의 정보 표시
                textView.setText(selectedflag.getKorname()+" "+selectedflag.getShortname());

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
    //각나라의 국기 등 국가정보를 국가목록에 넣는다
    public ArrayList<SovereignFlag> readFlags() {
        ArrayList<SovereignFlag> flags = new ArrayList<SovereignFlag>();
        //국가목록 - 국가정보들을 저장
        flags.clear();
        flags.add(new SovereignFlag("Ghana","GH","288","가나",R.drawable.gh));
        flags.add(new SovereignFlag("Gabon","GA","266","가봉",R.drawable.ga));

        return flags;
    }
}