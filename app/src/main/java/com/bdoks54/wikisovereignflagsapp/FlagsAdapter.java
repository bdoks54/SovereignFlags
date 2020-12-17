package com.bdoks54.wikisovereignflagsapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

//어댑터 상속
public class FlagsAdapter extends ArrayAdapter<SovereignFlag> {
    //국가 정보를 저장할 국가 목록을 선언, 생성한다
    ArrayList<SovereignFlag> flags = new ArrayList<SovereignFlag>();
    Activity activity;
    //어댑터는 액티비티와 레이아웃이 꼭 필요하다
    public FlagsAdapter(Activity activity, ArrayList<SovereignFlag> flags){
        super(activity,R.layout.list_flag_item,flags);  //어댑터의 레이아웃 설정
        this.flags = flags;
        this.activity = activity; //context를 통해서 inflate()얻음
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //아이템 화면에 +국가정보
            //화면을 재사용하기위한 객체
        FlagViewHolder flagViewHolder=null;
        //한 국가의 정보
        SovereignFlag flag = flags.get(position);
        //아이템 화면을 담당하는 뷰
        View itemView = convertView;
        if(itemView == null){
            //아직 화면을 담당하는 뷰 객체가 생성되지 않았다면 화면 재활용 객체를 준비
            flagViewHolder = new FlagViewHolder();    //화면재활용 객체
            itemView = activity.getLayoutInflater().inflate(R.layout.list_flag_item, parent, false);
            flagViewHolder.imageView = (ImageView)itemView.findViewById(R.id.flagimage);
            //이미지뷰 생성
            flagViewHolder.flagkorname = (TextView)itemView.findViewById(R.id.flagkorname); //홀더에 대입
            flagViewHolder.flagcode = (TextView)itemView.findViewById(R.id.flagcode);
            flagViewHolder.flagname = (TextView)itemView.findViewById(R.id.flagname);
            flagViewHolder.flagshortname = (TextView)itemView.findViewById(R.id.flagshortname);
            itemView.setTag(flagViewHolder);    //화면담당뷰 객체에 홀더 준비

        }else{
            flagViewHolder = (FlagViewHolder) itemView.getTag();    //화면담당뷰 객체에서 홀더 찾기
        }
        //재활용을 이용해 화면에 데이터를 입력한다.
        flagViewHolder.imageView.setImageResource(flag.getRid());
        flagViewHolder.flagkorname.setText(flag.getKorname());
        flagViewHolder.flagcode.setText(flag.getCode());
        flagViewHolder.flagname.setText(flag.getName());
        flagViewHolder.flagshortname.setText(flag.getShortname());

        return itemView;
    }
}

class FlagViewHolder{
    public ImageView imageView;
    public TextView flagkorname;
    public TextView flagcode;
    public TextView flagname;
    public TextView flagshortname;

}