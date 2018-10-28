package p04.Telephony;



public class Smartphones implements Call, Browse {

    @Override
    public String Browsing(String site) {
        boolean bool = false;
        char[] charssite = site.toCharArray();
        for (char c : charssite) {
            if (Character.isDigit(c)){
                bool = true;
                break;
            }
        }


        if (bool){
            return "Invalid URL!";
        }else {
            return String.format("Browsing: %s!", site);
        }
    }


    @Override
    public String Calling(String phone) {
        boolean bool = false;
        char[] phonechars = phone.toCharArray();

        for (char c : phonechars) {
            if (!Character.isDigit(c)){
                bool = true;
                break;
            }
        }

        if (bool){
            return  "Invalid number!";
        }else {
            return String.format("Calling... %s", phone);
        }

    }



}


