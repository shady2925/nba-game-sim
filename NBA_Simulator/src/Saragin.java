import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Saragin
{
    private String name;
    double sara;
    
    public Saragin(String namex) throws Exception
    {        
        name = namex;
        
        String url = "http://www.usatoday.com/sports/nba/sagarin/";
        Document doc = Jsoup.connect(url).get();
        
        ArrayList<String> tags = new ArrayList<String>();
        Elements taglinks = doc.select("div.sagarin-page");
        for (Element link : taglinks) 
        {
            tags.add(link.text());
        }
        
        String str = tags.get(0);
        
        int index = str.indexOf(name);
        
        int index2 = index + name.length();
        String strTeam = str.substring(index, index2);
        str = str.substring(index2 + 4);
        int indexBlank = str.indexOf(" ");
 
        String saragin = str.substring(0, indexBlank - 1);
        sara = Double.parseDouble(saragin);
    }
    
    public double getSara()
    {
        return sara;
    }      

}