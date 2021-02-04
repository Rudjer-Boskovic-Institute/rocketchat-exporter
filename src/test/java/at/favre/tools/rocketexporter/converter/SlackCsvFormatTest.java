package at.favre.tools.rocketexporter.converter;

import at.favre.tools.rocketexporter.model.Message;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;

import java.time.Instant;
import static junit.framework.TestCase.assertEquals;

public class SlackCsvFormatTest {

    private ExportFormat exportFormat = new SlackCsvFormat();

    @Test
    public void export() {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
	Instant instant0 = Instant.ofEpochMilli(0);
	Instant instant1 = Instant.ofEpochMilli(1);
        exportFormat.export(
                List.of(
                        new Message("m1", "u1", "c1", instant0),
                        new Message("m2", "u2", "c3", instant1)
                ),
                bout);

        String out = bout.toString();

        /*
   assertEquals("\"0\",\"c1\",\"u1\",\"m1\"\n" +
                "\"1\",\"c3\",\"u2\",\"m2\"\n", out);
  */
        assertEquals("\"u1-irb\",\"0\",\"m1\"\n" +
                "\"u2-irb\",\"1\",\"m2\"\n", out);
    }
}
