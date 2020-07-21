package day29;

public class PC{
    CPU cpu;
    HardDisk HD;

    void setCPU(CPU c){
        cpu=c;
    }
    void setHardDisk(HardDisk h){
        HD=h;
    }
    void show(){
        System.out.println(cpu.getSpeed());
        System.out.println(HD.getAmount());
    }
}
