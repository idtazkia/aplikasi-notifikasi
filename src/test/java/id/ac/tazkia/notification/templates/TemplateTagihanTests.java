package id.ac.tazkia.notification.templates;

import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateTagihanTests {

    @Autowired
    private MustacheFactory mustacheFactory;

    @Test
    public void testGenerateEmailTagihan(){
        String template = "templates/email/keuangan/tagihan.html";
        Mustache mustache = mustacheFactory.compile(template);
        StringWriter body = new StringWriter();
        Map<String, Object> data = new HashMap<>();
        data.put("debitur", "Endy Muhardin");
        data.put("keterangan", "Biaya Pembelian Formulir");
        data.put("nomor", "1234567890");
        data.put("nilai", "500.000");

        List<Map<String, String>> daftarRekening = new ArrayList<>();
        Map<String, String> bni = new HashMap<>();
        bni.put("bank", "BNI Syariah");
        bni.put("nomorRekening", "1234567890");
        bni.put("namaRekening", "Formulir - Endy Muhardin");
        daftarRekening.add(bni);
        data.put("daftarRekening", daftarRekening);

        List<Map<String, String>> daftarKontak = new ArrayList<>();
        Map<String, String> humas = new HashMap<>();
        humas.put("nomorKontak", "081234567890");
        humas.put("namaKontak", "humas@tazkia.ac.id");
        daftarKontak.add(humas);
        data.put("daftarKontak", daftarKontak);

        mustache.execute(body, data);
        System.out.println(body);
    }
}
