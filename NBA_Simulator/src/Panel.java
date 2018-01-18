import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Scanner;

public class Panel extends JPanel implements ActionListener
{
    private String awayTeam, homeTeam, result, rank1, rank2, spread, percentage;
    private boolean isPressed;
    private JComboBox<String> teamsAway, teamsHome;
    private Image logo, scaled;

    public Panel() throws Exception
    {        
        setLayout(null);
        
        isPressed = false;
        
        JButton button = new JButton("Simulate Game");
        button.addActionListener(this);
        button.setLocation(150, 250);
        button.setSize(200, 50);
        add(button);
        
        String[] array = {"Boston Celtics", "Brooklyn Nets", "New York Knicks", "Philadelphia 76ers", "Toronto Raptors", "Chicago Bulls",
            "Cleveland Cavaliers", "Detroit Pistons", "Indiana Pacers", "Milwaukee Bucks", "Atlanta Hawks",
            "Charlotte Hornets", "Miami Heat", "Orlando Magic", "Washington Wizards", "Golden State Warriors",
            "Los Angeles Clippers", "Los Angeles Lakers", "Phoenix Suns", "Sacramento Kings", "Dallas Mavericks",
            "Houston Rockets", "Memphis Grizzlies", "New Orleans Pelicans", "San Antonio Spurs", "Denver Nuggets",
            "Minnesota Timberwolves", "Oklahoma City Thunder", "Portland Trail Blazers", "Utah Jazz"};
        teamsAway = new JComboBox<String>(array);
        teamsAway.setSelectedIndex(0);
        this.add(teamsAway);
        teamsAway.setBounds(20,70, 150, 20);
        teamsHome = new JComboBox<String>(array);
        teamsHome.setSelectedIndex(0);
        this.add(teamsHome);
        teamsHome.setBounds(200,70, 150, 20);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        try 
        {
            awayTeam = (String)teamsAway.getSelectedItem();
            homeTeam = (String)teamsHome.getSelectedItem();
            MultGameSim sim = new MultGameSim(awayTeam, homeTeam);
            isPressed = true;
            spread = sim.getSpread();
            percentage = sim.getPercentage();
            rank1 = sim.getRank1();
            rank2 = sim.getRank2();
            
            repaint();
            
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);        
        g.setColor(Color.BLACK);
        g.fillRect(50,100,300,73);
        g.drawString("Select Away Team", 20, 60);
        g.drawString("Select Home Team", 200, 60);
        g.setColor(Color.GRAY);
        g.fillRect(50,173,300,73);
        
        if(isPressed == true)
        {
            g.setColor(Color.WHITE);
            g.drawString("Noah Rankings: ", 55, 125);
            g.drawString(rank1, 55, 145);
            g.drawString(rank2, 55, 165);
            g.setColor(Color.BLACK);
            g.drawString("Results: ", 55, 190);
            g.drawString(percentage, 55, 210);
            g.drawString(spread, 55, 230);
        }
        
        g.setColor(Color.BLACK);
        Font font1 = new Font(g.getFont().getFontName(), Font.BOLD, 18);
        g.setFont(font1);
        g.drawString("NOAH RANKINGS NBA SIMULATOR", 25, 30);
        
        g.drawImage(scaled, 365, 15, this);
    }

}
