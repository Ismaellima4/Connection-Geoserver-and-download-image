import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String baseUri = "http://localhost:8080/geoserver/wms";
        String layer = "ismael:PB_Municipios_2023";
        String bbox = "-37.60,-7.05,-37.50,-6.95";
        String width = "800";
        String height = "600";
        String format = "image/png";

        URI uri = new URI(String.format("%s?REQUEST=GetMap&LAYERS=%s&BBOX=%s&WIDTH=%s&HEIGHT=%s&FORMAT=%s", baseUri, layer, bbox , width, height, format));
        System.out.println(uri);
        DownloadImage.baixarImagem(uri.toString(), "image.png");
    }
}