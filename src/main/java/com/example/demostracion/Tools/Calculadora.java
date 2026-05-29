package com.example.demostracion.Tools;

import java.util.Stack;

public class Calculadora {

    public static String convertirAPostfix(String infix) {

        Stack<Character> pila = new Stack<>();

        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {

            char caracter = infix.charAt(i);

            if (Character.isDigit(caracter)) {

                postfix.append(caracter);
            }

            else if (caracter == '(') {

                pila.push(caracter);
            }

            else if (caracter == ')') {

                while (!pila.isEmpty() && pila.peek() != '(') {

                    postfix.append(pila.pop());
                }

                pila.pop();
            }

            else if (esOperador(caracter)) {

                while (!pila.isEmpty()
                        && prioridad(pila.peek()) >= prioridad(caracter)) {

                    postfix.append(pila.pop());
                }

                pila.push(caracter);
            }
        }

        while (!pila.isEmpty()) {

            postfix.append(pila.pop());
        }

        return postfix.toString();
    }

    public static boolean esOperador(char c) {

        return c == '+'
                || c == '-'
                || c == '*'
                || c == '/';
    }

    public static int prioridad(char operador) {

        switch (operador) {

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
        }

        return -1;
    }

    public static String resolverExpresionPostfix(String postfix) {

        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {

            char caracter = postfix.charAt(i);

            if (Character.isDigit(caracter)) {

                pila.push(caracter - '0');
            }

            else if (esOperador(caracter)) {

                int b = pila.pop();
                int a = pila.pop();

                int resultado = 0;

                switch (caracter) {

                    case '+':
                        resultado = a + b;
                        break;

                    case '-':
                        resultado = a - b;
                        break;

                    case '*':
                        resultado = a * b;
                        break;

                    case '/':
                        resultado = a / b;
                        break;
                }

                pila.push(resultado);
            }
        }

        return String.valueOf(pila.pop());
    }
}