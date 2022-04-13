package com.example.highnlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Variable untuk input text dan button
    public EditText numInput;

    private int randomNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberGenerator(); //Mengenerate sebuah random number
    }

    //Fungsi untuk mengenerate random number
    public void NumberGenerator() {
        Random rand = new Random();
        randomNum = rand.nextInt(20) + 1;
    }

    //Fungsi untuk mengeluarkan hasil/outputnya
    public void onGuess(View view)
    {
        //Mecari ID
        numInput = findViewById(R.id.inputNumber);

        //Try untuk mencoba inputan
        try {
            //Mengambil inputan dan mengubahnya menjadi angka
            //Variable untuk proses
            int theNum = Integer.parseInt(numInput.getText().toString());

            String msg;

            //Fungsi jika..
            if (theNum < randomNum) {
                msg = "Higher";
            } else if (theNum > randomNum) {
                msg = "Lower";
            } else {
                msg = "Correct";
                NumberGenerator(); //Mengenerate angka lagi agar permainan bisa dilanjutkan
            }

            //Menampilkan popup yang menjelaskan angka jika kurang atau kelebihan
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

            //Jika inputan yang diterima berupa string yang tidak bisa di ubah ke int maka...
        } catch (Exception e) {

            //Akan mengeluarkan ouput ini sebagai pengganti erronya
            Toast.makeText(this, "Must be a number", Toast.LENGTH_SHORT).show();
        }
    }
}