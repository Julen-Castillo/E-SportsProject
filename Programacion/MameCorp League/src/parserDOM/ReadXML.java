package parserDOM;

import java.io.IOException;
import java.util.Arrays;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *
 * @author Adrian
 */
public class ReadXML {
  
public static String datosEquipos(String url) {

        String respuesta = null;

        // REF: LibrerÃ­a para comunicaciones HTTP: http://square.github.io/okhttp/
        OkHttpClient client = new OkHttpClient.Builder()
                .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT))
                .addInterceptor(new EncodingInterceptor())
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("cache-control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                respuesta = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return respuesta;
    }

//    public static void main(String[] args) {
//        System.out.println("--- Euskalmet XML, tendencia para 6 dÃ­as ---\n");
//        System.out.println(tendenciaSeisDias());
//    }

    // REF: Corregir la codificaciÃ³n erronea del servidor OpenData: https://stackoverflow.com/a/45285135
    private static class EncodingInterceptor implements Interceptor {

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            MediaType mediaType = MediaType.parse("application/json; charset=iso-8859-1");
            ResponseBody modifiedBody = ResponseBody.create(mediaType, response.body().bytes());

            return response.newBuilder()
                    .body(modifiedBody)
                    .build();
        }
    }
}