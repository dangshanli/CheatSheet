package typeinfo.methodinfo;

import java.util.*;

/**
 * @author luzj
 * @description:
 * @date 2019/4/18
 */
public class Doctor extends Human {
    private List<Patient> patients = new ArrayList<>();
    private Skill skill;
    private List<Patient> cured = new ArrayList<>();

    public Doctor(String name,Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public void addPatient(Patient p) {
        if (Objects.nonNull(p))
            patients.add(p);
    }


    public void cureOnePerson() {
        if (patients.size() > 0) {
            Patient p = patients.remove(0);
            if (p.state == State.BAD) {
                p.state = State.GOOD;
                System.out.println(p.getName()+",you are cured now.");
            }
            else
                System.out.println(p.getName()+",you are always good.");
            cured.add(p);
        }
    }

    private String justAcceptBribes(int dollar){
        return "private method invoke "+dollar;
    }

    void testDefaultMethod(){}


    @Override
    public void say() {
        System.out.println("i cure " + cured.size() + " person,they are all good now!!!");
        System.out.println("name list:");
        cured.stream().forEach(t->{
            System.out.println("\t"+t.name+" are "+t.state+" now!");
        });
        cured.removeAll(cured);
    }

    public static void main(String[] args) {
        Doctor doctor = new Doctor("NiPing",Skill.TOP);
        doctor.addPatient(new Patient("YunYun",State.BAD));
        doctor.addPatient(new Patient("Hui",State.BAD));
        doctor.addPatient(new Patient("Ban",State.GOOD));
        doctor.addPatient(new Patient("Camilla",State.BAD));
        doctor.cureOnePerson();
        doctor.cureOnePerson();
        doctor.cureOnePerson();
        doctor.say();
    }
}
