package mybeautyclock.server.util;

public class Utils {
    public static boolean isNull(Object o){
        if(o == null || o.toString().trim().length() == 0){
            return true;
        }
        return false;
    }

    public static int valueInteger(String s, int defaultvalue) {
        try{
            return Integer.parseInt(s);
        }
        catch(Exception e){
        }
        return defaultvalue;
    }
    
    public static String valueString(String s){
        if(s!=null){
            return s;
        }
        return "";
    }
}
