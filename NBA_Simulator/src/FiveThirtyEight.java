import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FiveThirtyEight
{
    private String name;
    double carmelo;
    
    public FiveThirtyEight(String namex) throws Exception
    {
        name = namex;
        
        String url = "https://projects.fivethirtyeight.com/2018-nba-predictions/";
        Document doc = Jsoup.connect(url).get();
        
        ArrayList<String> teams = new ArrayList<>();
        ArrayList<String> carm = new ArrayList<>();
        
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("td");
        
        System.out.println(rows.size());
        
        for (int i = 3; i < rows.size(); i+=11) 
        { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            
            teams.add(cols.get(0).text());
            System.out.println(cols.get(0).text() + "..");
        }
        System.out.println("HERE");
        for (int i = 0; i < rows.size(); i+=11) 
        { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            
            carm.add(cols.get(0).text());
            System.out.println(cols.get(0).text() + "..");
        }
        System.out.println("HERE2");
        
        int indexNum = -1;
        
        for(int i = 0; i < teams.size(); i++)
        {
            String current = teams.get(i);
            System.out.println(current + ".");
            for(int k = 2; k < current.length(); k++)
            {
                char one = current.charAt(k);
                if(one == '1' || one == '2' || one == '3' || one == '4' || one == '5' || 
                    one == '6' || one == '7' || one == '8' || one == '9' || one == '0')
                {
                    indexNum = k;
                    break;
                }
            }
            teams.set(i,current.substring(0, indexNum));
        }
        System.out.println("HERE2");
            
              
        int index = teams.indexOf(name);
        carmelo = Double.parseDouble(carm.get(index));        
                
    }
    
    public double getCarm()
    {
        return carmelo;
    }
       

}