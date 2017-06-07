package com.baidu.util;

import com.baidu.constants.ApiKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by wudongfeng on 17/6/7.
 * 功能描述，主要用来生成token以及解密token
 */
public class TokenUtils {
    /**
     * 功能描述：主要用来进行token加密
     * @param id
     * @param issuer
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id,String issuer,String subject,long ttlMillis){
        //选择数字签名算法
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        //获取当前的毫秒数
        long nowMillis=System.currentTimeMillis();
        //通过当前的毫秒数生成日期
        Date now =new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(ApiKey.getSecret());
        Key signinKey=new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());

        JwtBuilder builder= Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm,signinKey);
        if(ttlMillis>=0){
            long expMillis=nowMillis+ttlMillis;
            Date exp=new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();

    }

    /**
     * 功能描述：主要用来进行解密操作
     * @param jwt 加密之后的token
     */
    public static void parseJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(ApiKey.getSecret()))
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("Expiration: " + claims.getExpiration());
    }


}
