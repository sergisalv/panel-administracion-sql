package academy.atl.customers.Utils;

import academy.atl.customers.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "gj43jng9";

    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

    public static String generateToken(User user){

        String token = JWT.create().withIssuer("SergioSM")
                .withClaim("userId",user.getId())
                .withIssuedAt(new Date())
                .withExpiresAt(getExpiresDate())
                .sign(algorithm);

        return token;
    }

    private static Date getExpiresDate(){
        return new Date(System.currentTimeMillis()
                + (1000L * 60 * 60 * 24 * 14)); //14 días
    }

    public static String getUserIdByToken(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("SergioSM")
                .build();

        DecodedJWT decoded = verifier.verify(token);
        String userID = decoded.getClaim("userId").toString();
        return userID;
    }
}
