package util;

import java.util.UUID;

public class CreateUUID {

    //产生一个32位的GUID
    public static String newGUID()
    {
        UUID uuid = UUID.randomUUID();

        return uuid.toString().replace("-", "");
    }

}
