class Encrypt
{
    StringBuilder encoded = new StringBuilder();
    int[] val;

    Encrypt(String s)
    {
        val = new int[s.length()];

        for(int i = 0; i < s.length(); i++)
        {
            val[i] = (int)s.charAt(i);
        }

        for(int i = 0; i < s.length(); i++)
        {
            encoded.append(Integer.toBinaryString(val[i]));
        }
    }

    String xor(String m, String k)
    {
        StringBuilder result = new StringBuilder(); 

        for(int i = 0; i < m.length(); i++)
        {
            char encrypted = (char)((m.charAt(i) ^ k.charAt(i % k.length())));
            result.append(encrypted);
        }

        return result.toString(); 
    }

    String vignere(String m, String k)
{
    char[][] vigtable = new char[26][26];
    for(int i = 0; i < 26; i++)
    {
        for(int j = 0; j < 26; j++)
        {
            char c = (char)('a' + (i + j) % 26);
            vigtable[i][j] = c;
        }
    }

    StringBuilder result = new StringBuilder();

    for(int i = 0; i < m.length(); i++)
    {
        char msgChar = Character.toLowerCase(m.charAt(i));
        char keyChar = Character.toLowerCase(k.charAt(i % k.length()));

        if(msgChar >= 'a' && msgChar <= 'z')
        {
            int row = msgChar - 'a';
            int col = keyChar - 'a';
            char encrypted = vigtable[row][col];
            result.append(encrypted);
        }
        else
        {
            result.append(m.charAt(i));
        }
    }

    return result.toString();
}

}
public class enc
{
    public static void main(String[] args)
    {
        String msg = "Aditya";
        String key = "110506";

        Encrypt e = new Encrypt(msg);

        String encrypted = e.xor(msg, key);
        String decrypted = e.xor(encrypted, key);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        
    }
}
