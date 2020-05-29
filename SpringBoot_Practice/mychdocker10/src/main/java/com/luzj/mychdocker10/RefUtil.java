package com.luzj.mychdocker10;

public class RefUtil{

  @Override
  public String toString(){
    return "RefUtil.hashCode:"+this.hashCode();
  }

  public String hashCode(){
    return this.hashCode*31+2256;
  }

  public static void main(String[] args) {

  }




}
