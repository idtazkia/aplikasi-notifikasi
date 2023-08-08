package id.ac.tazkia.notification.templates;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

@SpringBootTest
public class TemplateTagihanTests {

    @Autowired
    private MustacheFactory mustacheFactory;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGenerateEmailTagihan() throws Exception {
        String template = "templates/email/keuangan/tagihan.html";
        Mustache mustache = mustacheFactory.compile(template);
        StringWriter body = new StringWriter();
        Map<String, Object> data = new HashMap<>();
        data.put("debitur", "Endy Muhardin");
        data.put("keterangan", "Biaya Pembelian Formulir");
        data.put("nomor", "1234567890");
        data.put("nilai", "500.000");

        data.put("bank1", "BNI Syariah");
        data.put("nomorRekening1", "1234567890");
        data.put("namaRekening1", "Endy Muhardin - Formulir");

        data.put("nomorKontak1", "081234567890");
        data.put("namaKontak1", "humas@tazkia.ac.id");

        System.out.println("Data : "+objectMapper.writeValueAsString(data));

        mustache.execute(body, data);
        System.out.println(body);
    }
}
