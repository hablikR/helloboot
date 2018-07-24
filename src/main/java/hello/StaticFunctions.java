package hello;

public class StaticFunctions {

    //Change the first letter in a string to UpperCase
    public String  CapitalFirstLetter(String Pstring){

        return Pstring.substring(0,1).toUpperCase() + Pstring.substring(1);
    }
}
