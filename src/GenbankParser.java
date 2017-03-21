import org.renci.gbff.GBFFManager;
import org.renci.gbff.model.Feature;
import org.renci.gbff.model.Sequence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by neukamm on 20.03.17.
 */
public class GenbankParser {

    public void readGenelist(String filepath_genelist){

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(filepath_genelist);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

    public void readGenbankFile(String filepath_genbank){

        GBFFManager parser = GBFFManager.getInstance();
        List<Sequence> results = parser.deserialize(new File(filepath_genbank));
        for (Sequence seq : results){
            for(Feature f : seq.getFeatures()){
                if(f.getType().equals("gene"))
                    System.out.println(f.getQualifiers().get("gene"));
            }
        }

    }


}
