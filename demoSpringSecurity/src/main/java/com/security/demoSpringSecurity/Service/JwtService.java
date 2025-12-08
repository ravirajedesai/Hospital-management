package com.security.demoSpringSecurity.Service;

import com.security.demoSpringSecurity.Entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private String secretkey=null;

    public String generateToken(User user) {
        Map<String,Object>claims=new HashMap<>();
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(user.getName())
                .issuer("Demo")
                .issuedAt(new Date(System.currentTimeMillis()))
                .issuedAt(new Date(System.currentTimeMillis()+60*10*1000))
                .and()
                .signWith(generatekey())
                .compact();

    }
    private SecretKey generatekey(){
        byte[] decode=Decoders.BASE64.decode(getSecretkey());
        return Keys.hmacShaKeyFor(decode);
    }
    public String getSecretkey(){
        return secretkey="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
    }
}
