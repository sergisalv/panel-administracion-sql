package academy.atl.customers.Utils;

import academy.atl.customers.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "gj43jng9";

    public static String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
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

    //public User getUserByToken(JwtToken token){

   // }
}
