package Ajoutepat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *main window
 * @author akentawi
 */
public class Smainint extends JFrame implements ActionListener{
     final static String AjouteMed = "Ajouter un medecin";
    final static String AjoutePat = "Ajouter un patient";
    final static String AjouteMedec = "Ajouter un medicament";
    final static String AjouteCons = "Ajouter une consultation";
    final static String ListeString = "Listes";
    final static int extraWindowWidth = 100;
    JLabel back = null;
    JLabel back2=null;
    JLabel back3=null;
    JLabel back4=null;
    Container co;
    
    static JPanel p312 = new JPanel();
    static JPanel p31=new JPanel(new GridLayout(5,2));
    static JPanel p32=new JPanel(new FlowLayout());
      static JTextField code= new JTextField();
    static JTextField libelle= new JTextField();
    static JTextField posologie= new JTextField();
    static JTextField indication= new JTextField();
    
      static JPanel p212 = new JPanel();
 static JPanel p21= new JPanel(new GridLayout(2,2));
    static JPanel p22= new JPanel(new FlowLayout());
static JTextField nomp = new JTextField(15);
    static JTextField numss= new JTextField(15);
     static JLabel b =new JLabel("nom patient");
   static JLabel d =new JLabel("numero ss");
   static JButton enregistrep = new JButton("enregistrer");

     static JPanel p412 = new JPanel();
    static JPanel p41=new JPanel(new GridLayout(4,2));
    static JPanel p42=new JPanel(new FlowLayout());
    static JLabel num=new JLabel("numero");
    static JTextField numero=new JTextField();
    static JTextField medecin= new JTextField();
    static JTextField patient= new JTextField();
    static JLabel mdc =new JLabel("medecin");
    static JLabel pat =new JLabel("patient");
    static JButton ncons = new JButton("nouvelle consultation");
    
    static JPanel p1= new JPanel();
 static JPanel p11= new JPanel(new GridLayout(2,2));
    static JPanel p12= new JPanel(new FlowLayout());
static JTextField nomm = new JTextField(15);
    static JTextField matm= new JTextField(15);
     static JLabel a =new JLabel("nom medecin");
   static JLabel c =new JLabel("matricule");
   static JButton enregistrem = new JButton("enregistrer");
    
   static JLabel cd =new JLabel("code");
   static JLabel lb =new JLabel("libelle");
   static JLabel ps =new JLabel("posologie");
   static JLabel id =new JLabel("indication");
   static JButton enregistremd = new JButton("enregistrer");

JButton amed = new JButton("ajouter medecin");
JButton amedc = new JButton("ajouter medicament");
JButton apat = new JButton("ajouter patient");
static JButton pliste = new JButton("liste des patient");
JButton acons = new JButton("ajouter consultation");
static JButton hcons = new JButton("historique des consultations");

    /**
     *
     */
    public Smainint(){

        this.setTitle ("Options");     
        this.setSize (1200,700);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        addComponentToPane(this.getContentPane());
    
pliste.addActionListener(this);
hcons.addActionListener(this);
enregistremd.addActionListener(this);
 enregistrem.addActionListener(this);
 enregistrep.addActionListener(this);
 ncons.addActionListener(this);
 BufferedImage image = null;
          try {
              image = ImageIO.read(this.getClass().getResource("1457d8b5eb4da12.jpg"));
          } catch (IOException ex) {
              Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
          }
          
 this.setIconImage(image);
 this.addWindowListener (new WindowAdapter ( )  {@Override
 public void windowClosing (WindowEvent e)        { System.exit ( 0);         } } ); 
}

    /**
     *adds cards fitted in the tabbedpane to the main pane
     * @param pane
     */
    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the "cards".
        JPanel p333 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        try {
              
             back = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("medicament.JPG"))));
          } catch (IOException ex) {
              Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
          }
     
 
     p333.add(back,BorderLayout.WEST);
     p333.add(p312,BorderLayout.EAST);
     p312.setBorder ( new TitledBorder("ajouter un medicament"));
     
 p31.add(cd);
 p31.add(code);
 p31.add(lb);
 p31.add(libelle);
 p31.add(ps);
 p31.add(posologie);
 p31.add(id);
 p31.add(indication);
 p312.add(p31,BorderLayout.NORTH);
 p32.add(enregistremd);
 p312.add(p32,BorderLayout.SOUTH);

      
 JPanel p202 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
    try {
              
             back2 = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("medecin.JPG"))));
          } catch (IOException ex) {
              Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
          }
        
 
    
    p202.add(back2,BorderLayout.WEST);
    p202.add(p1,BorderLayout.EAST);
     p1.setLayout(new GridLayout(2,2));
     p1.setBorder ( new TitledBorder("ajouter un medecin"));
     p1.add(p11,BorderLayout.NORTH);
        p11.add(a);
        p11.add(nomm);
        p11.add(c);
        p11.add(matm);
     p1.add(p12,BorderLayout.SOUTH);
        p12.add(enregistrem);
        
         JPanel p222 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
         try {
              
             back3 = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("hero.png"))));
          } catch (IOException ex) {
              Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
          }
    back.setLayout(null);
    back.setBounds(0,0,500,600);

    p222.add(back3,BorderLayout.WEST);
    p222.add(p212,BorderLayout.EAST);
     p212.setBorder ( new TitledBorder("ajouter un patient"));
        p21.add(b);
        p21.add(nomp);
        p21.add(d);
        p21.add(numss);
     p212.add(p21,BorderLayout.NORTH);
        p22.add(enregistrep);
     p212.add(p22,BorderLayout.SOUTH);
     
     
        JPanel p4 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        try{
                   back4 = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("consult.jpg"))));
          } catch (IOException ex) {
              Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
          }
        
 p4.add(back4,BorderLayout.WEST);
 
 p4.add(p412,BorderLayout.EAST);
 
 p412.setBorder ( new TitledBorder("ajouter une consultation"));

 
 
 
 p41.add(num);
 p41.add(numero);
 p41.add(mdc);
 p41.add(medecin);
 p41.add(pat);
 p41.add(patient);
 p412.add(p41,BorderLayout.NORTH);
 p42.add(ncons);
 p412.add(p42,BorderLayout.SOUTH);

      JPanel pU= new JPanel(){
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
pU.add(hcons);
pU.add(pliste);
 

        tabbedPane.addTab(AjouteMedec, p333);
        tabbedPane.addTab(AjoutePat, p222);
        tabbedPane.addTab(AjouteMed,p202);
        tabbedPane.addTab(AjouteCons,p4);
        tabbedPane.addTab(ListeString,pU);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }
 

    @Override
    public void actionPerformed(ActionEvent e) {
        
          if(e.getSource()== pliste){
 
    ListePat p = new ListePat();
    
    p.setVisible(true);

  }
               if(e.getSource()== hcons){
            Histocons h = new Histocons();
            h.setVisible(true);
               
               }
 if(e.getSource()== enregistremd){
         if(code.getText().equals("")|libelle.getText().equals("")|indication.getText().equals("")|posologie.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "completez les champs vides!");
                    }
         else{
    Medicament md = new Medicament(code.getText(),libelle.getText(),indication.getText(),posologie.getText());
    MedicamentService.createMedicament(md);
        JOptionPane.showMessageDialog(this, "medicament enregistre!");
        code.setText("");
        indication.setText("");
        posologie.setText("");
        libelle.setText("");
   
   }}   

  if(e.getSource()== enregistrem){
        if(nomm.getText().equals("")|matm.getText().equals("")){
        JOptionPane.showMessageDialog(this,"completez les champs vides!");
        }
        else{
    Medecin m = new Medecin(nomm.getText(),Integer.parseInt(matm.getText()));
    MedecinService.createMedecin(m);
        JOptionPane.showMessageDialog(this, "medecin enregistre!");
        matm.setText("");
        nomm.setText("");
       
    }}
   if(e.getSource()== enregistrep){
          if(nomp.getText().equals("")|numss.getText().equals("")){
        JOptionPane.showMessageDialog(this,"completez les champs vides!");
        }
          else{
    Patient p = new Patient(nomp.getText(),Integer.parseInt(numss.getText()));
    PatientService.createPatient(p);
        JOptionPane.showMessageDialog(this, "patient enregistre!");
        numss.setText("");
        nomp.setText("");
        
    }}
       if(e.getSource()== ncons){  
              if(medecin.getText().equals("")|patient.getText().equals("")|numero.getText().equals("")){
        JOptionPane.showMessageDialog(this,"completez les champs vides!");
        }
              else{
     Consultation cons = new Consultation(Integer.parseInt(medecin.getText()),Integer.parseInt(patient.getText()),Integer.parseInt(numero.getText()));
     ConsultationService.createConsultation(cons);
     PrescritGUI prs = new PrescritGUI();
     
     prs.setVisible(true);
     

                   
 
 }}
 
    
}
    }
