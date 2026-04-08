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
            char encrypted = (char)(m.charAt(i) ^ k.charAt(i % k.length()));
            result.append(encrypted);
        }

        return result.toString(); 
    }
}

public class enc
{
    public static void main(String[] args)
    {
        String msg = "Parva B my love";
        String key = "gg";

        Encrypt e = new Encrypt(msg);

        String encrypted = e.xor(msg, key);
        String decrypted = e.xor(encrypted, key);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}