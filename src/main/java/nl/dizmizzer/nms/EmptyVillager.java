package nl.dizmizzer.nms;

import net.minecraft.server.v1_8_R1.*;
import org.bukkit.craftbukkit.v1_8_R1.util.UnsafeList;

import java.lang.reflect.Field;

/**
 * Created by DizMizzer.
 * Users don't have permission to release
 * the code unless stated by the Developer.
 * You are allowed to copy the source code
 * and edit it in any way, but not distribute
 * it. If you want to distribute addons,
 * please use the API. If you can't access
 * a certain thing in the API, please contact
 * the developer in contact.txt.
 */
public class EmptyVillager extends EntityVillager {

    public EmptyVillager(World world) {
        super(world);
        try {
            Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
            bField.setAccessible(true);
            Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
            cField.setAccessible(true);

            bField.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            bField.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
            cField.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            cField.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalLookAtTradingPlayer(this));
        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 0.6D));
        this.goalSelector.a(9, new PathfinderGoalInteract(this, EntityHuman.class, 3.0F, 1.0F));
        this.goalSelector.a(9, new PathfinderGoalInteract(this, EntityVillager.class, 5.0F, 0.02F));
        this.goalSelector.a(9, new PathfinderGoalRandomStroll(this, 0.6D));
        this.goalSelector.a(10, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
    }

    @Override
    public void move(double d0, double d1, double d2) {

    }

    @Override
    public void collide(Entity entity) {
    }

    @Override
    public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    @Override
    public void g(double d0, double d1, double d2) {
    }


}



