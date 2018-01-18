import java.util.Random;
import java.text.DecimalFormat;

public class MultGameSim
{
    private Random rand;
    private double roadOE, roadDE, roadSara, roadCarm, homeOE, homeDE, homeSara, homeCarm, rat1, rat2, per1, per2;
    private double dif, pointSpread, perHome;
    private int games, wins1, wins2, oddsRoad, oddsHome;
    private String home, road, rHoll, rSara, r538, hHoll, hSara, h538;
    private String result, rank1, rank2, spread, percentage;

    public MultGameSim(String roadTeam, String homeTeam) throws Exception
    {        
        road = roadTeam;
        home = homeTeam;
        determineTeamString();
             
        Hollinger hol1 = new Hollinger(rHoll); 
        roadOE = hol1.getOff();
        roadDE = hol1.getDef();
        System.out.println("Holl");
        Saragin sara1 = new Saragin(rSara);
        roadSara = sara1.getSara();
        System.out.println("Sara");
        FiveThirtyEight carm1 = new FiveThirtyEight(r538);
        roadCarm = carm1.getCarm();    
        System.out.println("538");
        System.out.println(road + ": " + roadOE + ", " + roadDE + ", " + roadSara + ", " + roadCarm);
        
        Hollinger hol2 = new Hollinger(hHoll); 
        homeOE = hol2.getOff();
        homeDE = hol2.getDef();
        Saragin sara2 = new Saragin(hSara);
        homeSara = sara2.getSara();
        FiveThirtyEight carm2 = new FiveThirtyEight(h538);
        homeCarm = carm2.getCarm();
        System.out.println(home + ": " + homeOE + ", " + homeDE + ", " + homeSara + ", " + homeCarm);
        
        games = 1;
        rand = new Random();
        DecimalFormat f = new DecimalFormat("##.00");
        DecimalFormat f1 = new DecimalFormat("##.0");
        
        rat1 = ((roadOE - roadDE) / 1.5) + (roadSara / 1.5 - 25.0) + (roadCarm / 40.0);
        rat2 = ((homeOE - homeDE) / 1.5) + (homeSara / 1.5 - 25.0) + (homeCarm / 40.0);
        rank1 = road + ": " + f.format(rat1);
        rank2 = home + ": " + f.format(rat2); 
        
        dif = rat2 - rat1;
        pointSpread = (dif * .3847) + 2.3726;
        if(pointSpread >= 0)
        {
            spread = hHoll + " (-" + f1.format(pointSpread) + ")";
        }
        else if(pointSpread < 0)
        {
            spread = rHoll + " (" + f1.format(pointSpread) + ")";
        }
        
        perHome = (dif * .0114 + .5811) * 100.0;
        if(perHome >= 50)
        {
            percentage = hHoll + ": " + f.format(perHome);
        }
        else if(pointSpread < 50)
        {
            percentage = rHoll + ": " + f.format(100.0 - perHome);
        }
             
    }
    
    private void determineTeamString()
    {
        if(road.equals("Golden State Warriors"))
        {
            rHoll = "Golden State";
        }
        else if(road.equals("Oklahoma City Thunder"))
        {
            rHoll = "Oklahoma City";
        }
        else if(road.equals("San Antonio Spurs"))
        {
            rHoll = "San Antonio";
        }
        else if(road.equals("Los Angeles Clippers"))
        {
            rHoll = "LA Clippers";
        }
        else if(road.equals("New York Knicks"))
        {
            rHoll = "New York";
        }
        else if(road.equals("Los Angeles Lakers"))
        {
            rHoll = "LA Lakers";
        }
        else if(road.equals("New Orleans Pelicans"))
        {
            rHoll = "New Orleans";
        }
        else
        {
            int index1 = road.indexOf(" ");
            rHoll = road.substring(0, index1);
        }
        
        rSara = road;
        
        if(road.equals("Portland Trail Blazers"))
        {
            r538 = "Trail Blazers";
        }
        else
        {            
            int last = road.lastIndexOf(" ");
            r538 = road.substring(last + 1);
        }
        
        
        if(home.equals("Golden State Warriors"))
        {
            hHoll = "Golden State";
        }
        else if(home.equals("Oklahoma City Thunder"))
        {
            hHoll = "Oklahoma City";
        }
        else if(home.equals("San Antonio Spurs"))
        {
            hHoll = "San Antonio";
        }
        else if(home.equals("Los Angeles Clippers"))
        {
            hHoll = "LA Clippers";
        }
        else if(home.equals("New York Knicks"))
        {
            hHoll = "New York";
        }
        else if(home.equals("Los Angeles Lakers"))
        {
            hHoll = "LA Lakers";
        }
        else if(home.equals("New Orleans Pelicans"))
        {
            hHoll = "New Orleans";
        }
        else
        {
            int index1 = home.indexOf(" ");
            hHoll = home.substring(0, index1);
        }
        
        hSara = home;
        
        if(home.equals("Portland Trail Blazers"))
        {
            h538 = "Trail Blazers";
        }
        else
        {            
            int last = home.lastIndexOf(" ");
            h538 = home.substring(last + 1);
        }
           
    }
    
    public String getResult()
    {
        return result;
    }
    public String getRank1()
    {
        return rank1;
    }
    public String getRank2()
    {
        return rank2;
    }
    public String getSpread()
    {
        return spread;
    }
    public String getPercentage()
    {
        return percentage;
    }
}
