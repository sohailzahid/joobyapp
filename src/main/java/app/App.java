package app;

import app.auth.AuthService;
import io.jooby.Environment;
import io.jooby.Jooby;
import io.jooby.json.GsonModule;
import java.nio.file.Paths;

public class App extends Jooby {

    {
        install(new GsonModule());
        assets("/*", Paths.get("public"));

        install(AuthService::new);
    }

    public static void main(final String[] args) {
        runApp(args, App::new);
    }

}
