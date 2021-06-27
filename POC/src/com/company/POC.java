package com.company;

public class POC {

    private static POC poc;
    private POC() throws Exception{
        poc = new POC();
    }

    public static POC getInstance(){
        return poc;
    }


}
