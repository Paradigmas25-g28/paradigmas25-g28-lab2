package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/* Esta clase modela los atributos y métodos comunes a todos los distintos tipos de parser existentes en la aplicación */
public abstract class GeneralParser {
    protected String content;

    // Constructor vacío (por ahora no necesitás estado interno)
    public GeneralParser() {
        this.content = "";
    }

    // Método abstracto que todas las subclases deberian implementar
    public abstract void parse(String path);

    // Método utilitario para leer un archivo como String
    protected String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
