package com.ge.customerbillingportal.util;

import org.hashids.Hashids;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.ge.customerbillingportal.common.consts.Const;

public class EncoderUtil {

    public static final StandardPasswordEncoder pwdEncoder = new StandardPasswordEncoder(Const.cryptSecret);

    public static final Hashids HASHID = new Hashids("TadalinHashId", 6,"0123456789abcdefghijklmnopqrstuvwxyz");

    public static String hashidEncode(Long id) {
        return HASHID.encode(id);
    }

    public static long[] hashidDecode(String str) {
        return HASHID.decode(str);
    }
}
