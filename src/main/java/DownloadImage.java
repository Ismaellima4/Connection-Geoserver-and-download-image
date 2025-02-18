import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadImage {

    public static void baixarImagem(String urlImagem, String nomeArquivo) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlImagem))
                .build();

        HttpResponse<BufferedImage> response = client.send(request, new ImageBodyHandler());

        BufferedImage imagem = response.body();

        Path caminhoArquivo = Paths.get(nomeArquivo);
        ImageIO.write(imagem, "png", caminhoArquivo.toFile());

        System.out.println("Imagem baixada e salva como " + nomeArquivo);
    }

    static class ImageBodyHandler implements java.net.http.HttpResponse.BodyHandler<BufferedImage> {
        @Override
        public java.net.http.HttpResponse.BodySubscriber<BufferedImage> apply(java.net.http.HttpResponse.ResponseInfo responseInfo) {
            return java.net.http.HttpResponse.BodySubscribers.mapping(
                    java.net.http.HttpResponse.BodySubscribers.ofByteArray(),
                    bytes -> {
                        try {
                            return ImageIO.read(new java.io.ByteArrayInputStream(bytes));
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        }
    }
}