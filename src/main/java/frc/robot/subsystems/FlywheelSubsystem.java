package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;


public class FlywheelSubsystem extends SubsystemBase {
private final FlywheelSim flysim = new FlywheelSim(DCMotor.getNEO(1), 1.0, 0.0008);    //Create root anchor points
    private final MechanismRoot2d root= mech.getRoot("FlywheelRoot",1.5,1.5);
    //Add a spinning ligament
    private final MechanismLigament2d lig=  root.append(new MechanismLigament2d("FlywheelWheel",1.0,0.0,6,new Color8Bit(Color.kAliceBlue)));
    private double degrees=0.0;

    public FlywheelSubsystem(){
        //Publish the mechanism canvas
        SmartDashboard.putData("Flywheel Mechanism",mech);
    }
    @Override
    public void simulationPeriodic(){
        flysim.update(0.02);
        //Runs automatically
        //Replace getCurrentRpm() with whichever method
        double currentRpm=flysim.getAngularVelocityRPM();

        //Increment visual angle
        degrees+=currentRpm*0.12;
        lig.setAngle(degrees);

        double angleRadians = Math.toRadians(degrees);
        Pose3d flywheelPose3d = new Pose3d(0.0, 0.0, 0.5, new Rotation3d(0, angleRadians, 0));
        SmartDashboard.putNumberArray("Flywheel3D", new double[] {
        flywheelPose3d.getX(),
        flywheelPose3d.getY(),
        flywheelPose3d.getZ(),
        flywheelPose3d.getRotation().getQuaternion().getW(),
        flywheelPose3d.getRotation().getQuaternion().getX(),
        flywheelPose3d.getRotation().getQuaternion().getY(),
        flywheelPose3d.getRotation().getQuaternion().getZ()
    });
    }
}
