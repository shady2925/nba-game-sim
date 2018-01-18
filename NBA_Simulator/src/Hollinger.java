import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Hollinger
{
    private String name;
    double off, def;
    
    public Hollinger(String namex) throws Exception
    {
        name = namex;
        
        String url = "http://espn.go.com/nba/hollinger/teamstats";
        Document doc = Jsoup.connect(url).get();
        
        ArrayList<String> teams = new ArrayList<>();
        ArrayList<String> offensive = new ArrayList<>();
        ArrayList<String> defensive = new ArrayList<>();
        
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");
        
        for (int i = 2; i < rows.size(); i++) 
        { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            
            teams.add(cols.get(1).text());
            offensive.add(cols.get(10).text());
            defensive.add(cols.get(11).text());
        }
        
        int index = teams.indexOf(name);
        off = Double.parseDouble(offensive.get(index));
        def = Double.parseDouble(defensive.get(index));
        
    }
    
    public double getOff()
    {
        return off;
    }
    public double getDef()
    {
        return def;
    }
       

}