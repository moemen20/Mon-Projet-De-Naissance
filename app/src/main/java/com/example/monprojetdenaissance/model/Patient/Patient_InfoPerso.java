package com.example.monprojetdenaissance.model.Patient;

import java.util.Date;

public class Patient_InfoPerso {
    private String date_acc, name, last_name, doctor_name, sexe_baby, baby_name, Husband_name, Husband_LastName;
    private long Husband_Number;

    public Patient_InfoPerso(String name, String last_name, String doctor_name, String sexe_baby, String baby_name, String Husband_name, String Husband_LastName, String date_acc, long Husband_Number){
        this.name=name;
        this.last_name=last_name;
        this.doctor_name=doctor_name;
        this.sexe_baby=sexe_baby;
        this.baby_name=baby_name;
        this.Husband_name=Husband_name;
        this.Husband_LastName=Husband_LastName;
        this.date_acc=date_acc;
        this.Husband_Number=Husband_Number;
    }
    public String get_name(){
        return this.name;
    }
    public String get_last_name(){
        return this.last_name;
    }
    public String get_doctor_name(){
        return this.doctor_name;
    }
    public String get_sexe_baby(){
        return this.sexe_baby;
    }
    public String get_baby_name(){
        return this.baby_name;
    }
    public String get_husband_name(){
        return this.Husband_name;
    }
    public String get_husband_last_name(){
        return this.Husband_LastName;
    }
    public long get_number(){
        return this.Husband_Number;
    }
    public String get_date(){
        return this.date_acc;
    }

}
