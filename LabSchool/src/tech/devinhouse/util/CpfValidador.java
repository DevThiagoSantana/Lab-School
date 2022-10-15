package tech.devinhouse.util;

import tech.devinhouse.cli.Display;

public class CpfValidador {



    public static boolean eCpf(String cpf){
        if(cpf.length() == 11){



        char dig10;
        char dig11;
        int soma = 0;
        int peso =10;
        int resultado;
        int numero;

//        o 48 e pq esse e o valor de "0" na tabela ASCII
        for(int i=0; i< 9;i++){
            numero =(int)(cpf.charAt(i)-48);
            soma = soma +(numero* peso);
            peso--;
        }
        resultado= 11-(soma %11);
        if(resultado==11 || resultado ==10){
            dig10 = '0';
        } else{
            dig10 =(char)(resultado +48);
        }

        soma=0;
        peso=11;
        for(int i=0;i<10;i++){
            numero=(int)(cpf.charAt(i) -48);
            soma = soma +(numero* peso);
            peso--;

        }
        resultado= 11 - (soma % 11);
        if(resultado==11 || resultado ==10){
            dig11 = '0';
        } else{
            dig11 =(char)(resultado +48);
        }
        if (dig10 == cpf.charAt(9) && dig11 ==cpf.charAt(10)){
            return true;
        }else {
            return false ;
        }



     }return false;

    }
}
