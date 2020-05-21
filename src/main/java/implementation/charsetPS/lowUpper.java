package implementation.charsetPS;

public class lowUpper {
    public static void main(String[] args) {
        String in = "CodeChallenge2014withMSP";
        StringBuffer st = new StringBuffer();
        for (int i = 0; i < in.length(); i++) {
            char s = in.charAt(i);
            if (s >= 97 && s <= 122) {
                st.append(String.valueOf(s).toUpperCase());
                // st.append((char) (s - 32)); Ascii Code 이용
            } else if (s >= 65 && s <= 90) {
                st.append(String.valueOf(s).toLowerCase());
                // st.append((char) (s + 32)); Ascii Code 이용
            } else {
                st.append(s);
            }
        }
        System.out.println(st);
    }
}
