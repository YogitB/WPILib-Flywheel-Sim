package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
public class FlywheelSubsystem {
    //Create the canvas
    private final Mechanism2d mech= new Mechanism2d(3,3);
    //Create root anchor points
    private final MechanismRoot2d root= mech.getRoot("FlywheelRoot",1.5,1.5);
    //Add a spinning ligament
    private final MechanismLigament2d lig=  root.append(new MechanismLigament2d("FlywheelWheel",1.0,0.0,6,new Color8Bit(Color.kAliceBlue)));
    public FlywheelSubsystem(){
        //Publish the mechanism canvas
        SmartDashboard.putData("Flywheel Mechanism",mech);
    }
}
