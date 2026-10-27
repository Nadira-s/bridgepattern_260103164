public class Main {
    public static void main(String[] args) {
        // Task 1: the proxy checks the role before loading the image.
        Image guestImage = new ProxyImage("salary_sheet.png", "GUEST");
        Image adminImage = new ProxyImage("salary_sheet.png", "ADMIN");
        guestImage.show();
        adminImage.show();

        // Task 2: the proxy counts each play and downloads the video once.
        Video video = new ProxyVideo("Cat_Memes.mp4");
        video.play();
        System.out.println();
        video.play();
        System.out.println();
        video.play();

        // Task 3: blocked sites never reach the real internet object.
        Internet schoolInternet = new SchoolProxyInternet();
        schoolInternet.connectTo("wikipedia.org");
        schoolInternet.connectTo("gaming.com");

        // Task 4: the same remote works with a new kind of device.
        Device light = new SmartLight();
        AdvancedRemote advancedRemote = new AdvancedRemote(light);
        advancedRemote.powerOn();
        advancedRemote.mute();

        // Task 5: a new remote feature works with the existing radio.
        Device radio = new Radio();
        PartyRemote partyRemote = new PartyRemote(radio);
        partyRemote.partyMode();

        // Task 6: a knight can use different weapons without a new Knight class.
        Hero knightWithSword = new Knight(new Sword());
        knightWithSword.attack();

        Hero knightWithMagicWand = new Knight(new MagicWand());
        knightWithMagicWand.attack();
    }
}