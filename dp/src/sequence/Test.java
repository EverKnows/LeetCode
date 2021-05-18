package sequence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author jianmiao.xu
 * @date 2021/4/9
 */
public class Test {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://entrance.sumpay.cn/b033e5b4fba8409ea1eddf8bfd375cdf/download.htm");
        URLConnection urlConnection = url.openConnection();

        File file = new File("testPdf");

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        //fileOutputStream.write();
        //
        //inputStream.

    }
}