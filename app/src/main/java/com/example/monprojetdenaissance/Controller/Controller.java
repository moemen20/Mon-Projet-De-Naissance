package com.example.monprojetdenaissance.Controller;

import com.example.monprojetdenaissance.model.Patient.Patient_InfoPerso;
import com.example.monprojetdenaissance.model.Patient.Patient_Prenatal;
import com.example.monprojetdenaissance.model.Patient.Patient_Post;
import com.example.monprojetdenaissance.model.Patient.Patient_Accouchement;
import com.example.monprojetdenaissance.model.Patient.Patient_Travail;
public class Controller {
    private static Patient_InfoPerso patientInfoPerso;
    private static Patient_Prenatal patientPrenatal;
    private static Patient_Post patientPost;
    private static Patient_Accouchement patientAccouchement;
    private static Patient_Travail patientTravail;

    private static Controller instance = null;
    private Controller(){
        super();
    }


    public static final Controller getInstance(){
        if(instance==null)
            instance = new Controller();
        return instance;
    }
    public void createPatientInfoPerso(String name,String last_name,String doctor_name,String sexe_baby,String baby_name,String Husband_name,String Husband_LastName,String date_acc,long Husband_Number){
        patientInfoPerso = new Patient_InfoPerso(name, last_name, doctor_name, sexe_baby, baby_name, Husband_name, Husband_LastName,date_acc, Husband_Number);
    }
    public void createPatientPrenatal(Boolean a,Boolean b,Boolean c,Boolean d,Boolean e,Boolean j,Boolean k,Boolean l,Boolean m,Boolean f,Boolean g,Boolean h,Boolean i,Boolean oui){
        patientPrenatal = new Patient_Prenatal( a,b,c,d,e,j,k,l,m,f,g,h,i,oui);
    }
    public void createPatientPost(boolean oui_1,boolean non_1,boolean oui_22,boolean non_22,boolean oui_33,boolean non_33,boolean oui_44,boolean non_44,boolean DIU,boolean Pilule,boolean Dépopnovera,boolean Implanon,boolean contraception,boolean locaux){
        patientPost = new Patient_Post( oui_1,non_1,oui_22,non_22,oui_33,non_33,oui_44,non_44,DIU,Pilule,Dépopnovera,Implanon,contraception,locaux);
    }
    public void createPatientAccouchement(boolean aaaa,boolean bbbb,boolean cccc,boolean dddd,boolean eeee,boolean ffff,boolean gggg,boolean hhhh,boolean voie_basse,boolean cesarienne,boolean oui_2,boolean non_2,boolean oui_4,boolean non_4,boolean oui_6,boolean non_6,boolean oui_7,boolean non_7){
        patientAccouchement = new Patient_Accouchement( aaaa,bbbb,cccc,dddd,eeee,ffff,gggg,hhhh,voie_basse,cesarienne,oui_2,non_2,oui_4,non_4,oui_6,non_6,oui_7,non_7);
    }
    public void createPatientTravail(boolean aa,boolean bb,boolean cc,boolean aaa,boolean bbb,boolean ccc,boolean ddd,boolean eee,boolean fff,boolean ggg,boolean dd,boolean ee,boolean ff,boolean gg,boolean hh,boolean oui,boolean necessaire,boolean continu,boolean Intermittent,boolean recommandation,boolean necessite,boolean oui_9,boolean non_9){
        patientTravail = new Patient_Travail( aa,bb,cc,aaa,bbb,ccc,ddd,eee,fff,ggg,dd,ee,ff,gg,hh,oui,necessaire,continu,Intermittent,recommandation,necessite,oui_9,non_9);
    }


}
