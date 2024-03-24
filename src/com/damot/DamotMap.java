package com.damot;

import java.io.*;
/**
 * Java Class to create maps
 */
class DamotMap{
    private int width;
    private int height;
    private boolean gameCond;
    public DamotMap(){
        width = 10;
        height = 10;
        gameCond = true;
    }
    public DamotMap(int w, int h){
        width = w;
        height = h;
        gameCond = true;
    }
    public void setGameCond(boolean g){
        gameCond = g;
    }
    public void setHeight(int h){
        height = h;
    }
    public void setWidth(int w){
        width =w;
    }
    public void Map() throws IOException,InterruptedException{
        String mapIc = "*";
        String line1 = new String(new char[width]).replace("\0", mapIc);
        String line2 = mapIc + new String(new char[width-2]).replace("\0"," ") + mapIc;
        while(gameCond){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            for(int i=0;i<height;i++){
                if(i==0 || i==height-1)
                    System.out.println(line1);
                else
                    System.out.println(line2);
            }
        }
    }
}
