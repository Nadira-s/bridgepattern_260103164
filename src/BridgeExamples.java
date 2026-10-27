interface Device {
    void turnOn();

    void turnOff();

    void setVolume(int level);
}

class SmartLight implements Device {
    @Override
    public void turnOn() {
        System.out.println("Smart Light glows bright white.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Light shuts off.");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Smart Light brightness set to: " + level + "%");
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio starts playing static/music.");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio turns off.");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Radio volume knob turned to: " + level);
    }
}

class BasicRemote {
    protected final Device device;

    BasicRemote(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.turnOn();
    }

    public void powerOff() {
        device.turnOff();
    }
}

class AdvancedRemote extends BasicRemote {
    AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("[Remote] Mute button pressed!");
        device.setVolume(0);
    }
}

class PartyRemote extends BasicRemote {
    public PartyRemote(Device device) {
        super(device);
    }

    public void partyMode() {
        System.out.println("[Party Remote] Pumping up the party!");
        device.turnOn();
        device.setVolume(100);
    }
}

interface Weapon {
    void use();
}

class Sword implements Weapon {
    @Override
    public void use() {
        System.out.println("Slash! Dealing 20 physical damage.");
    }
}

class MagicWand implements Weapon {
    @Override
    public void use() {
        System.out.println("Zap! Dealing 35 magic damage.");
    }
}

abstract class Hero {
    protected final Weapon weapon;

    Hero(Weapon weapon) {
        this.weapon = weapon;
    }

    public abstract void attack();
}

class Knight extends Hero {
    Knight(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void attack() {
        weapon.use();
    }
}

class Wizard extends Hero {
    Wizard(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void attack() {
        weapon.use();
    }
}