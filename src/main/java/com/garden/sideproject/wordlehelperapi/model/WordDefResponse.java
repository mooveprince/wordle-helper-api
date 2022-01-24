package com.garden.sideproject.wordlehelperapi.model;

import java.util.ArrayList;

public class WordDefResponse {
    public String word;
    public ArrayList<Result> results;
    public Syllables syllables;
    public Pronunciation pronunciation;
    public double frequency;
}
