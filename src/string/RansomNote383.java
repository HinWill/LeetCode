package string;



public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        int count = 0;
        char[] s = magazine.toCharArray();
        for (char c : ransomNote.toCharArray()){
            for (int i = 0; i < s.length; i++) {
                if (c == s[i]){
                    s[i] = '0';
                    count++;
                    break;
                }
            }
        }
        if (count == ransomNote.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        boolean n = new RansomNote383().canConstruct("fffbfg",
                "effjfggbffjdgbjjhhdegh");

        System.out.println("n = " + n);
    }
}
