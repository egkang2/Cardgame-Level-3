package com.example.a2pickremake;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    float shuffledrate;
    float sumrate;
    float winrate;
    float defeatrate;
    float winpercent;
    float secondnum;
    String winzeropercent;
    String strResult;
    float hunwinpercent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap originalBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.spade1);
        Bitmap originalBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.spade2);
        Bitmap originalBitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.spade3);
        Bitmap originalBitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.spade4);
        Bitmap originalBitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.spade5);
        Bitmap originalBitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.spade6);
        Bitmap originalBitmap7 = BitmapFactory.decodeResource(getResources(), R.drawable.spade7);
        Bitmap originalBitmap8 = BitmapFactory.decodeResource(getResources(), R.drawable.spade8);
        Bitmap originalBitmap9 = BitmapFactory.decodeResource(getResources(), R.drawable.spade9);
        Bitmap originalBitmap10 = BitmapFactory.decodeResource(getResources(), R.drawable.spade10);
        Bitmap originalBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.spade11);
        Bitmap originalBitmap12 = BitmapFactory.decodeResource(getResources(), R.drawable.spade12);
        Bitmap originalBitmap13 = BitmapFactory.decodeResource(getResources(), R.drawable.spade13);
        Bitmap[] bitmaps = {originalBitmap1, originalBitmap2, originalBitmap3, originalBitmap4, originalBitmap5, originalBitmap6, originalBitmap7, originalBitmap8, originalBitmap9, originalBitmap10, originalBitmap11, originalBitmap12, originalBitmap13};

        HashMap<Bitmap, Integer> bitmapValues = new HashMap<>();
        for (int i = 0; i < bitmaps.length; i++) {
            Random random=new Random();

            bitmapValues.put(bitmaps[i], i+1);//HashMap을 사용하여 Bitmap 객체와 해당하는 숫자 값을 매핑할 수 있습니다.
            Bitmap resizedclearly = Bitmap.createScaledBitmap(bitmaps[i], 400, 600, false);//공통적인 요소들을 넣을 것들은 배열로 정리하는 습관을 가지자
            bitmaps[i] = resizedclearly;//resizedclearly를 그냥 쓸 순 없고, 이렇게 할당을 해줘서 속성을 더해줘야한다. 헷갈렸던 요소 1

        }
        Log.d("MyApp", "아님 여기냐?: " +bitmapValues);




        //이미지뷰
        ImageView Player1firstpick = findViewById(R.id.playerrandompick1);
        ImageView Player1secondpick = findViewById(R.id.playerrandompick2);
        ImageView Computerfirstpick = findViewById(R.id.computerrandompick1);
        ImageView Computersecondpick = findViewById(R.id.computerrandompick2);
        //버튼
        Button drawbutton = findViewById(R.id.drawcardsrandomly);
        Button addbutton = findViewById(R.id.addthenumber);
        addbutton.setVisibility(View.INVISIBLE);

        //텍스트뷰
        TextView Computersum = findViewById(R.id.computersum);
        TextView Playersum=findViewById(R.id.playersum);
        Computersum.setVisibility(View.INVISIBLE);
        Playersum.setVisibility(View.INVISIBLE);


        //전역변수화



        //int
          shuffledrate=0;
          sumrate=0;
          winrate=0;
          defeatrate=0;
          winpercent=0;
          secondnum=0;
          hunwinpercent=0;




        //drawbutton 핸들러
        drawbutton.setOnClickListener(new View.OnClickListener() {
            private void shuffleArray(){
                Random random=new Random();

                Bitmap[] bitmaps2 = {originalBitmap1, originalBitmap2, originalBitmap3, originalBitmap4, originalBitmap5, originalBitmap6, originalBitmap7, originalBitmap8, originalBitmap9, originalBitmap10, originalBitmap11, originalBitmap12, originalBitmap13};
                for(int j=0;j<bitmaps2.length;j++){
                    int randomIndexToSwap = random.nextInt(bitmaps2.length);
                    Bitmap temp = bitmaps2[randomIndexToSwap];
                    bitmaps2[randomIndexToSwap] = bitmaps2[j];
                    bitmaps2[j] = temp;

                }
                System.out.println(Arrays.toString(bitmaps2));
                Player1firstpick.setImageBitmap(bitmaps2[0]);
                Log.d("MyApp", "뭐가 문제냐 대체?: " + bitmaps2[0]);


                Player1secondpick.setImageBitmap(bitmaps2[1]);

                Computerfirstpick.setImageBitmap(bitmaps2[2]);


                Computersecondpick.setImageBitmap(bitmaps2[3]);

            }


            public void onClick(View v) {
                shuffleArray();
                if(shuffledrate<10) {



                    drawbutton.setVisibility((View.INVISIBLE));
                    addbutton.setVisibility((View.VISIBLE));
                    shuffledrate=shuffledrate+1;
                    if(shuffledrate==10){

                        shuffledrate=0;
                    }

                }
                }//public void onClick(View v)
            });//drawbutton.setOnClickListener




        addbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(sumrate<=10){
                    Bitmap player1FirstPickBitmap = ((BitmapDrawable) Player1firstpick.getDrawable()).getBitmap();
                    Log.d("MyApp", "여기냐?: " + player1FirstPickBitmap);
                    Bitmap player1SecondPickBitmap = ((BitmapDrawable) Player1secondpick.getDrawable()).getBitmap();
                    Log.d("MyApp", "여기냐?: " + player1SecondPickBitmap);
                    Bitmap computerFirstPickBitmap = ((BitmapDrawable) Computerfirstpick.getDrawable()).getBitmap();
                    Bitmap computerSecondPickBitmap = ((BitmapDrawable) Computersecondpick.getDrawable()).getBitmap();
                    int player1Sum = 0;
                    int computerSum = 0;
                    if (bitmapValues.containsKey(player1FirstPickBitmap)) {
                        Integer value1 = bitmapValues.get(player1FirstPickBitmap);
                        if (value1 != null) {
                            player1Sum += value1.intValue();
                        }
                    }
                    Log.d("MyApp", "value1: " + bitmapValues.get(player1FirstPickBitmap));


                    if (bitmapValues.containsKey(player1SecondPickBitmap)) {
                        Integer value2 = bitmapValues.get(player1SecondPickBitmap);
                        if (value2 != null) {
                            player1Sum += value2.intValue();
                        }
                    }

                    if (bitmapValues.containsKey(computerFirstPickBitmap)) {
                        Integer value3 = bitmapValues.get(computerFirstPickBitmap);
                        if (value3 != null) {
                            computerSum += value3.intValue();
                        }
                    }

                    if (bitmapValues.containsKey(computerSecondPickBitmap)) {
                        Integer value4 = bitmapValues.get(computerSecondPickBitmap);
                        if (value4 != null) {
                            computerSum += value4.intValue();
                        }
                    }











                    Computersum.setVisibility(View.VISIBLE);
                    Playersum.setVisibility(View.VISIBLE);
                    Log.d("MyApp", "player1Sum: " + player1Sum);
                    Log.d("MyApp", "computerSum: " + computerSum);
                    addbutton.setVisibility(View.INVISIBLE);
                    drawbutton.setVisibility(View.VISIBLE);
                    if(player1Sum>computerSum){
                        winrate=winrate+1;
                        sumrate=sumrate+1;
                        Playersum.setText("승리했습니다."+player1Sum);
                        Computersum.setText("패배했습니다."+computerSum);



                    }else if(computerSum>player1Sum){
                        defeatrate=defeatrate+1;
                        sumrate=sumrate+1;
                        Playersum.setText("패배했습니다."+player1Sum);
                        Computersum.setText("승리했습니다."+computerSum);

                    }else{
                        Playersum.setText("비겼습니다."+player1Sum);
                        Computersum.setText("비겼습니다."+computerSum);

                    }

                    if(sumrate==10){
                        secondnum=winrate/sumrate;
                        winzeropercent = String.format("%.2f", secondnum);

                        winpercent = Float.parseFloat(winzeropercent);


                        hunwinpercent = winpercent * 100;
                        strResult = Float.toString(hunwinpercent);
                        Playersum.setText(("패배횟수는"+defeatrate+"회입니다.\n승률은"+strResult+"%입니다."));


                        sumrate=0;
                        winrate=0;
                        defeatrate=0;
                        winpercent=0;



                    }



                }
            }



            // public void onClick(View v)
        });// addbutton.setOnClickListener(new View.OnClickListener()
    }//protected void onCreate
}//public class MainActivity extends AppCompatActivity






