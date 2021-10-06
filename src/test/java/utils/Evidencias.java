package utils;

import com.opencsv.CSVWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Evidencias {

    public void print(WebDriver driver, String dataHora, String casoDeTeste, String mensagem) throws IOException {
        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File("target/prints/" + dataHora + "/" + casoDeTeste + "/" + mensagem + ".png"));
    }

    String data;

    public void iniciarCsv(String data) throws IOException {
        this.data = data;
        File arquivo = new File("target/logs/log-" + this.data + ".csv");

        if (!arquivo.isFile()) {
            String[] cabecalho = {"dataHoraSegundos", "casoDeTeste", "mensagem"};

            Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log-" + this.data + ".csv"));
            CSVWriter escritorCSV = new CSVWriter(escritor);

            escritorCSV.writeNext(cabecalho);

            escritorCSV.flush();
            escritor.close();
        }
    }

    // gravar cada linha no log
    public void registrarCsv(String casoDeTeste, String mensagem) throws IOException {
        String dataHoraSegundos = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime());

        List<String[]> linhas = new ArrayList<>();
        linhas.add(new String[]{dataHoraSegundos, casoDeTeste, mensagem});

        // Comentário: como fazer um arquivo apenas no final,
        // e fora do comentário como fazer um append em um arquivo que já existe.
        //Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log" + this.dataHora+ ".csv"));
        //CSVWriter escritorCSV = new CSVWriter(escritor);

        CSVWriter escritorCSV = new CSVWriter(new FileWriter("target/logs/log-" + this.data + ".csv", true));

        escritorCSV.writeAll(linhas);

        escritorCSV.flush();
        escritorCSV.close();
    }

}
