package com.example.dialog;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dialog.dialog.Dialogo;
import com.example.dialog.dialog.MultiplechoiseDialog;
import com.example.dialog.dialog.Personalizado;
import com.example.dialog.dialog.SelecttableDialog;
import com.example.dialog.dialog.SinglechoiceDialog;
import com.example.dialog.dialog.simple;

public class MainActivity extends AppCompatActivity implements Dialogo.OnDialogListener  {

    Button mostrar;
    Button lista1;
    Button lista2;
    Button lista3;
    Button DialogPers;
    Button DialogoSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrar = findViewById(R.id.mostrar);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(v);
            }
        });

        lista1 = findViewById(R.id.lista1);

        lista1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowListDialog(v);
            }
        });

        lista2 = findViewById(R.id.lista2);

        lista2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowListSelectDialog(v);
            }
        });

        lista3 = findViewById(R.id.lista3);

        lista3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowListUniqueSelectDialog(v);
            }
        });

        DialogPers = findViewById(R.id.DialogoPers);
        DialogPers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPersonalDialog(v);
            }
        });

        DialogoSimple = findViewById(R.id.DialogoSimple);
        DialogoSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogoSimple(v);
            }
        });

    }

    public void ShowDialogoSimple(View view) {
        DialogFragment dialogFragment = new simple();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }

    public void ShowPersonalDialog(View view) {
        DialogFragment dialogFragment = new Personalizado();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }



    public void ShowDialog(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment) fragmentManager.findFragmentByTag(Dialogo.TAG);

        if (fragment == null) {
            fragment = new Dialogo();

            Bundle bundle = new Bundle();
            bundle.putString(Dialogo.MESSAGE,"Esto es un mensaje");

            fragment.setArguments(bundle);
        }

       // DialogFragment dialogFragment = new Dialogo();
        fragment.show(getSupportFragmentManager(), Dialogo.TAG);
    }

    public void ShowListDialog(View view) {
        DialogFragment dialogFragment = new SelecttableDialog();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }

    public void ShowListSelectDialog(View view) {
        DialogFragment dialogFragment = new MultiplechoiseDialog();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }

    public void ShowListUniqueSelectDialog(View view) {
        DialogFragment dialogFragment = new SinglechoiceDialog();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }


    @Override
    public void OnPositiveButtonClicked() {
        Toast.makeText(this, "Botón positivo pulsado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnNegativeButtonClicked() {
        Toast.makeText(this, "Botón negativo pulsado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnNeutralButtonClicked() {
        Toast.makeText(this, "Botón neutral pulsado", Toast.LENGTH_SHORT).show();
    }
}
