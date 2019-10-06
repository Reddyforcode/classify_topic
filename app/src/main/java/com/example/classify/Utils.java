package com.example.classify;

//Utils
import android.util.Log;

import java.util.StringTokenizer;
public class Utils {

    String []posible_time = new String[]{"tiempo", "tiemp", "demasiado", "esperar", "esperando", "espere", "esperamos", "demoraron", "demorar", "bastante", "mucho", "estuve", "estuvimos", "minutos", "hora", "minuto", "ventanilla"};
    String []posible_tarjeta = new String[]{"tarjeta", "debito", "débito", "más", "comprar", "comprando", "internet", "trabo", "trago", "vencer", "vencido", "perdida", "perdi", "credito", "saldo", "creito", "ahorro", "demasiado"};
    String []posible_mala_atencion = new String[]{"mal", "mala", "servicio", "pesima", "atencion", "atención", "calidad", "trato", "cajero", "cajera", "personal", "actitud", "persona", "personal", "explicacion", "explicación"};
    /*
    create Utils object and call category method
     */
    public boolean is_posible_time(String string){
        for(int i = 0; i < posible_time.length; i++){
            if(string.equals(posible_time[i])){
                return true;
            }
        }
        return false;
    }

    public boolean is_posible_tarjeta(String string){
        //O(n) xD
        for(int i = 0; i < posible_tarjeta.length; i++){
            if(string.equals(posible_tarjeta[i])){
                return true;
            }
        }
        return false;
    }

    public boolean is_posible_mala_atencion(String string){
        for(int i = 0; i < posible_mala_atencion.length; i++){
            if(string.equals(posible_mala_atencion[i])){
                return true;
            }
        }
        return false;
    }

    public String category(String str_input){
        int pos_time = 0;
        int pos_tarjeta = 0;
        int pos_mala_atencion = 0;

        if(str_input.isEmpty()){
            return "The input is empty";
        }else{
        Log.d("Deb",  str_input);
        boolean salir = false;
        //init data structures
        //response_array.clear();
        //map.clear();
        //end init

        String res = "";
        StringTokenizer st = new StringTokenizer(str_input);
        while (st.hasMoreTokens()) {
            String newstr = st.nextToken().replaceAll("[^A-Za-z]+", "");
            //response_array.add(newstr);

            if(is_posible_time(newstr)){
                pos_time++;
                salir = true;
            }else if(is_posible_tarjeta((newstr))){
                pos_tarjeta++;
            }else if(is_posible_mala_atencion(newstr)){
                pos_mala_atencion++;
            }

        }
        String mess = pos_mala_atencion + " " + pos_tarjeta+ " "+pos_time;
        Log.d("debug", mess);

        if(pos_tarjeta >= 2 || pos_time>=2 || pos_mala_atencion>=2) {
            if (pos_tarjeta >= pos_time && pos_tarjeta>=pos_mala_atencion) return "tarjeta";
            else if(pos_time>=pos_tarjeta && pos_time>=pos_mala_atencion)   return "Tiempo";
            else if(pos_mala_atencion>= pos_tarjeta && pos_mala_atencion>=pos_time) return "mala atencion";
            else return "None";
        }else return "No categoria";

        }

    }
}
