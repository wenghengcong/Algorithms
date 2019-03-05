
public class ReplaceBlank {
    public static int replaceBlank(char[] string, int length) {
        if (string.length == 0 || length == 0) return 0;

        int count = 0;
        for(int i = 0; i < length; i++) {
            if(string[i] == ' ')
                count++;
        }
        int i = length - 1, j = length + 2 * count - 1;
        while(i < j) {
            if(string[i] != ' ') {
                string[j] = string[i];
                i--;
                j--;
            } else {
                string[j] = '0';
                string[j-1] = '2';
                string[j-2] = '%';
                j = j - 3;
                i--;
            }
        }
        return length + 2 * count;
    }
}
