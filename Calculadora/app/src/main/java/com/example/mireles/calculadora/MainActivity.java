package com.example.mireles.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText pantalla;
    public double ope1, ope2, res, ultimo;
    int ope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pantalla almacenará todo lo de la pantalla
        pantalla=(EditText)findViewById(R.id.muestra);

    }

    //C A P T U R A  D E  N U M E R O S
    public void uno (View v){
        String captura = pantalla.getText().toString(); //guarda el forma de texto
        captura = captura+"1";
        pantalla.setText(captura);  //toma el texto capturado
    }

    public void dos (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"2";
        pantalla.setText(captura);
    }

    public void tres (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"3";
        pantalla.setText(captura);
    }

    public void cuatro (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"4";
        pantalla.setText(captura);
    }

    public void cinco (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"5";
        pantalla.setText(captura);
    }

    public void seis (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"6";
        pantalla.setText(captura);
    }

    public void siete (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"7";
        pantalla.setText(captura);
    }

    public void ocho (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"8";
        pantalla.setText(captura);
    }

    public void nueve (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"9";
        pantalla.setText(captura);
    }

    public void cero (View v){
        String captura = pantalla.getText().toString();
        captura = captura+"0";
        pantalla.setText(captura);
    }

    public void punto (View v){
        String captura = pantalla.getText().toString();
        captura = captura+".";
        pantalla.setText(captura);
    }

    // C A P T U R A  D E  O P E R A C I O N E S
    public void suma (View v){
        try{
            String aux1 = pantalla.getText().toString();    //aux guarda el texto de la pantalla
            ope1 = Double.parseDouble(aux1);
        }catch (NumberFormatException nfn){}
            pantalla.setText(""); //limpia pantalla
            ope= 1; //operacion 1->suma (asignacion)
    }

    public void resta (View v){
        try{
            String aux1 = pantalla.getText().toString();
            ope1 = Double.parseDouble(aux1);
        }catch (NumberFormatException nfn){}
        pantalla.setText("");
        ope= 2;
    }

    public void multiplicacion (View v){
        try{
            String aux1 = pantalla.getText().toString();
            ope1 = Double.parseDouble(aux1);
        }catch (NumberFormatException nfn){}
        pantalla.setText("");
        ope= 3;
    }

    public void division (View v){
        try{
            String aux1 = pantalla.getText().toString();
            ope1 = Double.parseDouble(aux1);
        }catch (NumberFormatException nfn){}
        pantalla.setText("");
        ope= 4;
    }

    public void potencia (View v){
        try{
            String aux1 = pantalla.getText().toString();
            ope1 = Double.parseDouble(aux1);
        }catch (NumberFormatException nfn){}
        pantalla.setText("");
        ope= 5;
    }

    public void raiz (View v){
        try{
            String aux1 = pantalla.getText().toString();
            ope1 = Double.parseDouble(aux1);
        }catch (NumberFormatException nfn){}
        pantalla.setText("√("+ope1+")");
        ope= 6;
    }

    public void porcentaje (View v){
        try{
            String aux1 = pantalla.getText().toString();
            ope1 = Double.parseDouble(aux1);
        }catch (NumberFormatException nfn){}
        pantalla.setText("");
        ope= 7;
    }

    public void factorial (View v){
        try{
            String aux1 = pantalla.getText().toString();
            ope1 = Double.parseDouble(aux1);
        }catch (NumberFormatException nfn){}
        pantalla.setText("");
        ope= 8;
    }

//  R E A L I Z A R   O P E R A C I O N E S
    public void igual (View v){
        try{
            String aux2 = pantalla.getText().toString();
            ope2 = Double.parseDouble(aux2);
        }catch (NumberFormatException nfn){}
            pantalla.setText("");

        //analiza operaciones
        if(ope==1){
            res=ope1+ope2;

        }else if (ope==2){
            res=ope1-ope2;

        }else if(ope==3){
            res=ope1*ope2;

        }else if(ope==4){
            if(ope2==0){
               pantalla.setText("Error");
            }else {
                res=ope1/ope2;
            }
        }else if(ope==5){
            res=Math.pow(ope1,ope2);

        }else if(ope==6){
            res=Math.sqrt(ope1);

        }else if(ope==7){
            res=ope2*(ope1/100.0);

        }else if(ope==8){
            res=1;
            for (double i=ope1; i>=1; i--){
                res=res*i;
            }
        }
        pantalla.setText(""+res);
        ope1=res;
        //tal vez ayuda a recuperar el ultimo resultado
        ultimo = res;

    }

// M A S   F U N C I O N E S
    public void limpiar (View v){
        pantalla.setText("");
        ope1=0.0;
        ope2=0.0;
        res=0.0;
    }

    public void borrar (View v){
        if(!pantalla.getText().toString().equals("")){
            pantalla.setText(pantalla.getText().subSequence(0,pantalla.getText().length()-1)+"");
        }
    }
    public void recuperar (View v){
        if(!pantalla.getText().toString().equals("")) {
            pantalla.setText("M" + ultimo);
        }
    }

}
