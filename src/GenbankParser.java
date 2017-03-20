import org.renci.gbff.GBFFManager;
import org.renci.gbff.model.Feature;
import org.renci.gbff.model.Sequence;

import java.io.File;
import java.util.List;

/**
 * Created by neukamm on 20.03.17.
 */
public class GenbankParser {

    public void read(String filepath){

        GBFFManager parser = GBFFManager.getInstance();
        List<Sequence> results = parser.deserialize(new File(filepath));
        for (Sequence seq : results){
            for(Feature f : seq.getFeatures()){
                if(f.getType().equals("gene"))
                    System.out.println(f.getQualifiers().get("gene"));
            }
        }

    }


}
