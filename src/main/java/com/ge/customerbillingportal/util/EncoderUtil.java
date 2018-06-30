package com.ge.customerbillingportal.util;

import org.hashids.Hashids;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.ge.customerbillingportal.common.consts.Const;

/**
 * @author Nitin K.
 * Utility class containing methods for password encoding and decoding
 */
public class EncoderUtil {

    public static final StandardPasswordEncoder pwdEncoder = new StandardPasswordEncoder(Const.cryptSecret);

    public static final Hashids HASHID = new Hashids("TadalinHashId", 6,"0123456789abcdefghijklmnopqrstuvwxyz");

    /**
     * Method to encode password for given hash id
     * @param id Long
     * @return String
     */
    public static String hashidEncode(Long id) {
        return HASHID.encode(id);
    }

    /**
     * Method to decode encoded password
     * @param str String
     * @return long[]
     */
    public static long[] hashidDecode(String str) {
        return HASHID.decode(str);
    }
}
