package app.auth;

import io.jooby.Context;
import io.jooby.Jooby;
import io.jooby.Session;

/**
 *
 * @author sohai
 */
public class AuthService extends Jooby {

    {
        get("/auth/user/{username}", (Context ctx) -> {

            var user = new User(ctx.path("username").value(), "nopass");

            return user;
        });

        post("/auth/authenticate", ctx -> {

            var user = ctx.body(User.class);
            Session session = ctx.session();
            session.put("username", "Hello " + user.getUsername());
            
            user.setUsername(session.get("username").toString());
            return user;
        });
    }
}
