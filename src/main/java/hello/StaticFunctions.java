package hello;

public class StaticFunctions {

    //Change the first letter in a string to UpperCase
    public String  CapitalFirstLetter(String pstring){

        return pstring.substring(0,1).toUpperCase() + pstring.substring(1);
    }
}
