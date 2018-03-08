package string;

public class FirstUniqueCharacterInAString387 {

    // TODO: 2018/3/8  
    
    public int firstUniqChar(String s) {
        int index = -1;
        int len = s.length();
        if (len == 1){
            return 0;
        }
        for (int i = 0; i < len; i++){
            if (i != len-1){
                if ((s.indexOf(s.charAt(i))) == -1){
                    index = i;
                    break;
                }
            }

        }
        return index;
    }
    public static void main(String[] args) {
        int n = new FirstUniqueCharacterInAString387().firstUniqChar("aadacdaad");
        System.out.println("n = " + n);
    }
}
