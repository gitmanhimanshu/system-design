// class Main {
//     public static void main(String[] args) {
//         Light light = new Light();

//         LightOnCommand lightOn = new LightOnCommand(light);
//         LightOffCommand lightOff = new LightOffCommand(light);

//         RemoteControl remote = new RemoteControl();

//         remote.setCommand(lightOn);
//         remote.pressButton();

//         remote.setCommand(lightOff);
//         remote.pressButton();
//     }
// }
class Main{
    public static void main(String args[]){
        Light light=new Light();
        LightOnCommand on=new LightOnCommand(light);
        LightOffCommand off=new LightOffCommand(light);
        RemoteControl remote=new RemoteControl();
        remote.setCommand(on);
        remote.press();
        remote.setCommand(off);
        remote.press();
    }
}