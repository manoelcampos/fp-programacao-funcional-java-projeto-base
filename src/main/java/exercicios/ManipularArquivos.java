import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

void main() {
    try (var lines = Files.lines(Paths.get("cidades.txt"))) {
        lines
                .map(String::toUpperCase)
                .map(String::trim)
                .filter(linha -> !linha.isBlank())
                .sorted()
                .forEach(System.out::println);
    } catch (FileNotFoundException e) {
        System.err.println("Arquivo não existe");
    } catch (IOException e) {
        System.err.println("Erro na leitura do arquivo");
    }
}
