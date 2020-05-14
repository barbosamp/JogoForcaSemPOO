package br.com.bootcamp.jogo;

import java.util.Random;
import java.util.Scanner;

public class JogoForca {

    private static String[] dica;

    public static void main(String[] args){
        String palavraChave = null;
        int qtdLetras = 0;
        int acertou = 0;
        int pontuacao = 10;
        String novaDica = "";
        System.out.println("Qual nivel de dificuldade? D(Dificil); N(Normal); F(Facil) --> ");
        Scanner in = new Scanner(System.in);
        String dificuldade = in.next().toUpperCase();

        switch(dificuldade){
            case "D":
                palavraChave = listaPalavraDificil();
                break;
            case "N":
                palavraChave = listaPalavraNormal();
                break;
            case "F":
                palavraChave = listaPalavraFacil();
                break;
            default:
                palavraChave = "";
                System.out.print("Nenhuma letra válda!!");
                break;
        }

        String listaEmString = "";
        montaDica(palavraChave.length());
        for(String s : dica){
            listaEmString = listaEmString + s;
        }

        System.out.println(listaEmString);
        String[] listaLetrasCorretas = palavraChave.split("");

        while(pontuacao > 0) {
            if(palavraChave.equals(novaDica)){
                System.out.println("Você Ganhou... Parabéns!!");
                break;
            }
            System.out.println("Qual letra voce chuta? --> ");
            String letraDigitada = in.next().toLowerCase();
            int i = 0;
            qtdLetras = palavraChave.length();
            while (i < qtdLetras) {
                if (listaLetrasCorretas[i].equals(letraDigitada)) {
                    dica[i] = letraDigitada;
                    acertou = 1;
                }
                i++;
            }

            if(acertou == 1){
                acertou = 0;
            } else {
                pontuacao-=1;
            }

            for (String s : dica) {
                novaDica += s;
            }

            System.out.println("\n Você ainda tem: "+pontuacao+" chances!!\n");

            System.out.println(novaDica);

        }
    }

    public static String[] montaDica(int qdtLetras){
        dica = new String[qdtLetras];

        for(int i = 0; i < dica.length; i++){
            dica[i] = " __ ";
        }
        return dica;
    }

    public static String listaPalavraDificil(){
        String[] palavras  = {"carambola","jatoba","melancia"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

    public static String listaPalavraNormal(){
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
