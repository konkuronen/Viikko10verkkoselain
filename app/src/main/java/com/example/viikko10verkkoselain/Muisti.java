package com.example.viikko10verkkoselain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Muisti {

    private ArrayList<String> lista = new ArrayList<>();
    ListIterator liter = lista.listIterator();
    private int i = 0;

    private static Muisti muisti = null;
    public static Muisti getInstance() {
        if (muisti == null) {
            muisti = new Muisti();
        } return muisti;
    }

    public void addEdellinen(String URL) {
        if (lista.size() == 10) {
            lista.remove(0);
            lista.add(URL);
        } else {
            if (lista.isEmpty()) {
                lista.add(URL);
                System.out.println(lista.size());
            } else {
                lista.add(URL);
                System.out.println(lista.size());
                i++;
            }
        }

    }

    public void addSeuraava(String URL) {

    }

    public String getEdellinen() {
        if (i == 0) {
            return lista.get(i);
        } else {
            return lista.get(--i);
        }
    }

    public String getSeuraava() {
        if (i + 1 == lista.size()){
            return lista.get(i);
        } else {
            return lista.get(++i);
        }
    }

    public void tulostaMuisti() {

    }
}
