public class MyString {
    public static boolean containsOnlyDigitsV0(String str){
        if (str == null || str.isBlank()) {throw new IllegalArgumentException();}
        for (char ch : str.toCharArray()){
            try{
                Integer.valueOf(ch+"");
            } catch (Exception e){
                return false;
            }
        }
        return true;
    }
    public static boolean containsOnlyDigitsV1(String str){
        if (str == null || str.isBlank()) {throw new IllegalArgumentException();}

        for (int i = 0; i<str.length();i++){
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean containsOnlyDigitsV2(String str){
        if (str == null || str.isBlank()) {throw new IllegalArgumentException();}

        return str.matches("[0-9]+");
    }
    public boolean containsOnlyDigitsV3(String str){
        if (str == null || str.isBlank()) {throw new IllegalArgumentException();}

        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }


}
