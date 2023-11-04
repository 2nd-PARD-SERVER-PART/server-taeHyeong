package protect.pard.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenProvider {
    private static final Key SECURITY_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String create(String userEmail) {
        Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
                .setSubject(userEmail).setIssuedAt(new Date()).setExpiration(exprTime)
                .compact();
    }

    public String validate(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(SECURITY_KEY).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
