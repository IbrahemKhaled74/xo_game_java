package com.example.x_o_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    ConstraintLayout rootl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        rootl=findViewById(R.id.root);
        intializeBoard();
    }
    int counter=0;
    ArrayList<String> board;
    String sympol="";

    public void onClickBtn(View v) {
        Button b = ((Button) v);
        if (!b.getText().toString().isEmpty()) {
            return;
        }
            if (counter % 2 == 0) {
                b.setText("O");
                sympol = "O";
            }
            else {
                b.setText("X");
                sympol="X";

        }
            counter++;
            writeSympol(sympol,v.getId());
            if (checkWin("O")){
                //player one win (O)
                intializeBoard();
                counter=0;
                Toast.makeText(Game.this, "Player 1 (O) Win", Toast.LENGTH_LONG).show();

            }
        if (checkWin("X")){
            //player one win (X)
            intializeBoard();
            counter=0;
            Toast.makeText(Game.this, "Player 2 (X) Win", Toast.LENGTH_LONG).show();

        }
        else if(counter==9){
            //Draw
            intializeBoard();
            counter=0;
            Toast.makeText(Game.this, "It's Draw", Toast.LENGTH_LONG).show();

        }


    }

    //Array of Strings that we re play game with it
    void intializeBoard(){
        board=new ArrayList<>(9);
        for (int i = 0 ; i<9;i++){
            board.add("");
        }
        for (int i=0 ; i<rootl.getChildCount() ; i++){
            View view = rootl.getChildAt(i);
            if(view instanceof Button){
                   ((Button) view).setText("");

            }

        }


    }


    //read what the user click X or O on button and put it in array list
     void writeSympol(String Sympols, int id ){
            if (id==R.id.btn_1){
                board.set(0,Sympols);
            }else if(id==R.id.btn_2){
                board.set(1,Sympols);
            }else if(id==R.id.btn_3){
                board.set(2,Sympols);
            }else if(id==R.id.btn_4){
                board.set(3,Sympols);
            }else if(id==R.id.btn_5){
                board.set(4,Sympols);
            }else if(id==R.id.btn_6){
                board.set(5,Sympols);
            }else if(id==R.id.btn_7){
                board.set(6,Sympols);
            }else if(id==R.id.btn_8){
                board.set(7,Sympols);
            }else if(id==R.id.btn_9){
                board.set(8,Sympols);
            }


    }
    boolean checkWin(String Sympol) {
        for (int i = 0 ; i <3 ;i++){
            //rows
            if (board.get(i).equals(Sympol)&&
                    board.get(i+3).equals(Sympol)&&
                    board.get(i+6).equals(Sympol)
            ){
                return true;
            }
        }
        for (int i = 0 ; i <= 6 ; i+=3){
            //column
            if (board.get(i).equals(Sympol)&&
                    board.get(i+1).equals(Sympol)&&
                    board.get(i+2).equals(Sympol)
            ){
                return true;
            }
        }
        for (int i = 0 ; i < 3 ; i++){
            //diagnol
            if (board.get(0).equals(Sympol)&&
                    board.get(4).equals(Sympol)&&
                    board.get(8).equals(Sympol)
            ) {
                return true;
            }
            //diagnol
            if (board.get(2).equals(Sympol)&&
                    board.get(4).equals(Sympol)&&
                    board.get(6).equals(Sympol)
            ){
                return true;
            }

        }
        return false;

    }


}
