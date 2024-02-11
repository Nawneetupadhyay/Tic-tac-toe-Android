 package com.nawneet.ntictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activep=0;
    int board[]={2,2,2,2,2,2,2,2,2};
    int win_pos[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int gameact=0;

    public void tap(View view)
    {ImageView img=(ImageView)view;
    int tapedimg=Integer.parseInt(img.getTag().toString());
    if(gameact==1)
    {
    gameact=0;
    activep=0;
    for(int k=0;k<board.length;k++)
        board[k]=2;
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);

        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);

        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);



    }
    if(board[tapedimg]==2&&gameact==0)
    {
        board[tapedimg]=activep;
        img.setTranslationY(-1000f);
        if(activep==0)
        {
            img.setImageResource(R.drawable.o);
            activep=1;
        }
        else{
            img.setImageResource(R.drawable.x);
            activep=0;
        }
        img.animate().translationYBy(1000f).setDuration(100);
    }
    int l=0,i;
    for(i=0;i<win_pos.length;i++)
    {
        if(board[win_pos[i][0]]==board[win_pos[i][1]]&&board[win_pos[i][1]]==board[win_pos[i][2]]&&
                board[win_pos[i][0]]!=2)
        {
            l=1;
            break;
        }


    }
    if(l==1&&board[win_pos[i][0]]==0){
        Toast.makeText(MainActivity.this, "0 is winner ", Toast.LENGTH_LONG).show();
    gameact=1;
        Toast.makeText(MainActivity.this, "tap on board to play again", Toast.LENGTH_LONG).show();}



        if(l==1&&board[win_pos[i][0]]==1){
        Toast.makeText(MainActivity.this, "x is winner ", Toast.LENGTH_LONG).show();
    gameact=1;
            Toast.makeText(MainActivity.this, "tap on board to play again", Toast.LENGTH_LONG).show();
        }








    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
