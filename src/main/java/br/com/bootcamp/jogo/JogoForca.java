package br.com.bootcamp.jogo;

import java.util.Random;
import java.util.Scanner;

public class JogoForca {

    public static void main(String[] args){
        String palavraChave = null;
        System.out.println("Qual nivel de dificuldade? D(Dificil); N(Normal); F(Facil) --> ");
        Scanner in = new Scanner(System.in);
        String dificuldade = in.next().toUpperCase();

        switch(dificuldade){
            case "D":
                palavraChave = listaPalavraDificil();
                break;
            case "N":
                palavraChave = listaPalavraNoraml();
                break;
            case "F":
                palavraChave = listaPalavraFacil();
                break;
            default:
                palavraChave = "";
                System.out.print("Nenhuma letra válda!!");
                break;
        }

        System.out.println(palavraChave);

    }

    public static String listaPalavraDificil(){
        String[] palavras  = {"carambola","jatoba","melancia"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

    public static String listaPalavraNoraml(){
        String[] palavras  = {"laranja","melao","maca"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

    public static String listaPalavraFacil(){
        String[] palavras  = {"banana","uva","abacate"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }
}
