package JWTHelper;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class JsonWebTokenHelper {
    private static JsonWebTokenHelper jwTokenHelper = null;
    private static final long EXPIRATION_LIMIT = 180;
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private JsonWebTokenHelper() {}

    public static JsonWebTokenHelper getInstance() {
        if (jwTokenHelper == null)
            jwTokenHelper = new JsonWebTokenHelper();

        return jwTokenHelper;
    }

    public String generatePrivateKey(String login, String password) {
        return Jwts
                .builder()
                .setSubject(login)
                .setSubject(password)
                .setExpiration(getExpirationDate())
                .signWith(key)
                .compact();
    }

    public void claimKey(String privateKey) throws ExpiredJwtException, MalformedJwtException {
        Jwts
                .parser()
                .setSigningKey(key)
                .parseClaimsJws(privateKey);
    }

    private Date getExpirationDate() {
        long currentTimeInMillis = System.currentTimeMillis();
        long expMilliSeconds = TimeUnit.MINUTES.toMillis(EXPIRATION_LIMIT);

        return new Date(currentTimeInMillis + expMilliSeconds);
    }
}
