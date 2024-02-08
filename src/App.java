class PapaKanafa {
    public String name;
    public int age;
    public String gender;
    public int wage;



    public void Application()
    {
        System.out.println(name + " : " + age + " : " + gender + " : " + "$" + wage);
    }
}


public class App {
    public static void main(String[] args) {
        PapaKanafa Juju = new PapaKanafa();
        PapaKanafa Ward = new PapaKanafa();
        PapaKanafa Mohanad = new PapaKanafa();
        PapaKanafa Meron = new PapaKanafa();
        PapaKanafa Rian = new PapaKanafa();
        PapaKanafa Mina = new PapaKanafa();

        System.out.println("Employee Name, Age, Gender, and Wage at Papa Kanafa!");

        Juju.name = "Wajd";
        Juju.age = 18;
        Juju.gender = "Female";
        Juju.wage = 15;

        Ward.name = "Ward";
        Ward.age = 18;
        Ward.gender = "Female";
        Ward.wage = 15;

        Mohanad.name = "Mohanad";
        Mohanad.age = 40;
        Mohanad.gender = "Male";
        Mohanad.wage = 100;

        Meron.name = "Meron";
        Meron.age = 18;
        Meron.gender = "Male";
        Meron.wage = 16;

        Rian.name = "Rian";
        Rian.age = 38;
        Rian.gender = "Male";
        Rian.wage = 18;

        Mina.name = "Mina";
        Mina.age = 17;
        Mina.gender = "Female";
        Mina.wage = 15; 


        Juju.Application();
        Ward.Application();
        Mohanad.Application();
        Meron.Application();
        Rian.Application();
        Mina.Application();


    }
}