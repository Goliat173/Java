import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class PowerOff {
	Robot robot;
	
    public PowerOff() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.err.println("Co ten robot wyprawia?!");
            e.printStackTrace();
        }
    }
 

    public void wakeUp() {
            robot.delay(200);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.delay(500);
    }
 
    public void mouseStart() {
    	robot.mouseMove(-500,1500);
    	robot.delay(200);
    }
    
    private void mouseClick() {
    	robot.delay(100);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(100);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(500);
	}
    
    public void mousePower() {
    	robot.mouseMove(-500,700);
    	robot.delay(500);
    }
    
    public void mousePowerOff() {
    	robot.mouseMove(10,620);
    	robot.delay(500);
    }
    
    public void run(){
    	robot.delay(2000);
        wakeUp();
        mouseStart();
        mouseClick();
        mousePower();
        mouseClick();
        mousePowerOff();
        mouseClick();
    }
    

    public static void main(String[] args) throws InterruptedException {
    	PowerOff test = new PowerOff();
    	Scanner skaner = new Scanner(System.in);
    	
        System.out.println("Za ile MINUT wy³¹czyc komputer??? \n :");
        int czas= skaner.nextInt();
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        System.out.println("Rozpoczeto procedure wylaczania... \n Komputer zostanie wy³aczony po" 
        + czas + " minucie od: " + data.format(new Date()) );
        TimeUnit.MINUTES.sleep(czas);
        test.run();
    }
    
    
}

	
