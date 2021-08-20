package uz.pdp.jwtmoneytransfer.securtity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    static long expireTime = 300_000_000; //5 daqiqa
    static String secretKey = "TokenSecretString";

    public String tokenGenerator(String username) {
        Date expireDate = new Date(System.currentTimeMillis() + expireTime);
        String token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return token;

    }
    public Boolean validateToken(String token){
      try {
          Jwts
                  .parser()
                  .setSigningKey(secretKey)
                  .parseClaimsJws(token);
          return true;
      }catch (Exception e){
          e.printStackTrace();
      }
      return false;
    }
    public String getUsernameFromToken(String token){
        String username = Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return username;
    }
}
