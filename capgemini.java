package com.homeoffice.capgemini;

import static java.lang.Math.round;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author andre
 */
public class capgemini {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int op = 0;

        System.out.println("**************** Capgemini 2022  ***************************");
        System.out.println("\n\n" + "1)Questão 01\n" + "2)Questão 02\n"
                + "3)Questão 03\n" + "4)Testes unitários\n" + "5)Sair\n\n\n");
        System.out.println(" Digite uma opção: ");
        op = scan.nextInt();

        switch (op) {
            case 1:
                questaoUm();
                break;
            case 2:
                questaoDois();
                break;
            case 3:
                questaoTres();
                break;
            case 4:
                //testesUnit();
                break;
            default:
                System.out.println("Fim");
                break;
        }

    }

    private static boolean verificarString(String entrada) {

        String ent = entrada;

        Pattern charEspecial = Pattern.compile("[.!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Pattern letras = Pattern.compile("[a-zA-z]");

        Matcher verificaChars = charEspecial.matcher(ent);
        Matcher verificaLetras = letras.matcher(ent);

        if (verificaLetras.find() || verificaChars.find()) {
            System.out.println("Digite apenas números e virgulas!");
            return true;
        } else {
            return false;
        }
    }

    private static boolean verificarQtde(String entrada) {
        String ent = entrada;
        String novaString[] = ent.split(",");

        if (novaString.length % 2 == 0) {
            System.out.println("Digite quantidade impar de números!");
            return true;
        } else {

            return false;
        }
    }

    private static void questaoUm() {
        String entrada;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Digite os números: ");
            entrada = scan.nextLine();
        } while ((verificarQtde(entrada)) & (verificarString(entrada)));

        try {
            String novaString[] = entrada.split(",");
            int[] arr = new int[novaString.length];
            int mediana = 0;

            for (int i = 0; i < novaString.length; i++) {
                novaString[i] = novaString[i].trim();
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(novaString[i]);
            }

            Arrays.sort(arr);

            mediana = round(arr.length / 2);
            //System.out.println(arr[mediana]);

            System.out.println("\nMediana é: " + arr[mediana]);

        } catch (NumberFormatException e) {
            //JOptionPane.showMessageDialog(null, "Digite um número!!2 " + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);

        }
    }

    private static void questaoDois() {
        int x = 0;
        String y;
        String entrada;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Digite o x: ");
            y = scan.nextLine();
            System.out.println("Digite os números: ");
            entrada = scan.nextLine();
        } while ((verificarQtde(entrada)) & (verificarString(entrada)));

        try {
            x = Integer.parseInt(y);
            String novaString[] = entrada.split(",");
            int[] n = new int[novaString.length];
            int contador = 0;

            for (int i = 0; i < novaString.length; i++) {
                novaString[i] = novaString[i].trim();
            }

            for (int i = 0; i < n.length; i++) {
                n[i] = Integer.parseInt(novaString[i]);
            }

            Arrays.sort(n);

            for (int i = (n.length) - 1; i > -1; i--) {
                for (int j = (n.length) - 1; j > -1; j--) {
                    if (i == j) {
                        continue;
                    }

                    if (n[j] - n[i] == x) {
                        contador++;
                    }
                }
            }
            System.out.println("\nQuantidade de pares: " + contador);

        } catch (NumberFormatException e) {

        }
    }

    private static void questaoTres() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o texto: ");
        String s = scan.nextLine();
        String novaString = s.replace(" ", "");
        int cal = (int) Math.ceil(Math.sqrt(novaString.length()));
        int contador = 0;
        StringBuilder sb = new StringBuilder();
        String[][] grid = new String[cal][cal];

        for (int col = 0; col < cal; col++) {
            for (int lin = 0; lin < cal; lin++) {
                if (contador >= novaString.length()) {
                    //grid[col][lin] = "";
                    break;

                } else {
                    grid[lin][col] = String.valueOf(novaString.charAt(contador));
                    contador++;
                }

            }
        }

        for (int col = 0; col < cal; col++) {
            for (int lin = 0; lin < cal; lin++) {

                if (grid[col][lin] == null) {
                    grid[col][lin] = "";
                }

                if (lin < (grid.length - 1)) {

                    sb.append(grid[col][lin]);

                } else {
                    sb.append(grid[col][lin]);
                    sb.append(" ");
                }

            }
        }

        //System.out.println("Final: " + sb.toString().trim());
        System.out.println("\n" + sb.toString().trim());

    }
}
