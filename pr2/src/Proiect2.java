import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.*;


class Cana { // creez 2 constructori intr-o clasa.

    String culoare;
    int cantitate;
    String unitdemas;

    public Cana() {   // primul constructor , cu valori predefinite.
        this.culoare = "Alba";
        this.cantitate = 266;
        this.unitdemas = "ml";
    }

    public Cana(String culoare, int cantitate, String unitdemas) { // al doilea constructor
        this.culoare = culoare;
        this.cantitate = cantitate;
        this.unitdemas = unitdemas;
    }

    //set
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setUnitdemas(String unitdemas) {
        this.unitdemas = unitdemas;
    }

    //get
    public String getCuloare() {
        return culoare;
    }

    public int getCantitate() {
        return cantitate;
    }

    public String getUnitdemas() {
        return unitdemas;
    }

    //folosesc metota toString si clasa StringBuffer
    public String toString() {

        StringBuffer cana = new StringBuffer("Cana are culoarea: ");
        cana.append(culoare);
        cana.append(" Cantitate: ");
        cana.append(cantitate);
        cana.append(" Unitatea de masura: ");
        cana.append(unitdemas);
        return cana.toString();
    }
}

public class Proiect2 {  // Aici sunt componentele panel-urilor.
    private JPanel rootPanel;
    private JLabel lblCuloare;
    private JTextField txtCuloare;
    private JLabel lblCantitate;
    private JTextField txtCantitate;
    private JLabel lblUnitdemas;
    private JTextField txtUnitdemas;
    private JButton btnCustom;
    private JButton btnConfirm;
    private JButton btnCancel;
    private JLabel lblModelecani;
    private JLabel lblmodel1;
    private JLabel lblmodel2;
    private JLabel lblmodel3;
    private JLabel lblmodel4;
    private JPanel custom;
    private JLabel lblCuloarecana;
    private JTextField txtCuloarecana;
    private JLabel lblCantitatecana;
    private JTextField txtCantitateCana;
    private JLabel lblUnitdemascana;
    private JTextField txtUnitdemascana;
    private JButton btnTrimitecomanda;
    private JButton cancelbtn;
    private JPanel panel;


    public Proiect2() {
        // creez cateva date pentru a le introduce in prima fereastra care apare, pentru a le putea verifica ulterior.
        Cana cana1=new Cana();
        Cana cana2=new Cana("Verde",500,"ml");
        Cana cana3=new Cana("Albastra",200,"ml");
        Cana cana4=new Cana("Rosie",2,"l");
        // le adaug in fereastra
        lblmodel1.setText("1. "+cana1.culoare+" "+cana1.cantitate+" "+cana1.unitdemas);
        lblmodel2.setText("2. "+cana2.culoare+" "+cana2.cantitate+" "+cana2.unitdemas);
        lblmodel3.setText("3. "+cana3.culoare+" "+cana3.cantitate+" "+cana3.unitdemas);
        lblmodel4.setText("4. "+cana4.culoare+" "+cana4.cantitate+" "+cana4.unitdemas);


        //pentru butonul "Confirm" folosesc datele de mai sus, si in functie de ce scriem in Jtextfield-uri ne va aparea un mesaj.
        //Pe scurt am facut un fel de verificator de stoc-uri pentru produsul "cana".

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String y=txtCuloare.getText();  // y este continutul introdus in prima casuta.
                String z=txtUnitdemas.getText(); // z este continutul introdus in a treia casuta.
                int x=Integer.parseInt(txtCantitate.getText()); // x este continutul introdus in a treia casuta.

                // aici m-am folosit de functiile "if", "else if" si "else", pentru a verifica daca detaliile introduse de noi corespund cu cele din dreapta.
                if(y.equals(cana1.culoare) && x==(cana1.cantitate) && z.equals(cana1.unitdemas)) {
                    JOptionPane.showMessageDialog(null , "Ati ales cana alba de 266 de mililitri", "Stoc",
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else if(txtCuloare.getText().equals(cana2.culoare) && x==(cana2.cantitate) && txtUnitdemas.getText().equals(cana2.unitdemas)){
                    JOptionPane.showMessageDialog(null , "Ati ales cana verde de 500 de mililitri.", "Stoc",
                            JOptionPane.INFORMATION_MESSAGE);
                }
               else if(txtCuloare.getText().equals(cana3.culoare) && x==(cana3.cantitate) && txtUnitdemas.getText().equals(cana3.unitdemas)){
                    JOptionPane.showMessageDialog(null , "Ati ales cana albastra de 200 de mililitri.", "Stoc",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if(txtCuloare.getText().equals(cana4.culoare) && x==(cana4.cantitate) && txtUnitdemas.getText().equals(cana4.unitdemas)){
                    JOptionPane.showMessageDialog(null , "Ati ales cana rosie de 2 de litri.", "Stoc",
                            JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Cana pe care ati ales-o nu este pe stoc!");
                }



            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);                        // cand apasam pe "Cancel" se opreste programul.
            }
        });

        btnCustom.addActionListener(new ActionListener() {  // cand apasam pe butonul "Cana Custom" se deschide a doua fereastra
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Custom");
                frame.setContentPane(new Proiect2().custom);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);                     // cand apasam pe cancel se opreste programul.
            }
        });
        btnTrimitecomanda.addActionListener(new ActionListener() {  // cand apasam butonul "Trimite comanda" ne va aparea un mesaj de confirmare,
            @Override                                               // luand datele pe care le-am introdus in jtextfield-urile din a doua fereastra.
            public void actionPerformed(ActionEvent e) {
                String a=txtCuloarecana.getText();
                int b=Integer.parseInt(txtCantitateCana.getText());
                String c=txtUnitdemascana.getText();
                JOptionPane.showMessageDialog(null, "Comanda pentru cana a fost plasta, detaliile sunt urmatoarele: \nCuloare: "+a+" \nCantitate: "+b+" \nUnitatea de masura: "+c );

            }
        });
    }

    public static void main(String[] args) {
        // folosesc constructorii creati in clasa "Cana"
        Cana cana1= new Cana();
        Cana cana2=new Cana("Verde",500,"ml");
        System.out.println("Prima cana:\nCuloare: "+cana1.culoare + " Cantitate: " + cana1.cantitate + " Unitatea de masura: " + cana1.unitdemas +"\n");
        System.out.println("A doua cana:\nCuloare: "+cana2.culoare + " Cantitate: " + cana2.cantitate + " Unitatea de masura: " + cana2.unitdemas +"\n");

        // folosesc set si get.
        Cana cana3=new Cana();
        cana3.setCuloare("Rosu");
        cana3.setCantitate(1);
        cana3.setUnitdemas("l");
        System.out.println("A treia cana: \nCuloare: "+ cana3.getCuloare() + " Cantitate: "+cana3.getCantitate()+" Unitatea de masura: "+cana3.getUnitdemas()+"\n");

        // folosesc metoda toString
        System.out.println(cana1.toString() + "\n");


        ArrayList<Cana> list=new ArrayList<>();  // folosesc clasa ArrayList, am adaugat in lista pe baza constroctorului 3 obiecte, iar pe urma le afisez .

        list.add(new Cana("Albastru",200,"ml\n"));
        list.add(new Cana("Galben",2,"l\n"));
        list.add(new Cana("Visiniu",800,"ml"));
            System.out.println(list);

            //creez primua fereastra.
            JFrame frame = new JFrame("Shop Cana");
            frame.setContentPane(new Proiect2().panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
    }
}



