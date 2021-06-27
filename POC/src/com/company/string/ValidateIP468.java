package com.company.string;

public class ValidateIP468 {

    public static void main(String[] args) {
        ValidateIP468  validateIP468 = new ValidateIP468();
       // validateIP468.validIPAddress("192.168.00.1");
        validateIP468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }

    public String validIPAddress(String ip) {


        if(ip ==null || ip.length() < 7) return "Neither";

        if(ip.indexOf(".") > -1 ) {
            if(ip.charAt(0) == '.' || ip.charAt(ip.length()-1) == '.') return "Neither";
            String str[] = ip.split("\\.");
            if(str.length != 4) return "Neither";
            for(int i=0;i<4;i++) {
                char strarr[] = str[i].toCharArray();
                if(str[i].length() == 0) return "Neither";
                if(str[i].length() >=2 &&  strarr[0] == '0') return "Neither";
                try{
                    int temp = Integer.parseInt(str[i]);
                    if(temp > 255) return "Neither";
                }catch(NumberFormatException e) {
                    return "Neither";
                }
            }
            return "IPv4";

        }else if(ip.indexOf(":") > -1){
            String str[] = ip.split(":");
            if(ip.charAt(0) == ':' || ip.charAt(ip.length()-1) == ':') return "Neither";
            if(str.length != 8) return "Neither";

            for(int i = 0;i< str.length;i++) {
                if(str[i].length() == 0 || str[i].length() > 4) return "Neither";
                if(!str[i].matches("[0-9a-fA-F]+")) return "Neither";
            }
            return "IPv6";
        }

        return "Neither";
    }
}
